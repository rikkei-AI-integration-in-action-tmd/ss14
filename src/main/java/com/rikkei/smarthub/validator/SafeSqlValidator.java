package com.rikkei.smarthub.validator;

import com.rikkei.smarthub.dto.mcp.SafeSqlValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

@Component
public class SafeSqlValidator {

    private static final Logger log = LoggerFactory.getLogger(SafeSqlValidator.class);

    private static final List<String> FORBIDDEN_KEYWORDS = Arrays.asList(
            "DROP", "DELETE", "UPDATE", "ALTER", "INSERT", "TRUNCATE",
            "CREATE", "GRANT", "REVOKE", "EXEC", "EXECUTE", "SHUTDOWN",
            "INTO OUTFILE", "INTO DUMPFILE", "PG_SLEEP"
    );

    private static final Pattern MULTI_STATEMENT_PATTERN = Pattern.compile(";\\s*\\S+");
    private static final Pattern LIMIT_PATTERN = Pattern.compile("(?i)\\bLIMIT\\s+(\\d+)", Pattern.CASE_INSENSITIVE);

    public SafeSqlValidationResult validateAndSanitize(String sql, int defaultMaxLimit) {
        if (sql == null || sql.trim().isEmpty()) {
            return SafeSqlValidationResult.builder()
                    .valid(false)
                    .reason("Câu lệnh SQL không được để trống")
                    .violationType("EMPTY_QUERY")
                    .build();
        }

        String trimmedSql = sql.trim();
        String upperSql = trimmedSql.toUpperCase(Locale.ROOT);

        if (!upperSql.startsWith("SELECT") && !upperSql.startsWith("WITH")) {
            return SafeSqlValidationResult.builder()
                    .valid(false)
                    .reason("Chỉ cho phép thực thi câu lệnh truy vấn đọc dữ liệu (SELECT/WITH)")
                    .violationType("NON_SELECT_QUERY")
                    .build();
        }

        if (MULTI_STATEMENT_PATTERN.matcher(trimmedSql).find()) {
            return SafeSqlValidationResult.builder()
                    .valid(false)
                    .reason("Không cho phép thực thi nhiều câu lệnh cùng lúc (Multi-statement detected)")
                    .violationType("MULTI_STATEMENT_ATTEMPT")
                    .build();
        }

        for (String keyword : FORBIDDEN_KEYWORDS) {
            String wordBoundaryRegex = "\\b" + Pattern.quote(keyword) + "\\b";
            if (Pattern.compile(wordBoundaryRegex, Pattern.CASE_INSENSITIVE).matcher(trimmedSql).find()) {
                log.warn("Cảnh báo bảo mật: Phát hiện từ khóa bị cấm '{}' trong truy vấn: {}", keyword, trimmedSql);
                return SafeSqlValidationResult.builder()
                        .valid(false)
                        .reason("Phát hiện từ khóa nguy hiểm bị cấm: " + keyword)
                        .violationType("FORBIDDEN_KEYWORD_" + keyword)
                        .build();
            }
        }

        String sanitizedSql = trimmedSql.replaceAll(";\\s*$", "");
        var matcher = LIMIT_PATTERN.matcher(sanitizedSql);
        if (matcher.find()) {
            int existingLimit = Integer.parseInt(matcher.group(1));
            if (existingLimit > defaultMaxLimit) {
                sanitizedSql = matcher.replaceFirst("LIMIT " + defaultMaxLimit);
            }
        } else {
            sanitizedSql = sanitizedSql + " LIMIT " + defaultMaxLimit;
        }

        return SafeSqlValidationResult.builder()
                .valid(true)
                .sanitizedSql(sanitizedSql)
                .reason("Truy vấn an toàn và hợp lệ")
                .build();
    }
}

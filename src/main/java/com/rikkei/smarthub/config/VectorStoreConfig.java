package com.rikkei.smarthub.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class VectorStoreConfig {

    private static final Logger log = LoggerFactory.getLogger(VectorStoreConfig.class);

    @Bean
    public ApplicationRunner vectorStoreSchemaChecker(JdbcTemplate jdbcTemplate, EmbeddingModel embeddingModel) {
        return args -> {
            try {
                alignVectorStoreDimension(jdbcTemplate, embeddingModel);
            } catch (Exception e) {
                log.warn("Không thể kiểm tra/đồng bộ tự động schema vector_store lúc khởi động: {}", e.getMessage());
            }
        };
    }

    private static void alignVectorStoreDimension(JdbcTemplate jdbcTemplate, EmbeddingModel embeddingModel) {
        try {
            float[] sampleVector = embeddingModel.embed("test");
            int targetDimension = sampleVector.length;
            log.info("Mô hình EmbeddingModel đang hoạt động tạo vector số chiều = {}", targetDimension);

            Boolean tableExists = jdbcTemplate.queryForObject(
                    "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_schema = 'public' AND table_name = 'vector_store')",
                    Boolean.class
            );

            if (Boolean.TRUE.equals(tableExists)) {
                String formatType = jdbcTemplate.queryForObject(
                        "SELECT format_type(atttypid, atttypmod) FROM pg_attribute WHERE attrelid = 'vector_store'::regclass AND attname = 'embedding'",
                        String.class
                );

                String expectedType = "vector(" + targetDimension + ")";
                log.info("Kiểu dữ liệu cột embedding hiện tại trên DB: '{}', Kỳ vọng theo Model: '{}'", formatType, expectedType);

                if (formatType != null && !formatType.equalsIgnoreCase(expectedType)) {
                    log.warn("Mâu thuẫn Dimension! Bảng 'vector_store' có kiểu '{}', nhưng Model yêu cầu '{}'. Khởi tạo lại bảng...",
                            formatType, expectedType);
                    jdbcTemplate.execute("DROP TABLE IF EXISTS vector_store CASCADE");
                    log.info("Đã DROP bảng 'vector_store' cũ. PgVectorStore sẽ tự động tạo lại bảng mới với kiểu '{}'.", expectedType);
                } else {
                    log.info("Bảng 'vector_store' trên CSDL đã hoàn toàn tương thích với Model ({})", expectedType);
                }
            }
        } catch (Exception e) {
            log.warn("Lưu ý: Bỏ qua kiểm tra schema vector_store do: {}", e.getMessage());
        }
    }
}

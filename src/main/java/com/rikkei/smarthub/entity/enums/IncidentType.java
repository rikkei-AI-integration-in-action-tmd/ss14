package com.rikkei.smarthub.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IncidentType {
    HONG_HOC("HỎNG_HÓC"),
    GIAO_TRE("GIAO_TRỄ"),
    THAT_LAC("THẤT_LẠC");

    private final String value;

    IncidentType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static IncidentType fromString(String text) {
        if (text == null) {
            return null;
        }
        for (IncidentType type : IncidentType.values()) {
            if (type.name().equalsIgnoreCase(text) || type.value.equalsIgnoreCase(text)) {
                return type;
            }
        }
        return HONG_HOC;
    }
}

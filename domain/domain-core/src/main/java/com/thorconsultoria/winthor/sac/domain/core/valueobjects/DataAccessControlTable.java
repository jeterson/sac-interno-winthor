package com.thorconsultoria.winthor.sac.domain.core.valueobjects;

import java.util.Arrays;

public enum DataAccessControlTable {

    FILIAL("1"),
    COBRANCA("200"),
    NONE("-99");

    DataAccessControlTable(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public static DataAccessControlTable of(String value) {
        var item = Arrays.asList(DataAccessControlTable.values())
                .stream().filter(x -> x.getValue().equals(value))
                .findFirst();
        return item.orElse(null);
    }
}

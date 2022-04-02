package org.example.repository;

import lombok.Getter;

@Getter
public enum TableNames {
    USERS("SELECT * FROM Users ORDER BY createdAt"),
    RECORDS("SELECT * FROM Records");

    private final String value;

    TableNames(String value) {
        this.value = value;
    }
}

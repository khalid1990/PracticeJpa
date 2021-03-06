package com.babar.db.common.enums;

/**
 * @author babar
 * @since 3/8/17.
 */
public enum Language {

    ENGLISH("English"),
    BENGALI("Bengali");

    String name;

    Language(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

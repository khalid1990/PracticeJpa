package com.babar.common.enums;

/**
 * @author babar
 * @since 3/8/17.
 */
public enum ExamType {

    REGULAR("Regular Examination"),
    PRACTICE("Practice Examination");

    String name;

    ExamType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
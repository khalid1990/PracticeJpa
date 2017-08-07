package com.babar.db.common.enums;

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

    @Override
    public String toString() {
        return name;
    }
}

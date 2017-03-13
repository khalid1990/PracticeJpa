package com.babar.common.enums;

/**
 * @author babar
 * @since 3/12/17.
 */
public enum ExamCategory {
    BCS("BCS Preliminary Examination"),
    MEDICAL_ADMISSION_TEST("Medical Admission Test"),
    UNIVERSITY_ADMISSION_TEST("University Admission Test"),
    COMPUTER_SCIENCE_AND_ENGINEERING("Computer Science And Engineering");

    String name;

    ExamCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.babar.common.enums;

import static com.babar.common.enums.ExamCategory.*;

/**
 * @author babar
 * @since 3/12/17.
 */
public enum ExamSubCategory {
    BENGALI("Bengali Language and Literature", 1, BCS),
    ENGLISH("English Language and Literature", 2, BCS),
    BANGLADESH_AFFAIRS("National Affair", 3, BCS),
    INTERNATIONAL_AFFAIRS("International Affair", 4, BCS),
    GEOGRAPHY_ENVIRONMENT("Geography Environment and Disaster Management", 5, BCS),
    GENERAL_SCIENCE("General Science", 6, BCS),
    MATH("Mathematical Reasoning", 7, BCS),
    MENTAL_ABILITY("Mental Ability", 8, BCS),
    ETHICS("Ethics Values and Good Governance ", 9, BCS);

    String name;

    int id;

    ExamCategory examCategory;

    ExamSubCategory(String name, int id, ExamCategory examCategory) {
        this.name = name;
        this.id = id;
        this.examCategory = examCategory;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ExamCategory getExamCategory() {
        return examCategory;
    }
}

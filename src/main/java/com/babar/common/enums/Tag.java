package com.babar.common.enums;

import static com.babar.common.enums.ExamCategory.*;
import static com.babar.common.enums.ExamSubCategory.*;

/**
 * @author babar
 * @since 3/13/17.
 */
public enum Tag {

    BENGALI_GRAMMAR("Bengali Grammar", 1, BCS, BENGALI),
    BENGALI_LITERATURE("Bengali Literature", 2, BCS, BENGALI),
    ENGLISH_GRAMMAR("English Grammar", 3, BCS, ENGLISH),
    ENGLISH_LITERATURE("English Literature", 4, BCS, ENGLISH);

    String name;

    int id;

    ExamCategory examCategory;

    ExamSubCategory examSubCategory;

    Tag(String name, int id, ExamCategory examCategory, ExamSubCategory examSubCategory) {
        this.name = name;
        this.id = id;
        this.examCategory = examCategory;
        this.examSubCategory = examSubCategory;
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

    public ExamSubCategory getExamSubCategory() {
        return examSubCategory;
    }
}

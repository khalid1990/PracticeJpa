package com.babar.db.common.enums;

import java.util.ArrayList;
import java.util.List;

import static com.babar.db.common.enums.ExamCategory.*;

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
    ETHICS("Ethics Values and Good Governance ", 9, BCS),

    ALGORITHM("Algorithm", 10, COMPUTER_SCIENCE_AND_ENGINEERING),
    DATA_STRUCTURE("Data Structure", 11, COMPUTER_SCIENCE_AND_ENGINEERING),
    DIGITAL_LOGIC_DESIGN("Digital Logic Design", 12, COMPUTER_SCIENCE_AND_ENGINEERING),
    DISCRETE_MATH("Discrete Mathematics", 13, COMPUTER_SCIENCE_AND_ENGINEERING),
    COMPUTER_INTRODUCTION("Introduction to Computer", 14, COMPUTER_SCIENCE_AND_ENGINEERING),
    TOC("Theory of Computation", 15, COMPUTER_SCIENCE_AND_ENGINEERING),
    COMPILER("Compiler Design", 16, COMPUTER_SCIENCE_AND_ENGINEERING),
    NETWORKING("Computer Networking", 17, COMPUTER_SCIENCE_AND_ENGINEERING),
    OS("Operating System", 18, COMPUTER_SCIENCE_AND_ENGINEERING),
    GRAPHICS("Computer Graphics", 19, COMPUTER_SCIENCE_AND_ENGINEERING),
    ISD("Information System Design", 20, COMPUTER_SCIENCE_AND_ENGINEERING),
    DATABASE("Database Design and Concepts", 21, COMPUTER_SCIENCE_AND_ENGINEERING),
    DATA_COM("Data Communication", 2, COMPUTER_SCIENCE_AND_ENGINEERING);

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

    public static List<ExamSubCategory> getSubCategories(ExamCategory examCategory) {
        List<ExamSubCategory> subCategories = new ArrayList<>();
        for (ExamSubCategory subCategory : ExamSubCategory.values()) {
            if (subCategory.examCategory == examCategory) {
                subCategories.add(subCategory);
            }
        }

        return subCategories;
    }
}

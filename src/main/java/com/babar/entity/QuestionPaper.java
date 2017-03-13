package com.babar.entity;

import com.babar.common.enums.ExamCategory;
import com.babar.common.enums.ExamType;
import com.babar.common.enums.Language;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author babar
 * @since 2/23/17.
 */
@Entity
public class QuestionPaper extends Persistence{

    @Id
    @GeneratedValue
    private int id;

    private String examTitle;

    private int examSerial;

    private Date examDate;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @Enumerated(EnumType.STRING)
    private Language lang;

    @Enumerated(EnumType.STRING)
    private ExamType examType;

    @Enumerated(EnumType.STRING)
    private ExamCategory examCategory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionPaper")
    private List<Question> questions;

    private int totalTimeInSeconds;

    private int totalQuestions;

    private int marksPerQuestion;

    private int totalMarks;

    private double negativeMarkingPercentage;

    private String instruction;
}

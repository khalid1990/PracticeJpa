package com.babar.entity;

import com.babar.common.enums.ExamSubCategory;

import javax.persistence.*;
import java.util.List;

/**
 * @author babar
 * @since 3/12/17.
 */
@Entity
public class Question extends Persistence{

    @Id
    @GeneratedValue
    private int id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private List<QuestionOption> questionOptions;

    @ManyToOne
    @JoinColumn(name = "question_paper_id")
    private QuestionPaper questionPaper;

    @Enumerated(EnumType.STRING)
    private ExamSubCategory examSubCategory;

    private String hint;

    private int serialNumber;
}

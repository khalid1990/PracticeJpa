package com.babar.db.entity;

import com.babar.db.common.enums.ExamSubCategory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @Size(min = 1, max = 500)
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private List<QuestionOption> questionOptions;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "question_paper_id")
    private QuestionPaper questionPaper;

    @Enumerated(EnumType.STRING)
    private ExamSubCategory examSubCategory;

    private String hint;

    private int serialNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionOption> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(List<QuestionOption> questionOptions) {
        this.questionOptions = questionOptions;
    }

    public QuestionPaper getQuestionPaper() {
        return questionPaper;
    }

    public void setQuestionPaper(QuestionPaper questionPaper) {
        this.questionPaper = questionPaper;
    }

    public ExamSubCategory getExamSubCategory() {
        return examSubCategory;
    }

    public void setExamSubCategory(ExamSubCategory examSubCategory) {
        this.examSubCategory = examSubCategory;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isNew() {
        return id == 0;
    }
}

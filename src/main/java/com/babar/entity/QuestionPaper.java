package com.babar.entity;

import com.babar.entity.enums.ExamType;
import com.babar.entity.enums.Language;

import javax.persistence.*;
import java.util.Date;

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

    private int totalTimeInSeconds;

    private int totalQuestions;

    private int marksPerQuestion;

    private int totalMarks;

    private double negativeMarkingPercentage;

    private String instruction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public int getExamSerial() {
        return examSerial;
    }

    public void setExamSerial(int examSerial) {
        this.examSerial = examSerial;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public ExamType getExamType() {
        return examType;
    }

    public void setExamType(ExamType examType) {
        this.examType = examType;
    }

    public int getTotalTimeInSeconds() {
        return totalTimeInSeconds;
    }

    public void setTotalTimeInSeconds(int totalTimeInSeconds) {
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getMarksPerQuestion() {
        return marksPerQuestion;
    }

    public void setMarksPerQuestion(int marksPerQuestion) {
        this.marksPerQuestion = marksPerQuestion;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getNegativeMarkingPercentage() {
        return negativeMarkingPercentage;
    }

    public void setNegativeMarkingPercentage(double negativeMarkingPercentage) {
        this.negativeMarkingPercentage = negativeMarkingPercentage;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}

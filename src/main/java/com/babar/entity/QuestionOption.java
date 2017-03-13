package com.babar.entity;

import javax.persistence.*;

/**
 * @author babar
 * @since 3/12/17.
 */
@Entity
public class QuestionOption extends Persistence{

    @Id
    @GeneratedValue
    private int id;

    private String text;

    private int serialNumber;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private boolean correct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}

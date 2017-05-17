package com.babar.web.question.model;

import com.babar.db.entity.Question;
import com.babar.web.common.ActionView;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @author babar
 * @since 3/15/17.
 */
public class QuestionCommand implements Serializable{

    private static final long serialVersionUID = 1L;

    @Valid
    private Question question;

    private boolean autoAssignSequenceNo;

    private ActionView actionView;

    private String backLink;

    public QuestionCommand() {
    }

    public QuestionCommand(Question question, boolean autoAssignSequenceNo, ActionView actionView, String backLink) {
        this.question = question;
        this.autoAssignSequenceNo = autoAssignSequenceNo;
        this.actionView = actionView;
        this.backLink = backLink;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isAutoAssignSequenceNo() {
        return autoAssignSequenceNo;
    }

    public void setAutoAssignSequenceNo(boolean autoAssignSequenceNo) {
        this.autoAssignSequenceNo = autoAssignSequenceNo;
    }

    public ActionView getActionView() {
        return actionView;
    }

    public void setActionView(ActionView actionView) {
        this.actionView = actionView;
    }

    public String getBackLink() {
        return backLink;
    }

    public void setBackLink(String backLink) {
        this.backLink = backLink;
    }
}

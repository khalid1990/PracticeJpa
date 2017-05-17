package com.babar.web.question.model;

import com.babar.db.entity.QuestionOption;
import com.babar.web.common.ActionView;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @author babar
 * @since 3/15/17.
 */
public class QuestionOptionCommand implements Serializable{

    private static final Long serialVersionUID = 1L;

    @Valid
    private QuestionOption questionOption;

    private boolean autoAssignNextSequenceValue;

    private ActionView actionView;

    private String backLink;

    public QuestionOptionCommand() {
    }

    public QuestionOptionCommand(QuestionOption questionOption, boolean autoAssignNextSequenceValue, ActionView actionView, String backLink) {
        this.questionOption = questionOption;
        this.autoAssignNextSequenceValue = autoAssignNextSequenceValue;
        this.actionView = actionView;
        this.backLink = backLink;
    }

    public QuestionOption getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(QuestionOption questionOption) {
        this.questionOption = questionOption;
    }

    public boolean isAutoAssignNextSequenceValue() {
        return autoAssignNextSequenceValue;
    }

    public void setAutoAssignNextSequenceValue(boolean autoAssignNextSequenceValue) {
        this.autoAssignNextSequenceValue = autoAssignNextSequenceValue;
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

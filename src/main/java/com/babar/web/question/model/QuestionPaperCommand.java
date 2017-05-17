package com.babar.web.question.model;

import com.babar.db.entity.QuestionPaper;
import com.babar.web.common.ActionView;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @author babar
 * @since 3/15/17.
 */
public class QuestionPaperCommand implements Serializable{

    private static final long serialVersionUID = 1L;

    @Valid
    private QuestionPaper questionPaper;

    private ActionView actionView;

    private String backLink;

    public QuestionPaperCommand() {
    }

    public QuestionPaperCommand(QuestionPaper questionPaper, ActionView actionView, String backLink) {
        this.questionPaper = questionPaper;
        this.actionView = actionView;
        this.backLink = backLink;
    }

    public QuestionPaper getQuestionPaper() {
        return questionPaper;
    }

    public void setQuestionPaper(QuestionPaper questionPaper) {
        this.questionPaper = questionPaper;
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

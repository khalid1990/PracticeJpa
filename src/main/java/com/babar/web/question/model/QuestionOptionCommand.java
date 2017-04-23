package com.babar.web.question.model;

import com.babar.db.entity.QuestionOption;

/**
 * @author babar
 * @since 3/15/17.
 */
public class QuestionOptionCommand {

    private QuestionOption questionOption;

    private boolean autoAssignNextSequenceValue;

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
}

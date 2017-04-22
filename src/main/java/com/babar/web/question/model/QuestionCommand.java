package com.babar.web.question.model;

import com.babar.db.entity.Question;

/**
 * @author babar
 * @since 3/15/17.
 */
public class QuestionCommand {

    private Question question;

    private boolean autoAssignSequenceNo;

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
}

package com.babar.web.question.service;

import com.babar.db.entity.QuestionOption;
import org.springframework.stereotype.Service;

/**
 * @author babar
 * @since 3/15/17.
 */
@Service
public class QuestionOptionService {

    public QuestionOption save(QuestionOption questionOption) {
        return doSave(questionOption);
    }

    public QuestionOption update(QuestionOption questionOption) {
        return doSave(questionOption);
    }

    public QuestionOption approve(QuestionOption questionOption) {
        return doSave(questionOption);
    }

    public QuestionOption returnToSubmitter(QuestionOption questionOption) {
        return doSave(questionOption);
    }

    public QuestionOption delete(QuestionOption questionOption) {
        return doSave(questionOption);
    }

    private QuestionOption doSave(QuestionOption questionOption) {
        return questionOption;
    }
}

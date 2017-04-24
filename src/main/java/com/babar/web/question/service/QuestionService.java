package com.babar.web.question.service;

import com.babar.db.entity.Question;
import org.springframework.stereotype.Service;

/**
 * @author babar
 * @since 3/15/17.
 */
@Service
public class QuestionService {

    public Question save(Question question) {
        return doSave(question);
    }

    public Question update(Question question) {
        return doSave(question);
    }

    public Question approve(Question question) {
        return doSave(question);
    }

    public Question returnToSubmitter(Question question) {
        return doSave(question);
    }

    public Question delete(Question question) {
        return doSave(question);
    }

    private Question doSave(Question question) {
        return question;
    }
}

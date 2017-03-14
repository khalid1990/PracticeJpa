package com.babar.web.question.service;

import com.babar.db.entity.QuestionPaper;
import org.springframework.stereotype.Service;

/**
 * @author babar
 * @since 3/15/17.
 */
@Service
public class QuestionPaperService {

    public QuestionPaper save (QuestionPaper questionPaper) {
        return doSave(questionPaper);
    }

    public QuestionPaper update (QuestionPaper questionPaper) {
        return doSave(questionPaper);
    }

    public QuestionPaper approve (QuestionPaper questionPaper) {
        return doSave(questionPaper);
    }

    public QuestionPaper returnToSubmitter (QuestionPaper questionPaper) {
        return doSave(questionPaper);
    }

    public QuestionPaper delete (QuestionPaper questionPaper) {
        return doSave(questionPaper);
    }

    private QuestionPaper doSave(QuestionPaper questionPaper) {
        return questionPaper;
    }
}

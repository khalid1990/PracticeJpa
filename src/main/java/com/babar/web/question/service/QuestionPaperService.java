package com.babar.web.question.service;

import com.babar.db.entity.QuestionPaper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author babar
 * @since 3/15/17.
 */
@Repository
public class QuestionPaperService {

    @PersistenceContext(unitName = "emf")
    private EntityManager em;

    public QuestionPaper find(int id) {
        return em.find(QuestionPaper.class, id);
    }

    @Transactional
    public QuestionPaper save (QuestionPaper questionPaper) {
        return doSave(questionPaper);
    }

    @Transactional
    public QuestionPaper update (QuestionPaper questionPaper) {
        return doSave(questionPaper);
    }

    @Transactional
    public QuestionPaper approve (QuestionPaper questionPaper) {
        return doSave(questionPaper);
    }

    @Transactional
    public QuestionPaper returnToSubmitter (QuestionPaper questionPaper) {
        return doSave(questionPaper);
    }

    @Transactional
    public QuestionPaper delete (QuestionPaper questionPaper) {
        return doSave(questionPaper);
    }

    private QuestionPaper doSave(QuestionPaper questionPaper) {

        if (questionPaper.isNew()) {
            em.persist(questionPaper);
        } else {
            em.merge(questionPaper);
        }
        em.flush();

        return questionPaper;
    }
}

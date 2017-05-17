package com.babar.web.question.service;

import com.babar.db.entity.Question;
import com.babar.web.common.Action;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.babar.web.common.Action.*;
/**
 * @author babar
 * @since 3/15/17.
 */
@Repository
public class QuestionService {

    @PersistenceContext(unitName = "emf")
    private EntityManager em;

    public Question find(int id) {
        return em.find(Question.class, id);
    }

    public Question save(Question question) {
        return doSave(question, SAVE);
    }

    public Question update(Question question) {
        return doSave(question, UPDATE);
    }

    public Question approve(Question question) {
        return doSave(question, APPROVE);
    }

    public Question returnToSubmitter(Question question) {
        return doSave(question, RETURN);
    }

    public Question delete(Question question) {
        return doSave(question, DELETE);
    }

    private Question doSave(Question question, Action action) {

        if (question.isNew()) {
            em.persist(question);
        } else {
            em.merge(question);
        }
        em.flush();

        return question;
    }
}

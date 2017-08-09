package com.babar.web.question.service;

import com.babar.db.entity.QuestionOption;
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
public class QuestionOptionService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public QuestionOption add(QuestionOption questionOption) {

        if (questionOption.isNew()) {
            em.persist(questionOption);
        } else {
            em.merge(questionOption);
        }
        em.flush();

        return questionOption;
    }

    @Transactional
    public void delete(QuestionOption questionOption) {
        em.remove(questionOption);
        em.flush();
    }
}

package com.babar.web.question.service;

import com.babar.db.common.enums.FormStatus;
import com.babar.db.entity.Question;
import com.babar.db.entity.QuestionOption;
import com.babar.framework.workflow.FormType;
import com.babar.framework.workflow.WorkflowManager;
import com.babar.web.common.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private QuestionOptionService questionOptionService;

    public Question find(int id) {
        return em.find(Question.class, id);
    }

    @Transactional
    public Question save(Question question) {
        return doSave(question, SAVE);
    }

    @Transactional
    public Question update(Question question) {
        for (QuestionOption option : question.getQuestionOptions()) {
            option.setQuestion(question);
        }

        return doSave(question, UPDATE);
    }

    @Transactional
    public Question submit(Question question) {
        return doSave(question, SUBMIT);
    }

    @Transactional
    public Question approve(Question question) {
        return doSave(question, APPROVE);
    }

    @Transactional
    public Question returnToSubmitter(Question question) {
        return doSave(question, RETURN);
    }

    @Transactional
    public Question delete(Question question) {
        return doSave(question, DELETE);
    }

    private Question doSave(Question question, Action action) {

        FormStatus nextStatus = WorkflowManager.getNextStatus(FormType.FT_QUESTION, question.getStatus(), action);
        question.setStatus(nextStatus);

        if (question.isNew()) {
            em.persist(question);
        } else {
            em.merge(question);
        }
        em.flush();

        return question;
    }
}

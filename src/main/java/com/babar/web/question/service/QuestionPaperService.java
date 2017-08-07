package com.babar.web.question.service;

import com.babar.db.common.enums.Designation;
import com.babar.db.common.enums.ExamCategory;
import com.babar.db.common.enums.FormStatus;
import com.babar.db.entity.QuestionPaper;
import com.babar.framework.workflow.FormType;
import com.babar.framework.workflow.WorkflowManager;
import com.babar.utils.StringUtils;
import com.babar.web.common.Action;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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

    public List<QuestionPaper> getSortedQuestionPapers(String sortProperty,
                                                       String sortOrder,
                                                       int startIndex,
                                                       int recordsPerPage) {
        String sql = "Select qp from QuestionPaper qp ";

        if (!StringUtils.isAnyEmpty(sortProperty, sortOrder)) {
            sql += " order by " + sortProperty + " " + sortOrder;
        }

        Query query = em.createQuery(sql, QuestionPaper.class);

        return query.setFirstResult(startIndex)
                .setMaxResults(recordsPerPage)
                .getResultList();
    }

    @Transactional
    public QuestionPaper save (QuestionPaper questionPaper) {
        return doSave(questionPaper, Action.SAVE);
    }

    @Transactional
    public QuestionPaper update (QuestionPaper questionPaper) {
        return doSave(questionPaper, Action.UPDATE);
    }

    @Transactional
    public QuestionPaper submit (QuestionPaper questionPaper) {
        return doSave(questionPaper, Action.SUBMIT);
    }

    @Transactional
    public QuestionPaper approve (QuestionPaper questionPaper) {
        return doSave(questionPaper, Action.APPROVE);
    }

    @Transactional
    public QuestionPaper returnToSubmitter (QuestionPaper questionPaper) {
        return doSave(questionPaper, Action.RETURN);
    }

    @Transactional
    public QuestionPaper delete (QuestionPaper questionPaper) {
        return doSave(questionPaper, Action.DELETE);
    }

    private QuestionPaper doSave(QuestionPaper questionPaper, Action action) {

        FormStatus nextStatus = WorkflowManager.getNextStatus(FormType.FT_QUESTION_PAPER, questionPaper.getStatus(), action);
        questionPaper.setStatus(nextStatus);

        if (questionPaper.isNew()) {
            em.persist(questionPaper);
        } else {
            em.merge(questionPaper);
        }
        em.flush();

        return questionPaper;
    }

    private ExamCategory resolveToExamCategory(String filterValue) {
        for (ExamCategory category : ExamCategory.values()) {
            if (StringUtils.isContained(category.getName(), filterValue)) {
                return category;
            }
        }

        return null;
    }
}

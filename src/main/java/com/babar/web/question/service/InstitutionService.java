package com.babar.web.question.service;

import com.babar.db.common.enums.FormStatus;
import com.babar.db.entity.Institution;
import com.babar.framework.workflow.FormType;
import com.babar.framework.workflow.WorkflowManager;
import com.babar.utils.StringUtils;
import com.babar.web.common.Action;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author babar
 * @since 3/19/17.
 */
@Repository
public class InstitutionService {

    @PersistenceContext
    private EntityManager em;

    public Institution find(int id) {
        return em.find(Institution.class, id);
    }

    public List<Institution> findAll() {
        return em.createNamedQuery("findAllInstitutions", Institution.class).getResultList();
    }

    public List<Institution> getSortedInstitutions(String sortProperty,
                                                     String sortOrder,
                                                     int startIndex,
                                                     int recordsPerPage) {
        String sql = "Select inst from Institution inst ";

        if (!StringUtils.isAnyEmpty(sortProperty, sortOrder)) {
            sql += " order by " + sortProperty + " " + sortOrder;
        }

        Query query = em.createQuery(sql, Institution.class);

        return query.setFirstResult(startIndex)
                .setMaxResults(recordsPerPage)
                .getResultList();
    }

    @Transactional
    public Institution save(Institution institution) {
        return doSave(institution, Action.SAVE);
    }

    @Transactional
    public Institution update(Institution institution) {
        return doSave(institution, Action.UPDATE);
    }

    @Transactional
    public Institution submit(Institution institution) {
        return doSave(institution, Action.SUBMIT);
    }

    @Transactional
    public Institution approve(Institution institution) {
        return doSave(institution, Action.APPROVE);
    }

    @Transactional
    public Institution returnToSubmitter(Institution institution) {
        return doSave(institution, Action.RETURN);
    }

    @Transactional
    public Institution delete(Institution institution) {
        return doSave(institution, Action.DELETE);
    }

    private Institution doSave(Institution institution, Action action) {

        FormStatus currentStatus = institution.getStatus();
        FormStatus nextStatus = WorkflowManager.getNextStatus(FormType.FT_INSTITUTION, currentStatus, action);
        institution.setStatus(nextStatus);

        if (institution.isNew()) {
            em.persist(institution);
        } else {
            em.merge(institution);
        }
        em.flush();

        return institution;
    }
}

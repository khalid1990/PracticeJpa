package com.babar.web.user.service;

import com.babar.db.entity.User;
import com.babar.web.common.Action;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author babar
 * @since 5/23/17.
 */
@Repository
public class UserService {

    @PersistenceContext
    private EntityManager em;

    public User find(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    public User save(User user) {
        return doSave(user, Action.SAVE);
    }

    @Transactional
    public User update(User user) {
        return doSave(user, Action.UPDATE);
    }

    @Transactional
    public User approve(User user) {
        return doSave(user, Action.APPROVE);
    }

    @Transactional
    public User delete(User user) {
        return doSave(user, Action.DELETE);
    }

    @Transactional
    public User returnToSubmitter(User user) {
        return doSave(user, Action.RETURN);
    }

    private User doSave(User user, Action action) {

        if (user.isNew()) {
            em.persist(user);
        } else {
            em.merge(user);
        }
        em.flush();

        return user;
    }
}

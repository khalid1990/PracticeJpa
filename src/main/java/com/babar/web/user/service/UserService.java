package com.babar.web.user.service;

import com.babar.db.common.enums.FormStatus;
import com.babar.db.entity.User;
import com.babar.web.common.Action;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author babar
 * @since 5/23/17.
 */
@Component
public class UserService {

    @PersistenceContext
    private EntityManager em;

    public User find(int id) {
        return em.find(User.class, id);
    }

    public User save(User user) {
        return doSave(user, Action.SAVE);
    }

    public User update(User user) {
        return doSave(user, Action.UPDATE);
    }

    public User approve(User user) {
        return doSave(user, Action.APPROVE);
    }

    public User delete(User user) {
        return doSave(user, Action.DELETE);
    }

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

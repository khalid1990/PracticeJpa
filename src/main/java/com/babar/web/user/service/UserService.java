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
    public void delete(User user) {
        em.remove(em.merge(user));
        em.flush();
        /*
        * Why this em.merge() inside em.remove();
        * As the find() and delete() are two different methods; When I was calling the methods from inside my
        * controller method; JPA was creating a persistence context, starting a transaction when fetching the object
        * from database, returning the object to controller and ending the persistence context. Thus the object became
        * detached as soon as it was returned. So when I called the delete() method with this detached object I got
        * an IllegalArgumentException.
        *
        * Now that I called the em.merge() method with the object inside the remove() method, JPA started a new
        * transaction, created a PersistenceContext and merged the object with the db; now the object is attached to
        * a persistence context as the remove() method was called, it performed successfully.
        * */
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
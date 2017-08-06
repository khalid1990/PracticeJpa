package com.babar.web.user.service;

import com.babar.db.common.enums.Designation;
import com.babar.db.entity.User;
import com.babar.utils.StringUtils;
import com.babar.web.user.helper.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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

    public List<User> getAllUsers() {
        return em.createQuery("Select u from User u", User.class).getResultList();
    }

    public List<User> getFilteredUsers(String filterProperty,
                                       String filterValue,
                                       String sortProperty,
                                       String sortOrder,
                                       int startIndex,
                                       int recordsPerPage) {
        String sql = "Select u from User u ";

        boolean filtering = false;

        if (!StringUtils.isAnyEmpty(filterProperty, filterValue)) {
            sql += "where " + filterProperty + " like :filterValue ";
            filtering = true;
        }

        if (!StringUtils.isAnyEmpty(sortProperty, sortOrder)) {
            sql += " order by " + sortProperty + " " + sortOrder;
        }

        Query query = em.createQuery(sql, User.class);

        if (filtering) {
            if ("designation".equals(filterProperty)) {
                Designation designation = resolveToDesignation(filterValue);
                query.setParameter("filterValue", designation);
            } else {
                query.setParameter("filterValue", "%" + filterValue + "%");
            }
        }

        return query.setFirstResult(startIndex)
                    .setMaxResults(recordsPerPage)
                    .getResultList();
    }

    @Transactional
    public User save(User user) {
        return doSave(user);
    }

    @Transactional
    public User update(User user) {
        return doSave(user);
    }

    @Transactional
    public void delete(User user) {
        user.setActive(false);
        doSave(user);
        /*
        * em.remove(em.merge(user));
        * em.flush();
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

    private User doSave(User user) {

        if (user.isNew()) {
            em.persist(user);
        } else {
            em.merge(user);
        }
        em.flush();

        return user;
    }

    private Designation resolveToDesignation(String value) {
        for (Designation d : Designation.values()) {
            if (d.getName().toLowerCase().contains((value.toLowerCase()))) {
                return d;
            }
        }

        return null;
    }
}

package com.babar.service;

import com.babar.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author babar
 * @since 3/3/17.
 */
public class ClientService {

    public Client find(int clientId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbNode");
        EntityManager em = emf.createEntityManager();

        return em.find(Client.class, clientId);
    }

    public void saveClient(Client client) {
        EntityManager em = startTransaction();
        em.persist(client);
        endTransaction(em);
    }

    public void updateClient(Client client) {
        EntityManager em = startTransaction();
        em.merge(client);
        endTransaction(em);
    }

    private EntityManager startTransaction() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbNode");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        return em;
    }

    private void endTransaction(EntityManager em) {
        em.close();
        em.getTransaction().commit();
    }
}

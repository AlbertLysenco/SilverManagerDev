/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.silvermanager.entities.Clients;

/**
 *
 * @author artem
 */
@Repository("crudDao")
@Transactional
public class CrudDaoImpl implements CrudDao {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public void createNewClient(Clients client) {
        openSession();
        session.save(client);
        session.flush();
        closeSession();
    }

    @Override
    public void editClient(Clients client) {
        openSession();
        session.update(client);
        session.flush();
        closeSession();
    }

    @Override
    public void deleteClient(int clientId) {
        openSession();
        session.delete(getClient(clientId));
        session.flush();
        closeSession();
    }

    @Override
    public Clients getClient(int clientId) {
        if (session != null && session.isOpen()) {
            return (Clients) session.get(Clients.class, clientId);
        } else {
            openSession();
            Clients client = (Clients) session.get(Clients.class, clientId);
            closeSession();
            return client;
        }
    }

    @Override
    public Clients getClientByName(String name) {
        if (session != null && session.isOpen()) {
            return (Clients) (Clients) session.createCriteria(Clients.class).
                    add(Restrictions.eq("clientFullName", name)).list().get(0);
        } else {
            openSession();
            Clients client = (Clients) session.createCriteria(Clients.class).
                    add(Restrictions.eq("clientFullName", name)).list().get(0);
            closeSession();
            return client;
        }
    }

    private void openSession() {
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
        }
    }

    private void closeSession() {
        if (session != null) {
            session.close();
        }
    }

}

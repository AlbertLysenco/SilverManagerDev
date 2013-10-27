/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.dao;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.silvermanager.entities.Clients;

/**
 *
 * @author albert
 */
@Repository("clientsDao")
@Transactional
public class ClientsDaoImpl implements ClientsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public List<Clients> findAll() {
        Session openSession = sessionFactory.openSession();
        List<Clients> list = (List<Clients>) openSession.createCriteria(Clients.class).list();
        openSession.close();
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Clients> findAllWhithDeatails() {
        Session openSession = sessionFactory.openSession();
        List<Clients> list = (List<Clients>) openSession.getNamedQuery("Clients.findAllWhithDetails").list();
        openSession.close();
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public Clients findClientById(int id) {
        Session openSession = sessionFactory.openSession();
        Clients client = (Clients) openSession.getNamedQuery("Clients.findByClientId").setParameter("clientId", id).uniqueResult();
        openSession.close();
        return client;
    }

}

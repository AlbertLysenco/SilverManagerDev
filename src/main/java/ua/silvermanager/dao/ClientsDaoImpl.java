/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.silvermanager.dao;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.silvermanager.entities.Clients;

/**
 *
 * @author albert
 */
@Service ("clientsDao")
@Repository 
@Transactional
public class ClientsDaoImpl implements ClientsDao{
    
    @Autowired
    private SessionFactory sessionFactory;    
    
    @Transactional (readOnly = true)
    public List<Clients> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Clients").list();
    }

    @Transactional (readOnly = true)
    public List<Clients> findAllWhithDeatails() {
        return sessionFactory.getCurrentSession().getNamedQuery("Clients.findAllWhithDetails").list();
    }

    @Transactional (readOnly = true)
    public Clients findClientById(int id) {
        return (Clients) sessionFactory.getCurrentSession().getNamedQuery("Clients.findByClientId").setParameter("clientId", id).uniqueResult();
    }
    
    
    
}

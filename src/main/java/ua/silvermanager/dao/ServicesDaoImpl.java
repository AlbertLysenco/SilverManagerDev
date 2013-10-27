/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.silvermanager.entities.Services;

/**
 *
 * @author artem
 */
@Repository("servicesDao")
@Transactional
public class ServicesDaoImpl implements ServicesDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public List<Services> findAll() {
        Session openSession = sessionFactory.openSession();
        List<Services> list = (List<Services>) openSession.createCriteria(Services.class).list();
        openSession.close();
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public Services findServiceById(int id) {
        Session openSession = sessionFactory.openSession();
        Services service = (Services) openSession.getNamedQuery("Services.findByServiceId")
                .setParameter("serviceId", id).list().get(0);
        openSession.close();
        return service;
    }

}

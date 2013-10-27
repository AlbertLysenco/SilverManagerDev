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
import ua.silvermanager.entities.Managers;

/**
 *
 * @author artem
 */
@Repository("managersDao")
@Transactional
public class ManagersDaoImpl implements ManagersDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public List<Managers> findAll() {
        Session openSession = sessionFactory.openSession();
        List<Managers> list = (List<Managers>) openSession.createCriteria(Managers.class).list();
        openSession.close();
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public Managers findManagerById(int id) {
        Session openSession = sessionFactory.openSession();
        Managers manager = (Managers) openSession.getNamedQuery("Managers.findByManagerId")
                .setParameter("managerId", id).list().get(0);
        openSession.close();
        return manager;
    }

}

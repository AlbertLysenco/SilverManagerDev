/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.dao;

import java.util.List;
import org.hibernate.SessionFactory;
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
        return (List<Managers>) sessionFactory.getCurrentSession().createCriteria(Managers.class).list();
    }

    @Transactional(readOnly = true)
    @Override
    public Managers findManagerById(int id) {
        return (Managers) sessionFactory.getCurrentSession().getNamedQuery("Managers.findByManagerId")
                .setParameter("managerId", id).list().get(0);
    }

}

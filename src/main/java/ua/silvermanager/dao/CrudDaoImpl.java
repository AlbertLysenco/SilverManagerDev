/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
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

    @Override
    public void createNewClient(Clients client) {
        Session openSession = sessionFactory.openSession();
        openSession.save(client);
        openSession.close();
    }
}

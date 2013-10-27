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
import ua.silvermanager.entities.Adresses;

/**
 *
 * @author artem
 */
@Repository("adressesDao")
@Transactional
public class AdressesDaoImpl implements AdressesDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public List<Adresses> findAll() {
        Session openSession = sessionFactory.openSession();
        List<Adresses> list = (List<Adresses>) openSession.createCriteria(Adresses.class).list();
        openSession.close();
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public Adresses findAdressById(int id) {
        Session openSession = sessionFactory.openSession();
        Adresses adress = (Adresses) openSession.getNamedQuery("Adresses.findByAdressId")
                .setParameter("adressId", id).list().get(0);
        openSession.close();
        return adress;
    }

}

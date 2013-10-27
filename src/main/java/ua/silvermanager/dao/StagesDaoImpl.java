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
import ua.silvermanager.entities.Stages;

/**
 *
 * @author artem
 */
@Repository("stagesDao")
@Transactional
public class StagesDaoImpl implements StagesDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public List<Stages> findAll() {
        Session openSession = sessionFactory.openSession();
        List<Stages> list = (List<Stages>) openSession.createCriteria(Stages.class).list();
        openSession.close();
        return list;
    }

    @Transactional(readOnly = true)
    @Override
    public Stages findStageById(int id) {
        Session openSession = sessionFactory.openSession();
        Stages stage = (Stages) openSession.getNamedQuery("Stages.findByStageId")
                .setParameter("stageId", id).list().get(0);
        openSession.close();
        return stage;
    }

}

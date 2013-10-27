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
        return (List<Stages>) sessionFactory.getCurrentSession().createCriteria(Stages.class).list();
    }

    @Transactional(readOnly = true)
    @Override
    public Stages findStageById(int id) {
        return (Stages) sessionFactory.getCurrentSession().getNamedQuery("Stages.findByStageId")
                .setParameter("stageId", id).list().get(0);
    }

}

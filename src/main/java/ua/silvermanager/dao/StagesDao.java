/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.dao;

import java.util.List;
import ua.silvermanager.entities.Stages;

/**
 *
 * @author artem
 */
public interface StagesDao {

    public List<Stages> findAll();

    public Stages findStageById(int id);
}

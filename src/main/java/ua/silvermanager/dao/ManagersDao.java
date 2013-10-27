/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.dao;

import java.util.List;
import ua.silvermanager.entities.Managers;

/**
 *
 * @author artem
 */
public interface ManagersDao {

    public List<Managers> findAll();

    public Managers findManagerById(int id);
}

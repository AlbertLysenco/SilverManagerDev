/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.dao;

import java.util.List;
import ua.silvermanager.entities.Services;

/**
 *
 * @author artem
 */
public interface ServicesDao {

    public List<Services> findAll();

    public Services findServiceById(int id);
}

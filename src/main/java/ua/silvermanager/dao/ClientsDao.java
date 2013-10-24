/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.silvermanager.dao;

import java.util.List;
import ua.silvermanager.entities.Clients;

/**
 *
 * @author albert
 */
public interface ClientsDao {
    public List<Clients> findAll();
    public List<Clients> findAllWhithDeatails();
    public List<Clients> findClientById(int id);
}

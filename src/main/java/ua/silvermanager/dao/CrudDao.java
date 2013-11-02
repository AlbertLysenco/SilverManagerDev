/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.dao;

import ua.silvermanager.entities.Clients;

/**
 *
 * @author artem
 */
public interface CrudDao {

    public void createNewClient(Clients client);

    public void editClient(Clients client);

    public void deleteClient(Clients client);

    public Clients getClient(int clientId);
}

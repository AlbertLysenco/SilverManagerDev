/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.propertyEditors;

import java.beans.PropertyEditorSupport;
import ua.silvermanager.dao.AdressesDao;

/**
 *
 * @author artem
 */
public class AdressEditor extends PropertyEditorSupport {

    private final AdressesDao adressesDao;

    public AdressEditor(AdressesDao adressesDao) {
        this.adressesDao = adressesDao;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(adressesDao.findAdressById(Integer.parseInt(text)));
    }

}

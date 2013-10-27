/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.propertyEditors;

import java.beans.PropertyEditorSupport;
import ua.silvermanager.dao.ManagersDao;

/**
 *
 * @author artem
 */
public class ManagerEditor extends PropertyEditorSupport {

    private final ManagersDao managersDao;

    public ManagerEditor(ManagersDao managersDao) {
        this.managersDao = managersDao;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(managersDao.findManagerById(Integer.parseInt(text)));
    }

}

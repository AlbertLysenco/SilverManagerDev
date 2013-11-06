/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.propertyEditors;

import java.beans.PropertyEditorSupport;
import ua.silvermanager.dao.StagesDao;

/**
 *
 * @author artem
 */
public class StageEditos extends PropertyEditorSupport {

    private final StagesDao stagesDao;

    public StageEditos(StagesDao dao) {
        this.stagesDao = dao;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(stagesDao.findStageById(Integer.parseInt(text)));
    }

}

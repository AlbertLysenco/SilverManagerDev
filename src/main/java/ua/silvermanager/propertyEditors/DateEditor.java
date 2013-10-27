/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.propertyEditors;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artem
 */
public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(new SimpleDateFormat("yyyy/dd/mm").parse(text));
        } catch (ParseException ex) {
            Logger.getLogger(DateEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

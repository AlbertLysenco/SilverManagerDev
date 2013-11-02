/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.silvermanager.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.silvermanager.entities.Clients;

/**
 *
 * @author artem
 */
//@Component("search_Client_Validator")
public class Search_Client_Validator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Clients.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "clientId", "required.clientId", "Field name is required");
    }
    
}

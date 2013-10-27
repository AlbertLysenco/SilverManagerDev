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
@Component("newClientValidator")
public class NewClientValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Clients.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "clientFullName", "required.clientFullName", "Field name is required");
        ValidationUtils.rejectIfEmpty(errors, "clientDirName", "required.clientDirName", "Field name is required");
        ValidationUtils.rejectIfEmpty(errors, "adressId", "required.adressId", "Field name is required");
        ValidationUtils.rejectIfEmpty(errors, "stageId", "required.stageId", "Field name is required");
        ValidationUtils.rejectIfEmpty(errors, "managerId", "required.managerId", "Field name is required");
        ValidationUtils.rejectIfEmpty(errors, "clientStatus", "required.clientStatus", "Field name is required");
        ValidationUtils.rejectIfEmpty(errors, "clientDateOn", "required.clientDateOn", "Field name is required");
        ValidationUtils.rejectIfEmpty(errors, "clientDateOff", "required.clientDateOff", "Field name is required");
        ValidationUtils.rejectIfEmpty(errors, "serviceId", "required.serviceId", "Field name is required");
    }

}

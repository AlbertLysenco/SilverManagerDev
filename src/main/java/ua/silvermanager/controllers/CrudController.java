/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import ua.silvermanager.dao.AdressesDao;
import ua.silvermanager.dao.CrudDao;
import ua.silvermanager.dao.ManagersDao;
import ua.silvermanager.dao.ServicesDao;
import ua.silvermanager.dao.StagesDao;
import ua.silvermanager.entities.Adresses;
import ua.silvermanager.entities.Clients;
import ua.silvermanager.entities.Managers;
import ua.silvermanager.entities.Services;
import ua.silvermanager.entities.Stages;
import ua.silvermanager.propertyEditors.AdressEditor;
import ua.silvermanager.propertyEditors.DateEditor;
import ua.silvermanager.propertyEditors.ManagerEditor;
import ua.silvermanager.propertyEditors.ServiceEditor;
import ua.silvermanager.propertyEditors.StageEditos;

/**
 *
 * @author artem
 */
@Controller
@RequestMapping("/new")
public class CrudController {

    @Autowired
    @Qualifier("crud_Client_Validator")
    private Validator crud_Client_Validator;

    @Autowired
    @Qualifier("search_Client_Validator")
    private Validator search_Client_Validator;

    @Autowired
    @Qualifier("searchByName_Client_Validator")
    private Validator searchByName_Client_Validator;
//
//    @Autowired
//    @Qualifier("clientsDao")
//    private ClientsDao clientsDao;

    @Autowired
    @Qualifier("adressesDao")
    private AdressesDao adressesDao;

    @Autowired
    @Qualifier("stagesDao")
    private StagesDao stagesDao;

    @Autowired
    @Qualifier("managersDao")
    private ManagersDao managersDao;

    @Autowired
    @Qualifier("servicesDao")
    private ServicesDao servicesDao;

    @Autowired
    @Qualifier("crudDao")
    private CrudDao crudDao;

    @ModelAttribute("allAdresses")
    public List<Adresses> getAdresses() {
        return adressesDao.findAll();
    }

    @ModelAttribute("allStages")
    public List<Stages> getStages() {
        return stagesDao.findAll();
    }

    @ModelAttribute("allManagers")
    public List<Managers> getManagers() {
        return managersDao.findAll();
    }

    @ModelAttribute("allServices")
    public List<Services> getServices() {
        return servicesDao.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/client")
    public ModelAndView newEmptyClient() {
        return new ModelAndView("newClient", "command", new Clients());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/client")
    public ModelAndView newClient(@ModelAttribute("command") Clients client, BindingResult result, SessionStatus status, @RequestParam String operation, Map<String, Object> map) {

        // If operation equals Searching Client by ID !!
        if ("search by ID".equals(operation)) {
            search_Client_Validator.validate(client, result);
            if (result.hasErrors()) {
                // If there is no ID on JSP page
                return new ModelAndView("newClient", "command", client);
            } else {
                Clients searcheClient = crudDao.getClient(client.getClientId());
                // If Client has been found !! Returnig it to user
                if (searcheClient != null) {

                    map.put("selectedAdress", searcheClient.getAdressId());
                    map.put("selectedStage", searcheClient.getStageId());
                    map.put("selectedManager", searcheClient.getManagerId());
                    map.put("selectedService", searcheClient.getServiceId());
                    map.put("command", searcheClient);

                    status.setComplete();
                }
            }
        } //If operation equals Searching By Full Name
        else if ("search by Full Name".equals(operation)) {
            searchByName_Client_Validator.validate(client, result);
            if (result.hasErrors()) {
                return new ModelAndView("newClient", "command", client);
            } else {
                Clients searcheClient = crudDao.getClientByName(client.getClientFullName());
                if (searcheClient != null) {

                    map.put("selectedAdress", searcheClient.getAdressId());
                    map.put("selectedStage", searcheClient.getStageId());
                    map.put("selectedManager", searcheClient.getManagerId());
                    map.put("selectedService", searcheClient.getServiceId());
                    map.put("command", searcheClient);

                    status.setComplete();
                }
            }
        } // If operation equals ADD, EDIT or DELETE
        else {
            crud_Client_Validator.validate(client, result);
            if (result.hasErrors()) {
                return new ModelAndView("newClient", "command", client);
            } else {
                if ("add".equals(operation)) {

                    map.put("selectedAdress", client.getAdressId());
                    map.put("selectedStage", client.getStageId());
                    map.put("selectedManager", client.getManagerId());
                    map.put("selectedService", client.getServiceId());
                    map.put("command", client);

                    crudDao.createNewClient(client);
                    status.setComplete();
                } else if ("edit".equals(operation)) {

                    map.put("selectedAdress", client.getAdressId());
                    map.put("selectedStage", client.getStageId());
                    map.put("selectedManager", client.getManagerId());
                    map.put("selectedService", client.getServiceId());
                    map.put("command", client);

                    crudDao.editClient(client);
                    status.setComplete();
                } else if ("delete".equals(operation)) {

                    map.put("command", new Clients());

                    crudDao.deleteClient(client.getClientId());
                    status.setComplete();
                }
            }
        }

        return new ModelAndView("newClient", map);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Adresses.class, new AdressEditor(adressesDao));
        binder.registerCustomEditor(Date.class, new DateEditor());
        binder.registerCustomEditor(Managers.class, new ManagerEditor(managersDao));
        binder.registerCustomEditor(Services.class, new ServiceEditor(servicesDao));
        binder.registerCustomEditor(Stages.class, new StageEditos(stagesDao));
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.silvermanager.controllers;

import java.util.Date;
import java.util.List;
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
    @Qualifier("newClientValidator")
    private Validator newClientValidator;
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
    public ModelAndView newClient(@ModelAttribute("command") Clients client, BindingResult result, SessionStatus status) {
        newClientValidator.validate(client, result);

        if (result.hasErrors()) {
            return new ModelAndView("newClient", "command", client);
        } else {
            crudDao.createNewClient(client);
            status.setComplete();
        }
        return new ModelAndView("hello");
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

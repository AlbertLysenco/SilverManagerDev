package ua.silvermanager.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.silvermanager.dao.ClientsDao;
import ua.silvermanager.dao.ClientsDaoImpl;
import ua.silvermanager.entities.Clients;

@Controller
public class MainController {
        
        @Autowired
        private  ClientsDao clientsDao;
        
        @RequestMapping (value = {"/clients"})
        public ModelAndView showClientList(ModelMap model){
            List<Clients> list = clientsDao.findAllWhithDeatails();
            model.addAttribute("clientlist", list);
            System.out.println("showClient");
            return new ModelAndView("clients");
        }
        
        @RequestMapping (value = {"client{id}"})
        public ModelAndView showOtherClient(ModelMap model, @RequestParam(value = "id") int id){
            model.addAttribute("id", id);
            System.out.println("showOther");
            Clients client = clientsDao.findClientById(id);
            model.addAttribute("client", client);
            return new ModelAndView("client");
        }
        
//	@RequestMapping(value = {"/*"})
//	public String printWelcome(ModelMap model) {
////                GenericXmlApplicationContext context = new GenericXmlApplicationContext();
////                context.load("classpath:WEB-INF/mvc-dispatcher-servlet.xml");
////                context.refresh();
//                List<Clients> list = clientsDao.findAllWhithDeatails();
//                model.addAttribute("list", list);
//		model.addAttribute("message", "Hello world!");
//		return new ModelAndView("hello.jsp");
//	}
}

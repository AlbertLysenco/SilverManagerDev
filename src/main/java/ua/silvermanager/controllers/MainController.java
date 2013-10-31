package ua.silvermanager.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.silvermanager.dao.ClientsDao;
import ua.silvermanager.entities.Clients;

@Controller
public class MainController {

    @Autowired
    @Qualifier("clientsDao")
    private ClientsDao clientsDao;

    @RequestMapping(value = {"/clients"})
    public ModelAndView showClientList(ModelMap model) {
        List<Clients> list = clientsDao.findAllWhithDeatails();
        model.addAttribute("clientlist", list);
//        System.out.println("showClient");
        return new ModelAndView("clients");
    }

    @RequestMapping(value = {"client{id}"})
    public void showOtherClient(ModelMap model, @RequestParam(value = "id") int id) {
        Clients client = clientsDao.findClientById(id);
        model.addAttribute("client", client);
    }
    
//    @RequestMapping(value = {"client{id}"})
//    public void showOtherClient(ModelMap model, @RequestParam(value = "id") int id) {
//        System.out.println("showOther" +id);
//        Clients client = clientsDao.findClientById(id);
//        String name = client.getClientFullName();
//        model.addAttribute("clientname", name);
//    }
    
//    @RequestMapping (value = {"client{id}"})
//    public void getClientById(HttpServletRequest req, HttpServletResponse resp, @RequestParam(value = "id") int id) throws ServletException, IOException{
//        System.out.println(id);
//        Clients client = clientsDao.findClientById(id);
//        String name = client.getClientFullName();
//        RequestDispatcher rd = req.getRequestDispatcher("clients");
//        req.setAttribute("clientname", name);
//        rd.forward(req, resp);
//    }
    
    @RequestMapping(value = {"/adminpage"})
    public ModelAndView showAdminPage(ModelMap model) {
        
        return new ModelAndView("adminpage");
    }
}

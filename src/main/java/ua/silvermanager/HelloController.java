package ua.silvermanager;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.silvermanager.dao.ClientsDao;
import ua.silvermanager.dao.ClientsDaoImpl;
import ua.silvermanager.entities.Clients;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private ClientsDao clientsDao;

    @RequestMapping(method = RequestMethod.GET, value = "/*")
    public ModelAndView printWelcome(ModelMap model) {
        List<Clients> list = clientsDao.findAllWhithDeatails();
        ModelAndView modelAndView = new ModelAndView("hello");
        model.addAttribute("list", list);
        model.addAttribute("message", "Hello world!");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "login")
    public String login() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "logout")
    public String logout() {
        return "login";
    }
}

package ua.silvermanager;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.silvermanager.dao.ClientsDao;
import ua.silvermanager.dao.ClientsDaoImpl;
import ua.silvermanager.entities.Clients;

@Controller
@RequestMapping("/")
public class HelloController {
        
        @Autowired
        private  ClientsDao clientsDao;
        
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
//                GenericXmlApplicationContext context = new GenericXmlApplicationContext();
//                context.load("classpath:WEB-INF/mvc-dispatcher-servlet.xml");
//                context.refresh();
                List<Clients> list = clientsDao.findAllWhithDeatails();
                model.addAttribute("list", list);
		model.addAttribute("message", "Hello world!");
		return "hello";
	}
}
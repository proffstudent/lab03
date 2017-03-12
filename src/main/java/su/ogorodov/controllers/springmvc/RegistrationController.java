package su.ogorodov.controllers.springmvc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import su.ogorodov.common.exceptions.UserDaoException;
import su.ogorodov.services.UserService;

@Controller
public class RegistrationController {
    private static Logger logger = Logger.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showLoginPage() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUser(Model model, @RequestParam(value = "login") String login,
                          @RequestParam(value = "password") String password,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "lastName") String lastName,
                          @RequestParam(value = "email") String email,
                          @RequestParam(value = "accessLevel") String accessLevel) {
        try {
            userService.registration(login, password, name, lastName, email, Integer.parseInt(accessLevel));
        } catch (UserDaoException e) {
            logger.trace("false");
            return "error";
        }
        logger.trace("true");
        return "login";
    }
}



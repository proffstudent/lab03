package su.ogorodov.controllers.springmvc.usercontrol;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import su.ogorodov.common.exceptions.UserDaoException;
import su.ogorodov.models.pojo.User;
import su.ogorodov.services.UserService;

import java.util.List;

/**
 * Created by User on 11.03.2017.
 */
@Controller
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUsers(Model model, @RequestParam(name = "user") User user) {
        logger.debug(user.getName());
        return "user";
    }
}
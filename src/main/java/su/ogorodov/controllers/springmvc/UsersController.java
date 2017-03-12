package su.ogorodov.controllers.springmvc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import su.ogorodov.models.pojo.User;
import su.ogorodov.services.UserService;

import java.util.List;

/**
 * Created by User on 11.03.2017.
 */
@Controller
public class UsersController {
    private static Logger logger = Logger.getLogger(UsersController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUsers(Model model) {
        List<User> users = userService.getAllUsers();
        logger.debug(users.size());
        for (User user:users
                ) {
            logger.debug(user.getAccessLevel());
        }
        model.addAttribute("users", users);
        return "users";
    }
}
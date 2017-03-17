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

/**
 * Created by User on 11.03.2017.
 */
@Controller
public class AddUserController {
    private static Logger logger = Logger.getLogger(DeleteUserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String getUserForAdd(Model model, @RequestParam(value = "id") String strId) {
        logger.trace("on doGet - - " + strId);
        int id = (strId.equals("")) ? 0 : Integer.parseInt(strId);
        logger.trace("on doGet - - " + id);
        User user = new User();
        if (id != 0) {
            try {
                user = userService.getUserById(id);
            } catch (UserDaoException e) {
                logger.error(e);
            }
        }
        model.addAttribute("user", user);
        return "adduser";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(Model model, @RequestParam(value = "id") String strId,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "lastName") String lastName,
                          @RequestParam(value = "email") String email,
                          @RequestParam(value = "workplace") String workplace,
                          @RequestParam(value = "accessLevel") String accessLevel) {
        logger.trace("on edit " + strId);
        int id = (strId.equals("")) ? 0 : Integer.parseInt(strId);
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setWorkplace(workplace);
        user.setAccessLevel(Integer.parseInt(accessLevel));
        int count = 0;
        logger.debug("on edit " + id);
        try {
            if (id == 0) {
                count = userService.insertUser(user);
            } else {
                count = userService.updateUser(user);
            }
        } catch (UserDaoException e) {
            logger.error(e);
        }
        if (count != 0) {
            logger.trace("true");
            return "redirect:/users";
        } else {
            logger.trace("false");
            return "error";
        }
    }
}

package su.ogorodov.controllers.springmvc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
public class DeleteUserController {

    private static Logger logger = Logger.getLogger(DeleteUserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/deleteuser", method = RequestMethod.GET )
    public String deleteUser(Model model, @RequestParam(value = "id")String id){
        logger.trace("try user " + id + " delete");
        if (userService.deleteUserOnId(Integer.parseInt(id)) > 0) {
            logger.trace(id + " was deleted");
            return  "redirect:/users";
        } else {
            logger.trace(id + " not deleted");
            return "error";
        }
    }
}

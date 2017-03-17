package su.ogorodov.controllers.springmvc.usercontrol;


import org.springframework.ui.Model;
import su.ogorodov.common.exceptions.UserDaoException;
import su.ogorodov.common.exceptions.UserJdbcTemlateException;
import su.ogorodov.models.pojo.User;
import su.ogorodov.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(){
		return "/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authorization(Model model, @RequestParam(name = "login") String login, @RequestParam(name = "password") String password){
		User user = null;
		try {
			user = userService.authorise(login, password);
			logger.error(user);
			logger.trace("auth");
			model.addAttribute("user", user);
			return "redirect:/users";
		} catch (UserJdbcTemlateException e) {
			logger.trace("noauth " + e);
			return "/login";
		} catch (UserDaoException e) {
			logger.error(e);
			return "/error";
		}
	}

}

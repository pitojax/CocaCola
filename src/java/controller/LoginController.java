/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Login;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.LoginService;

/**
 *
 * @author KSC
 */
@Controller
public class LoginController {

    LoginService loginService = new LoginService();

    public LoginController() {
        //Initialize controller properties here or 
        //in the Web Application Context
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        Login login = new Login();
        map.addAttribute("login", login);
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String sendLoginDetails(@ModelAttribute(value = "login") Login login, BindingResult result, ModelMap mv, HttpServletRequest request) {

        int loginStatus = loginService.checkLoginDetails(login.getUsername(), login.getPassword());
        if (loginStatus == 1) {
            HttpSession httpsession = request.getSession();
            httpsession.setAttribute("session_id", loginService.getUserId(login.getUsername(), login.getPassword()));
            httpsession.setAttribute("session_username", login.getUsername());
            mv.addAttribute(httpsession);
            return "dashboard";
        } else {

            mv.addAttribute("errorMessage", "Wrong username or password");
            return "index";
        }

    }
}

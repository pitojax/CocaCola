/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Dcinformation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.RegistrationService;

/** 
 *
 * @author KSC
 */
public class RegistrationController extends SimpleFormController {    
    public RegistrationService registrationService;

    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    
    public RegistrationController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Dcinformation.class);
        setCommandName("name");
        setSuccessView("registrationView");
        setFormView("registrationView");
    }    
   
    
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
    @Override
    protected ModelAndView onSubmit( HttpServletRequest request,  HttpServletResponse response, 
    Object command, BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(getSuccessView());
        return mv;
    }
     
}

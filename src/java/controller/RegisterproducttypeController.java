/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Producttype;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.RegisterproducttypeService;

/** 
 *
 * @author KSC
 */
public class RegisterproducttypeController extends SimpleFormController {
    
    public RegisterproducttypeService registerproducttypeService;
    
    public void setRegisterproducttypeService(RegisterproducttypeService registerproducttypeService){
        this.registerproducttypeService = registerproducttypeService;
    }

    public RegisterproducttypeController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Producttype.class);
        setCommandName("producttype");
        //setSuccessView("successView");
        setFormView("producttypeView");
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
            BindException errors) throws Exception {
        
        HttpSession session = request.getSession();
        Integer session_id = Integer.valueOf(session.getAttribute("session_id").toString());
        Producttype producttype = (Producttype) command;
        ModelAndView mv = new ModelAndView(this.getFormView());
        mv.addObject(this.getCommandName(), command);
        mv.addObject("registerproducttypeMessage", registerproducttypeService.storeProductType(producttype.getName(), producttype.getDetails(), session_id));
        return mv;
        
    }
}

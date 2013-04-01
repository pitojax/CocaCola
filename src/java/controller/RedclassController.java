/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Redclass;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.RedclassService;

/** 
 *
 * @author KSC
 */
public class RedclassController extends SimpleFormController {

    public RedclassService redclassService;

    public void setRedclassService(RedclassService redclassService) {
        this.redclassService = redclassService;
    }

    public RedclassController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Redclass.class);
        setCommandName("redclass");
        //setSuccessView("successView");
        setFormView("redclassView");
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(getSuccessView());
        //Do something...
        return mv;
    }
}

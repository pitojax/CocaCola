/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Redclassscore;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.RedclassscoreService;

/** 
 *
 * @author KSC
 */
public class RedclassscoreController extends SimpleFormController {

    public RedclassscoreService redclassscoreService;

    public void setRedclassscoreService(RedclassscoreService redclassscoreService) {
        this.redclassscoreService = redclassscoreService;
    }

    public RedclassscoreController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Redclassscore.class);
        setCommandName("redclassscore");
        //setSuccessView("successView");
        setFormView("redclassscoreView");
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

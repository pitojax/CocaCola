/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Routes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.RoutesService;

/** 
 *
 * @author KSC
 */
public class RoutesController extends SimpleFormController {

    public RoutesService routesService;

    public void setRoutesService(RoutesService routesService) {
        this.routesService = routesService;
    }

    public RoutesController() {
        //Initialize controller properties here or 
        //in the Web Application Context
        setCommandClass(Routes.class);
        setCommandName("routes");
//        setSuccessView("successView");
        setFormView("routesView");
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

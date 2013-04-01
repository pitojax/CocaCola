/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Outlet;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.OutletService;

/** 
 *
 * @author Others
 */
public class OutletController extends SimpleFormController {
    
    public OutletService outletService;
    
    public void setOutletService(OutletService outletService){
        this.outletService = outletService;
    }

    public OutletController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Outlet.class);
        setCommandName("outlet");
        //setSuccessView("successView");
        setFormView("outletView");
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

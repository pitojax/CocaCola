/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Reports;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.ReportsService;

/** 
 *
 * @author KSC
 */
public class ReportsController extends SimpleFormController {
    
    public ReportsService reportsService;
    
    public void setReportsService(ReportsService reportsService){
        this.reportsService = reportsService;
    }
    
    public ReportsController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Reports.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        setFormView("reportsView");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
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
     */
}

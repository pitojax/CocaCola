/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Quantitytype;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.QuantitytypeService;

/** 
 *
 * @author KSC
 */
public class QuantitytypeController extends SimpleFormController {

    public QuantitytypeService quantitytypeService;

    public void setQuantitytypeService(QuantitytypeService quantitytypeService) {
        this.quantitytypeService = quantitytypeService;
    }

    public QuantitytypeController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Quantitytype.class);
        setCommandName("quantitytype");
        //setSuccessView("successView");
        setFormView("quantitytypeView");
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Productpackage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.ProductpackageService;

/** 
 *
 * @author KSC
 */
public class ProductpackageController extends SimpleFormController {
    
    public ProductpackageService productpackageService;
    
    public void setProductpackageService(ProductpackageService productpackageService){
        this.productpackageService = productpackageService;
    }
    
    public ProductpackageController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Productpackage.class);
        setCommandName("productpackage");
        //setSuccessView("successView");
        setFormView("productpackageView");
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

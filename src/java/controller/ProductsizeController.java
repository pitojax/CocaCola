/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Productsize;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.ProductsizeService;

/** 
 *
 * @author KSC
 */
public class ProductsizeController extends SimpleFormController {

    public ProductsizeService productsizeService;

    public void setProductsizeService(ProductsizeService productsizeService) {
        this.productsizeService = productsizeService;
    }

    public ProductsizeController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Productsize.class);
        setCommandName("productsize");
        //setSuccessView("successView");
        setFormView("productsizeView");
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

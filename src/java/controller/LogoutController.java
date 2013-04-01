package controller;

import controller.command.Logout;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.SignoutService;

/** 
 *
 * @author KSC
 */
public class LogoutController extends SimpleFormController {

    public SignoutService signoutService;

    public void setSignoutService(SignoutService signoutService) {
        this.signoutService = signoutService;
    }

    public LogoutController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Logout.class);
        setCommandName("logout");
        //setSuccessView("successView");
        setFormView("logoutView");
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

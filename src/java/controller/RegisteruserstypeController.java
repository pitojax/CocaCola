package controller;

import controller.command.Userstype;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.RegisteruserstypeService;

/** 
 *
 * @author KSC
 */
public class RegisteruserstypeController extends SimpleFormController {

    public RegisteruserstypeService registeruserstypeService;

    public void setRegisteruserstypeService(RegisteruserstypeService registeruserstypeService) {
        this.registeruserstypeService = registeruserstypeService;
    }

    public RegisteruserstypeController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Userstype.class);
        setCommandName("userstype");
//        setSuccessView("registeruserstypeView");
        setFormView("userstypeView");
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception {

        HttpSession session = request.getSession();
        Integer session_id = Integer.valueOf(session.getAttribute("session_id").toString());
        Userstype userstype = (Userstype) command;
        ModelAndView mv = new ModelAndView(this.getFormView());
        mv.addObject(this.getCommandName(), command);
        mv.addObject("registeruserstypeMessage", registeruserstypeService.storeUsersType(userstype.getName(), userstype.getDetails(), session_id));
        mv.addObject("users_permissions",registeruserstypeService.getAllUserTypes());
        return mv;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map data = new HashMap();
        data.put("users_permissions",registeruserstypeService.getAllUserTypes());
        return data;
    }
}

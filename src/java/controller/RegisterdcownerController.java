/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Dcowner;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.RegisterdcownerService;

/** 
 *
 * @author KSC
 */
public class RegisterdcownerController extends SimpleFormController {

    public RegisterdcownerService registerdcownerService;

    public void setRegisterdcownerService(RegisterdcownerService registerdcownerService) {
        this.registerdcownerService = registerdcownerService;
    }

    public RegisterdcownerController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Dcowner.class);
        setCommandName("dcowner");
        //setSuccessView("successView");
        setFormView("dcownerView");
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
        Dcowner dcowner = (Dcowner) command;
        ModelAndView mv = new ModelAndView(this.getFormView());
        mv.addObject(this.getCommandName(), command);
        mv.addObject("dcownerMessage", registerdcownerService.storeDcOwner(dcowner.getName(), dcowner.getTelphone(), dcowner.getEmail(), session_id));
        mv.addObject("all_dcowners", registerdcownerService.getAllDcOwners());
        return mv;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map data = new HashMap();
        data.put("all_dcowners", registerdcownerService.getAllDcOwners());
        return data;
    }
}

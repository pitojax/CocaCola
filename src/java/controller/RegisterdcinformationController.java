package controller;

import controller.command.Dcinformation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DcOwner;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.RegisterdcinformationService;

/** 
 *
 * @author KSC
 */
public class RegisterdcinformationController extends SimpleFormController {

    public RegisterdcinformationService registerdcinformationService;

    public void setRegisterdcinformationService(RegisterdcinformationService registerdcinformationService) {
        this.registerdcinformationService = registerdcinformationService;
    }

    public Map dcOwners() {
        Map<Integer, String> referencedata = new LinkedHashMap<Integer, String>();
        Iterator it_u = registerdcinformationService.getDcOwners().iterator();
        for (int i = 0; it_u.hasNext(); i++) {

            DcOwner st_u = (DcOwner) it_u.next();
            referencedata.put(st_u.getIddcOwner(), st_u.getName());

        }

        return referencedata;
    }

    public RegisterdcinformationController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Dcinformation.class);
        setCommandName("dcinformation");
        //setSuccessView("successView");
        setFormView("dcinformationView");
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map data = new HashMap();
        data.put("dcownerList", dcOwners());
        return data;
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
        Dcinformation dcinformation = (Dcinformation) command;
        ModelAndView mv = new ModelAndView(this.getFormView());
        mv.addObject(this.getCommandName(), command);
        mv.addObject("dcinfoMessage", registerdcinformationService.storeDcInformation(dcinformation.getName(), dcinformation.getDcowner(), dcinformation.getTelephone(), dcinformation.getLocation(), dcinformation.getEmail(), dcinformation.getStart_date_of_contract(), dcinformation.getExpiry_date_of_contract(), session_id));
        mv.addObject("dcownerList", dcOwners());
        return mv;
    }
}

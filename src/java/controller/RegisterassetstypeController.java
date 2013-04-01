package controller;

import controller.command.Assetstype;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AssetType;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.RegisterassetstypeService;

/** 
 *
 * @author KSC
 */
public class RegisterassetstypeController extends SimpleFormController {

    public RegisterassetstypeService registerassetstypeService;

    public void setRegisterassetstypeService(RegisterassetstypeService registerassetstypeService) {
        this.registerassetstypeService = registerassetstypeService;
    }

    public RegisterassetstypeController() {
        //Initialize controller properties here or 
        //in the Web Application Context
        setCommandClass(Assetstype.class);
        setCommandName("assetstype");
        //setSuccessView("successView");
        setFormView("assetstypeView");
    }
    
    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map data = new HashMap();
        data.put("all_assettypes", registerassetstypeService.getAllAssetTypes());
        return data;
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        
        HttpSession session = request.getSession();
        Integer session_id = Integer.valueOf(session.getAttribute("session_id").toString());
        Assetstype assetstype = (Assetstype) command;
        ModelAndView mv = new ModelAndView(this.getFormView());
        mv.addObject(this.getCommandName(), command);
        mv.addObject("assettypeMessage", registerassetstypeService.storeAssetsType(assetstype.getName(), assetstype.getDetails(), session_id));
        mv.addObject("all_assettypes", registerassetstypeService.getAllAssetTypes());
        return mv;
    }
}

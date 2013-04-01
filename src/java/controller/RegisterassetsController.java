/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Assets;
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
import service.RegisterassetsService;

/** 
 *
 * @author KSC
 */
public class RegisterassetsController extends SimpleFormController {

    public RegisterassetsService registerassetsService;

    public void setRegisterassetsService(RegisterassetsService registerassetsService) {
        this.registerassetsService = registerassetsService;
    }

    public RegisterassetsController() {
        //Initialize controller properties here or 
        //in the Web Application Context
        setCommandClass(Assets.class);
        setCommandName("assets");
        //setSuccessView("successView");
        setFormView("assetsView");
    }
    
    public Map assetTypeList(){
        Map<Integer, String> referencedata = new LinkedHashMap<Integer, String>();
        Iterator it_u = registerassetsService.getAssetTypes().iterator();
        for (int i = 0; it_u.hasNext(); i++) {

            AssetType st_u = (AssetType) it_u.next();
            referencedata.put(st_u.getIdassetType(), st_u.getName());

        }        
        return referencedata;
    }
    
    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map data = new HashMap();
        data.put("assettype_list", assetTypeList());
        data.put("all_assets", registerassetsService.getAllAssets());
        return data;
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
            BindException errors) throws Exception {
         HttpSession session = request.getSession();
        Integer session_id = Integer.valueOf(session.getAttribute("session_id").toString());
        Assets assets = (Assets) command;
        ModelAndView mv = new ModelAndView(this.getFormView());
        mv.addObject(this.getCommandName(), command);
        mv.addObject("assetsMessage", registerassetsService.storeAssets(assets.getAssettype(), assets.getSerialno(), assets.getDetails(), session_id));
        mv.addObject("all_assets", registerassetsService.getAllAssets());
        mv.addObject("assettype_list", assetTypeList());
        return mv;
    }
}

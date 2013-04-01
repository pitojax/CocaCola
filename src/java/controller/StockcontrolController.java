/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Stockcontrol;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ProductType;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.StockcontrolService;

/** 
 *
 * @author KSC
 */
public class StockcontrolController extends SimpleFormController {

    public StockcontrolService stockcontrolService;

    public void setStockcontrolService(StockcontrolService stockcontrolService) {
        this.stockcontrolService = stockcontrolService;
    }

    public StockcontrolController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Stockcontrol.class);
        setCommandName("stockcontrol");
        //setSuccessView("successView");
        setFormView("stockcontrolView");
    }

    public Map productTypeList() {
        Map<Integer, String> referencedata = new LinkedHashMap<Integer, String>();
        Iterator it_u = stockcontrolService.getProductType().iterator();
        for (int i = 0; it_u.hasNext(); i++) {

            ProductType st_u = (ProductType) it_u.next();
            referencedata.put(st_u.getIdproductType(), st_u.getName());

        }

        return referencedata;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {

        Map data = new HashMap();
        data.put("producttypeList", productTypeList());
        return data;
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
            Object command, BindException errors) throws Exception {

        Stockcontrol stockcontrol = (Stockcontrol) command;
        HttpSession session = request.getSession();
        Integer session_id = Integer.valueOf(session.getAttribute("session_id").toString());
        ModelAndView mv = new ModelAndView(this.getFormView());
        mv.addObject(this.getCommandName(), command);
        mv.addObject("stockcontrolMessage", stockcontrolService.storeStockControl(stockcontrol.getProduct_type(), stockcontrol.getOpening_stock(), stockcontrol.getCdc_delivered_stock(), stockcontrol.getTotal_flow_stock(), stockcontrol.getExpired_stock(), stockcontrol.getPrior_day_sales(), stockcontrol.getTarget_sales(), stockcontrol.getEmpties_available(), stockcontrol.getOrder(), session_id));
        mv.addObject("producttypeList", productTypeList());
        return mv;
    }
}

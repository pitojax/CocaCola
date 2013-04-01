/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.command.Channel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.ChannelService;

/** 
 *
 * @author KSC
 */
public class ChannelController extends SimpleFormController {
    
    public ChannelService  channelService;
    
    public void setChannelService ( ChannelService channelService){
        this.channelService = channelService;
    }

    public ChannelController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Channel.class);
        setCommandName("channel");
        //setSuccessView("successView");
        setFormView("channelView");
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

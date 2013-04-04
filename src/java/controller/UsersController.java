package controller;

import controller.command.Users;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import service.UsersService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author KSC
 */
@Controller
public class UsersController {

    UsersService usersService = new UsersService();

    public UsersController() {
    }

    public Map usersTypeList() {
        Map<Integer, String> referencedata = new LinkedHashMap<Integer, String>();
        Iterator it_u = usersService.getUsersType().iterator();
        for (int i = 0; it_u.hasNext(); i++) {

            UserType st_u = (UserType) it_u.next();
            referencedata.put(st_u.getIduserType(), st_u.getName());

        }

        return referencedata;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String usersPage(@ModelAttribute(value = "users") Users users, ModelMap data) {
        data.put("userstypeList", usersTypeList());
        data.put("usersList", usersService.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "/users_detials", method = RequestMethod.POST)
    public String usersDetails(ModelMap map, HttpServletResponse response) {
        map.put("usersList", usersService.getAllUsers());
        return "users_details";
    }

    @RequestMapping(value = "/get_all_users_detials", method = RequestMethod.POST)
    public @ResponseBody
    String getAllUsersDetails(ModelMap map, HttpServletResponse response) {
        String details = "";
        Object[][] arr = usersService.getAllUsers();
        for (int i = 0; i < arr.length; i++) {
            details += "<tr>\n"
                    + "            <td class=\"center\"><input type=\"checkbox\" /></td>\n"
                    + "            <td>" + arr[i][0] + " </td>\n"
                    + "            <td>" + arr[i][1] + "</td>\n"
                    + "            <td>" + arr[i][2] + "</td>\n"
                    + "            <td class=\"center\"> " + arr[i][3] + " </td>\n"
                    + "            <td class=\"center\"> " + arr[i][4] + "</td>\n"
                    + "            <td class=\"center\"><img style=\"cursor: pointer;\" src=\"<%= request.getContextPath()%>/Resources/images/icons/cc_edit.png\" alt=\"Edit\" title=\"Edit\" /> &nbsp; <img style=\"cursor: pointer;\" id=\"deleteUser" + arr[i][5] + "\" src=\"<%= request.getContextPath()%>/Resources/images/icons/cc_delete.png\" alt=\"Delete\" title=\"Trash\" /></td>\n"
                    + "        </tr>";

            details += "<script type=\"text/javascript\">\n"
                    + "        jQuery.noConflict();\n"
                    + "        (function($) {\n"
                    + "            $('#deleteUser" + arr[i][5] + "').click(function() {\n"
                    + "                 $.ajax({\n"
                    + "                    url: url_context_path + \"/delete_user?usersId=" + arr[i][5] + "\",\n"
                    + "                    type: \"GET\",\n"
                    + "                    success: function(data) {\n"
                    + "                        getAllUsersDetails();\n"
                    + "                    }\n"
                    + "                });"
                    + "              });\n"
                    + "        })(jQuery);\n"
                    + "    </script>";

        }
        return details;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public @ResponseBody
    String submitUser(@ModelAttribute(value = "users") Users users, HttpServletRequest request, ModelMap mv) {
        HttpSession session = request.getSession();
        Integer session_id = Integer.valueOf(session.getAttribute("session_id").toString());
        return usersService.storeUsers(users.getUsername(), users.getPassword(), users.getFname(), users.getLname(), users.getPermissions(), session_id);

    }

    @RequestMapping(value = "/edit_user", method = RequestMethod.GET)
    public String editUser(@ModelAttribute(value = "users") Users user, HttpServletRequest request, ModelMap mv) {
        mv.put("userstypeList", usersTypeList());
        mv.put("usersList", usersService.getAllUsers());
        String user_id = request.getParameter("user_id");
        user = new Users();
        Iterator it_u = usersService.getUserById(user_id).iterator();
        for (int i = 0; it_u.hasNext(); i++) {

            model.Users st_u = (model.Users) it_u.next();
            user.setFname(st_u.getFname());
            user.setLname(st_u.getLname());
            user.setUsername(st_u.getUsername());

            mv.put("user", user);

        }
        return "users";
    }

    @RequestMapping(value = "/edit_user", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute(value = "users") Users users, HttpServletRequest request, ModelMap mv) {

        HttpSession session = request.getSession();
        Integer session_id = Integer.valueOf(session.getAttribute("session_id").toString());
        mv.addAttribute("registerusersMessage", usersService.updateUsers(request.getParameter("user_id"), users.getUsername(), users.getPassword(), users.getFname(), users.getLname(), users.getPermissions(), session_id));
        mv.addAttribute("userstypeList", usersTypeList());
        mv.addAttribute("usersList", usersService.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "/delete_user", method = RequestMethod.GET)
    public @ResponseBody
    String deleteUsers(@RequestParam(value = "usersId", required = true) int usersId, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Integer session_id = Integer.valueOf(session.getAttribute("session_id").toString());
        System.out.println(usersId);
        return usersService.deleteUser(usersId, session_id);
    }
}

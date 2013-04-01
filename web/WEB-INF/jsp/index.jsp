<%@page import="org.springframework.context.annotation.Import"%>
<%@page import="java.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<%@ page session="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Coca-Cola Distribution Panel | Sign In</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/Resources/css/style.css" type="text/css" />
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/plugins/jquery-1.7.min.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $('.loginform button').hover(function(){
                    $(this).stop().switchClass('default','hover');
                },function(){
                    $(this).stop().switchClass('hover','default');
                });
	
                $('#login').submit(function(){
                    var u = jQuery(this).find('#username');
                    if(u.val() == '') {
                        jQuery('.loginerror').slideDown();
                        u.focus();
                        return false;	
                    }
                });
	
                $('#username').keypress(function(){
                    jQuery('.loginerror').slideUp();
                });
            });
        </script>
        <!--[if lt IE 9]>
        <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
        <![endif]-->
        <meta charset="UTF-8"></head>

    <body class="login">
        <img  src="<%= request.getContextPath()%>/Resources/images/cokezero-global-default.jpg" id="full-screen-background-image" /> 
        <div class="loginbox radius3">
            <div class="loginboxinner radius3">                

                <div class="loginform">

                    <c:if test="${not empty errorMessage}">
                        <div class="loginerror"><p>${errorMessage}</p></div>
                    </c:if>

                        <form:form id="login" commandName="login">
                        <p>
                            <form:input path="username" id="username" class="radius2" />

                        </p>
                        <p>
                            <form:password path="password"  id="password" class="radius2" />

                        </p>
                        <p>
                            <button style="background-color: #000000;    border-color: #333333;    color: #FFFFFF;" class="radius3 bebas">Sign in</button>
                        </p>
                        <p><a href="" class="whitelink small">Can't access your account?</a></p>

                    </form:form>

                </div><!--loginform-->
            </div><!--loginboxinner-->
        </div><!--loginbox-->

    </body>
</html>


<%-- 
    Document   : header
    Created on : Feb 18, 2013, 6:06:11 PM
    Author     : KSC
--%>
<%@page import="org.springframework.context.annotation.Import"%>
<%@page import="java.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Coca-Cola Distribution Panel | Dashboard</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/Resources/css/style.css" type="text/css" />
        <!--[if IE 9]>
            <link rel="stylesheet" media="screen" href="css/ie9.css"/>
        <![endif]-->

        <!--[if IE 8]>
            <link rel="stylesheet" media="screen" href="css/ie8.css"/>
        <![endif]-->

        <!--[if IE 7]>
            <link rel="stylesheet" media="screen" href="css/ie7.css"/>
        <![endif]-->
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/plugins/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/plugins/jquery.flot.min.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/plugins/jquery.flot.resize.min.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/custom/general.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/custom/dashboard.js"></script>
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/custom/charts.js"></script>
        <!--[if lt IE 9]>
        <!--[if lt IE 9]>
	<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
        <![endif]-->
        
        <script type="text/javascript">
            var url_context_path = "<%= request.getContextPath()%>";
        </script>
        <meta charset="UTF-8"></head>

    <body class="loggedin">

        <!-- START OF HEADER -->
        <div class="header radius3">
            <div class="headerinner">

                <a href=""><img src="<%= request.getContextPath()%>/Resources/images/logo.png" alt="" /></a>


                <div class="headright">
                    <div class="headercolumn">&nbsp;</div>
                    <div id="searchPanel" class="headercolumn">
                        <div class="searchbox">
                            <form action="" method="post">
                                <input type="text" id="keyword" name="keyword" class="radius2" value="Search here" /> 
                            </form>
                        </div><!--searchbox-->
                    </div><!--headercolumn-->
                    <div id="notiPanel" class="headercolumn">
                        <div class="notiwrapper">
                            <a href="<%= request.getContextPath()%>/Resources/ajax/messages.php.html" class="notialert radius2">5</a>
                            <div class="notibox">
                                <ul class="tabmenu">
                                    <li class="current"><a href="<%= request.getContextPath()%>/Resources/ajax/messages.php.html" class="msg">Messages (2)</a></li>
                                    <li><a href="<%= request.getContextPath()%>/Resources/ajax/activities.php.html" class="act">Recent Activity (3)</a></li>
                                </ul>
                                <br clear="all" />
                                <div class="loader"><img src="<%= request.getContextPath()%>/Resources/images/loaders/loader3.gif" alt="Loading Icon" /> Loading...</div>
                                <div class="noticontent"></div><!--noticontent-->
                            </div><!--notibox-->
                        </div><!--notiwrapper-->
                    </div><!--headercolumn-->
                    <div id="userPanel" class="headercolumn">
                        <a href="" class="userinfo radius2">
                            <img src="<%= request.getContextPath()%>/Resources/images/avatar.png" alt="" class="radius2" />
                            <span><strong><%= session.getAttribute("session_username")%></strong></span>
                        </a>
                        <div class="userdrop">
                            <ul>
                                <li><a href="registration.htm">Profile</a></li>
                                <li><a href="">Account Settings</a></li>
                                <li><a href="logout.htm">Logout</a></li>
                            </ul>
                        </div><!--userdrop-->
                    </div><!--headercolumn-->
                </div><!--headright-->

            </div><!--headerinner-->
        </div><!--header-->
        <!-- END OF HEADER -->

        <!-- START OF MAIN CONTENT -->
        <div class="mainwrapper">
            <div class="mainwrapperinner">         	

                <%@include file="content_left.jsp" %>

                <div class="maincontent">
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


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">
        <title>Coca-cola Admin Panel | Dashboard</title>
        <meta name="description" content="">

        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/Resources/css/main.css" media="all">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/Resources/css/style.css" media="all">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/Resources/css/tables.css" media="all">

        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/jquery-1.7.1.js"></script> 
        <script type="text/javascript" src="<%= request.getContextPath()%>/Resources/js/jquery-ui-1.8.16.custom.min.js"></script>
    </head>
    <body>

        <header>
            <div class="res" id="centered-head">
                <!-- Logo -->
                <h1><a indepth="true" href="index.html" class="logo">Coca-cola Panel</a></h1>
                <!-- Logo end -->

                <!-- Navigation -->
                <nav>             
                    <ul>
                        <li id="login">
                            <span id="login-trigger">
                                <span id="login-triggers">
                                    <script type="text/javascript">
                                        $(document).ready(function(){
                                            $('body').click(function(event) {
                                                var element = event.target.id;
                                                if (element != "user-panel-check") {
                                                    $("#login-content").hide('fast');
                                                } else{
                                                    $("#login-content").show('fast');
                                                };

                                            });
                                        });
                                    </script>
                                    <span id="user-panel-check"></span>
                                    <span id="user-panel-title"><a href="registration.htm">My Account</a></span>
                                </span>
                            </span>

                            <div id="login-content">
                                <ul>
                                    <li><a href="#"><img src="<%= request.getContextPath()%>/Resources/images/setting.png" alt=""> <span>Settings</span></a></li>
                                    <li><a href="#"><img src="<%= request.getContextPath()%>/Resources/images/help.png" alt=""><span>Help</span></a></li>
                                    <li><a indepth="true" href="logout.htm"><img src="<%= request.getContextPath()%>/Resources/images/logout.png" alt=""><span>Log Out</span></a></li>
                                </ul>
                            </div>                     
                        </li> 
                    </ul>
                </nav>  

                <div class="account-name"><p><span class="welcome">Welcome,</span> <strong><%= session.getAttribute("session_username")%></strong></p><div class="account-separator"></div></div>
                <div class="account-name"><p>Language:</p>
                    <ul class="language">
                        <li><a href="#" class="ukraine">ukraine</a></li>
                        <li class="language-active"><a href="#" class="usa">usa</a></li>
                        <li><a href="#" class="europe">europe</a></li>
                    </ul>
                    <div class="account-separator"></div></div>
                <!-- Navigation end-->

            </div>
        </header>


        <section class="res" id="middle">
            <div id="container-main">
                <div id="container">
                    <div id="content">

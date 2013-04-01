<%-- 
    Document   : logout
    Created on : Feb 21, 2013, 6:00:52 PM
    Author     : KSC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% session.invalidate(); %>
<% response.sendRedirect("login.htm"); %>

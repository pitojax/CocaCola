<%-- 
    Document   : content_left
    Created on : Feb 18, 2013, 6:07:50 PM
    Author     : KSC
--%>
<%
    String cnrut = "", cnrdi = "", cno = "", cnr = "", cnt = "", cnmo = "", cnd = "", cndi = "", cnrcs = "", cnsc = "", cnre = "", cncs = "";
%>
<div class="mainleft">
    <div class="mainleftinner">

        <div class="leftmenu">
            <ul>
                <li class="<%=cnrut%>"><a href="registeruserstype.htm" class="dashboard menudrop"><span>Configurations</span></a>
                    <ul>

                        <li><a href="users"><span>Users</span></a></li>
                        <li><a href="registerassets.htm"><span>Assets</span></a></li>                        
                        <li><a href="registerproducttype.htm"><span>Products</span></a></li>

                    </ul>
                </li>
                <li class="<%=cnrdi%>"><a href="registerdcinformation.htm" class="tables"><span>Distribution Center</span></a></li>

                <li class="<%= cno%>"><a href="outlet.htm" class="elements"><span>Outlet</span></a></li>
                <li class="<%= cnsc%>"><a href="stockcontrol.htm" class="chat"><span>Stock Control</span></a></li>
                <li class="<%= cnre%>"><a href="reports.htm" class="grid"><span>Reports</span></a></li>

            </ul>

        </div><!--leftmenu-->
        <div id="togglemenuleft"><a></a></div>
       
    </div><!--mainleftinner-->
</div><!--mainleft-->
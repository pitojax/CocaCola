<%-- 
    Document   : userstypeView
    Created on : Feb 16, 2013, 9:46:27 PM
    Author     : KSC
--%>
<%
    if (null == session.getAttribute("session_id")) {
        response.sendRedirect("login.htm");
    } else {
%>
<%@include file="includes/header.jsp" %>

<div class="maincontentinner">

    <ul class="maintabmenu">
        <li><a href="registerusers.htm">Register Users</a></li>
        <li class="current"><a href="registeruserstype.htm">Register User Types</a></li>
    </ul><!--maintabmenu-->

    <div class="content">

        <div class="contenttitle radiusbottom0">
            <h2 class="table"><span>All User Types</span></h2>
        </div><!--contenttitle-->
        <div class="tableoptions">
            <button class="deletebutton radius3" title="table2">Delete Selected</button> &nbsp;
            <select class="radius3">
                <option value="">Show All</option>
                <option value="">Rendering Engine</option>
                <option value="">Platform</option>
            </select> &nbsp;
            <button class="radius3">Apply Filter</button>
        </div><!--tableoptions-->	
        <table cellpadding="0" cellspacing="0" border="0" id="table2" class="stdtable stdtablecb">
            <colgroup>
                <col class="con0" />
                <col class="con1" />
                <col class="con0" />
                <col class="con1" />
                <col class="con0" />
                <col class="con1" />
            </colgroup>
            <thead>
                <tr>
                    <th class="head0"><input type="checkbox" class="checkall" /></th>
                    <th class="head1">Name</th>
                    <th class="head0">Details</th>
                    <th class="head1">Author</th>
                    <th class="head0">Date</th>
                    <th class="head1">&nbsp;</th>
                </tr>
            </thead>
            <tfoot>
                <tr>
                    <th class="head0"><input type="checkbox" class="checkall" /></th>
                    <th class="head1">Name</th>
                    <th class="head0">Details</th>
                    <th class="head1">Author</th>
                    <th class="head0">Date</th>
                    <th class="head1">&nbsp;</th>
                </tr>
            </tfoot>
            <tbody>               

                <c:forEach items="${users_permissions}" var="element">
                    <tr>
                        <td class="center"><input type="checkbox" /></td>
                        <td><c:out value="${element[0]}" /></td>
                        <td><c:out value="${element[1]}" /></td>
                        <td><c:out value="${element[2]}" /></td>
                        <td class="center"><c:out value="${element[3]}" /></td>
                        <td class="center"><a href="<%= request.getContextPath()%>/Resources/ajax/tabledata.php.html" class="toggle">Edit</a> &nbsp; <a href="" class="delete">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <br /><br />

        <div class="contenttitle">
            <h2 class="form"><span>User Types Form</span></h2>
        </div><!--contenttitle-->

        <br />
        <c:if test="${not empty registeruserstypeMessage}">
            <div class="notification msgsuccess">
                <a class="close"></a>
                <p>${registeruserstypeMessage}</p>
            </div><!-- notification msgsuccess -->
        </c:if>

        <form id="form1" class="stdform" method="post" action="">
            <spring:nestedPath path="userstype">
                <p>
                    <label>Name</label>
                    <spring:bind path="name">
                        <span class="field"><input type="text" name="${status.expression}" value="${status.value}" id="firstname" class="longinput" /></span> 
                        </spring:bind>
                </p>

                <p>                
                    <label>Details</label>

                    <spring:bind path="details">
                        <span class="field"><textarea cols="80" rows="5" name="${status.expression}" value="${status.value}" class="mediuminput" id="location"></textarea></span>                                
                    </spring:bind>
                </p>

                <br />

                <p class="stdformbutton">
                    <button class="submit radius2">Submit</button>
                </p>
            </spring:nestedPath>
        </form>
    </div><!--content-->

</div>



<%@include file="includes/footer.jsp" %>
<% }%>
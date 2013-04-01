<%-- 
    Document   : editusersView
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
        <li class="current"><a href="registerusers.htm">Register Users</a></li>
        <li><a href="registeruserstype.htm">Register User Types</a></li>
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
                    <th class="head0">Username</th>
                    <th class="head1">User Type</th>
                    <th class="head0">Created By</th>
                    <th class="head1">Date</th>
                    <th class="head0">&nbsp;</th>
                </tr>
            </thead>
            <tfoot>
                <tr>
                    <th class="head0"><input type="checkbox" class="checkall" /></th>
                    <th class="head1">Name</th>
                    <th class="head0">Details</th>
                    <th class="head1">Author</th>
                    <th class="head0">Date</th>
                    <th class="head1">Date</th>
                    <th class="head0">&nbsp;</th>
                </tr>
            </tfoot>
            <tbody>               

                <c:forEach items="${usersList}" var="element">
                    <tr>
                        <td class="center"><input type="checkbox" /></td>
                        <td>${element[0]}</td>
                        <td>${element[1]}</td>
                        <td>${element[2]}</td>
                        <td class="center">${element[3]}</td>
                        <td class="center">${element[4]}</td>
                        <td class="center"><a href="registerusers.htm?edituser=${element[5]}&&name=${element[0]}&&username=${element[1]}" class="toggle">Edit</a> &nbsp; <a href="" class="delete">Delete</a></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <br /><br />

        <div class="contenttitle">
            <h2 class="form"><span>Edit User Form</span></h2>
        </div><!--contenttitle-->

        <br />
        <c:if test="${not empty editusersMessage}">
            <div class="notification msgsuccess">
                <a class="close"></a>
                <p>${editusersMessage}</p>
            </div><!-- notification msgsuccess -->
        </c:if>
        <spring:nestedPath path="users">
            <form id="formUsers" class="stdform" method="post" action="">
                <spring:bind path="usersid">
                    <input type="hidden" name="${status.expression}" value="<%=request.getParameter("edituser")%>"
                </spring:bind>
                    <p>
                    <label>Username</label>
                    <spring:bind path="username">
                        <span class="field"><input type="text" name="${status.expression}" value="${status.value}" id="username" class="longinput" /></span> 
                        </spring:bind>
                </p>
                <p>
                    <label>Password</label>
                    <spring:bind path="password">
                        <span class="field"><input type="password" name="${status.expression}" value="${status.value}" id="password" class="longinput" /></span> 
                        </spring:bind>
                </p>

                <p>
                    <label>First Name</label>
                    <spring:bind path="fname">
                        <span class="field"><input type="text" name="${status.expression}" value="${status.value}" id="fname" class="longinput" /></span> 
                        </spring:bind>
                </p>
                <p>
                    <label>Last Name</label>
                    <spring:bind path="lname">
                        <span class="field"><input type="text" name="${status.expression}" value="${status.value}" id="lname" class="longinput" /></span> 
                        </spring:bind>
                </p>

                <p>                
                    <label>User Permissions</label>
                    <span class="field">
                        <form:select path="permissions"  items="${userstypeList}" id="selection" />

                    </span>
                </p>

                <br />

                <p class="stdformbutton">
                    <button class="submit radius2">Save Changes</button>
                </p>
            </form>
        </spring:nestedPath>
    </div>
</div>






<%@include file="includes/footer.jsp" %>
<% }%>
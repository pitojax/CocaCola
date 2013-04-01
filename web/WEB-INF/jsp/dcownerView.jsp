<%-- 
    Document   : dcownerView
    Created on : Feb 27, 2013, 4:25:24 PM
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
        <li><a href="registerdcinformation.htm">DC Information</a></li>
        <li  class="current"><a href="registerdcowner.htm">DC Owner</a></li>
    </ul><!--maintabmenu-->


    <div class="content">
        
        <div class="contenttitle radiusbottom0">
            <h2 class="table"><span>DC Owners</span></h2>
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

                <c:forEach items="${all_dcowners}" var="element">
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
            <h2 class="form"><span>DC Owner Form</span></h2>
        </div><!--contenttitle-->

        <br />

        <c:if test="${not empty dcownerMessage}">
            <div class="notification msgsuccess">
                <a class="close"></a>
                <p>${dcownerMessage}</p>
            </div><!-- notification msgsuccess -->
        </c:if>

        <spring:nestedPath path="dcowner">
            <form id="form1" class="stdform" method="post" action="">
                <p>
                    <label>Name</label>
                    <span class="field">

                        <spring:bind path="name">
                            <input type="text" name="${status.expression}" value="${status.value}" id="name" class="longinput" />
                        </spring:bind>
                    </span>
                </p>
                <p>
                    <label>Telephone</label>
                    <span class="field">

                        <spring:bind path="telphone">
                            <input type="text" name="${status.expression}" value="${status.value}" id="telphone" class="longinput" />
                        </spring:bind>
                    </span>
                </p> 

                <p>
                    <label>Email</label>
                    <span class="field">

                        <spring:bind path="email">
                            <input type="text" name="${status.expression}" value="${status.value}" id="email" class="longinput" />
                        </spring:bind>
                    </span>
                </p>  

                <br />

                <p class="stdformbutton">
                    <button class="submit radius2">Submit</button>
                </p>
            </form>
        </spring:nestedPath>

    </div>

</div>  
<!--Registration of dcinfo end-->


<%@include file="includes/footer.jsp" %>
<% }%>
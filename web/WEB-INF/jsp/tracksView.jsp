<%-- 
    Document   : tracksView
    Created on : Mar 8, 2013, 2:31:38 AM
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
        <li><a href="registerproducttype.htm">MDC Outlet</a></li>
        <li><a href="outlet.htm">Outlet</a></li>
        <li><a href="routes.htm">Routes</a></li>
        <li class="current"><a href="tracks.htm">Tracks</a></li>
        <li><a href="delivery.htm">Delivery</a></li>
        <li><a href="delivereditems.htm">Delivered Items</a></li>
    </ul><!--maintabmenu-->


    <div class="content"> 

        <div class="contenttitle radiusbottom0">
            <h2 class="table"><span>Tracks</span></h2>
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
            <h2 class="form"><span>Tracks Form</span></h2>
        </div><!--contenttitle-->

        <br />

        <c:if test="${not empty registerassetsMessage}">
            <div class="notification msgsuccess">
                <a class="close"></a>
                <p>${registerassetsMessage}</p>
            </div><!-- notification msgsuccess -->
        </c:if>

        <spring:nestedPath path="tracks">
            <form id="form1" class="stdform" method="post" action="">
                
                <p>
                    <label>Number</label>
                    <span class="field">

                        <spring:bind path="number">
                            <input type="text" name="${status.expression}" value="${status.value}" id="number" class="longinput" />
                        </spring:bind>
                    </span>
                </p>
                
                <p>
                    <label>Plate</label>
                    <span class="field">

                        <spring:bind path="plate">
                            <input type="text" name="${status.expression}" value="${status.value}" id="plate" class="longinput" />
                        </spring:bind>
                    </span>
                </p>
                
                
                <p>
                    <label>Details</label>
                    <span class="field">

                        <spring:bind path="details">
                            <textarea id="details" class="longinput" name="${status.expression}" value="${status.value}" rows="5"></textarea>
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


<%@include file="includes/footer.jsp" %>
<% }%>
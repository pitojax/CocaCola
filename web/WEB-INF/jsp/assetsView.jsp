<%-- 
    Document   : assetsView
    Created on : Feb 23, 2013, 2:29:35 PM
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
        <li  class="current"><a href="registerassets.htm">Assets</a></li>
        <li><a href="registerassetstype.htm">Types</a></li>
        <li><a href="glassholdings.htm">Glass Holding</a></li>
        <li><a href="channel.htm">Channel</a></li>
        <li><a href="redclass.htm">Red Class</a></li>
    </ul><!--maintabmenu-->


    <div class="content"> 

        <div class="contenttitle radiusbottom0">
            <h2 class="table"><span>Assets</span></h2>
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
                <col class="con0" />
            </colgroup>
            <thead>
                <tr>
                    <th class="head0"><input type="checkbox" class="checkall" /></th>
                    <th class="head1">Type</th>
                    <th class="head0">Serial No.</th>
                    <th class="head1">Details</th>
                    <th class="head0">Author</th>
                    <th class="head1">Date</th>
                    <th class="head0">&nbsp;</th>
                </tr>
            </thead>
            <tfoot>
                <tr>
                    <th class="head0"><input type="checkbox" class="checkall" /></th>
                    <th class="head1">Type</th>
                    <th class="head0">Serial No.</th>
                    <th class="head1">Details</th>
                    <th class="head0">Author</th>
                    <th class="head1">Date</th>
                    <th class="head0">&nbsp;</th>
                </tr>
            </tfoot>
            <tbody>               

                <c:forEach items="${all_assets}" var="element">
                    <tr>
                        <td class="center"><input type="checkbox" /></td>
                        <td><c:out value="${element[0]}" /></td>
                        <td><c:out value="${element[1]}" /></td>
                        <td><c:out value="${element[2]}" /></td>
                        <td class="center"><c:out value="${element[3]}" /></td>
                        <td class="center"><c:out value="${element[4]}" /></td>
                        <td class="center"><a href="<%= request.getContextPath()%>/Resources/ajax/tabledata.php.html" class="toggle">Edit</a> &nbsp; <a href="" class="delete">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <br /><br />

        <div class="contenttitle">
            <h2 class="form"><span>Assets Form</span></h2>
        </div><!--contenttitle-->

        <br />

        <c:if test="${not empty assetsMessage}">
            <div class="notification msgsuccess">
                <a class="close"></a>
                <p>${assetsMessage}</p>
            </div><!-- notification msgsuccess -->
        </c:if>

        <spring:nestedPath path="assets">
            <form id="form1" class="stdform" method="post" action="">

                <p>
                    <label>Asset Type</label>
                    <span class="field">
                        <form:select path="assettype"  items="${assettype_list}" />
                    </span>

                </p>

                <p>
                    <label>Serial No.</label>
                    <span class="field">

                        <spring:bind path="serialno">
                            <input type="text" name="${status.expression}" value="${status.value}" id="serialno" class="longinput" />
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



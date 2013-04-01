<%-- 
    Document   : stockcontrolView
    Created on : Feb 23, 2013, 6:10:09 PM
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
        <li class="current"><a href="stockcontrol.htm">Stock Control</a></li>
        <li><a href="">Close Stock</a></li>
    </ul><!--maintabmenu-->


    <div class="content"> 

        <div class="contenttitle radiusbottom0">
            <h2 class="table"><span>Stock Control</span></h2>
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
            <h2 class="form"><span>Stock Control</span></h2>
        </div><!--contenttitle-->

        <br />

        <c:if test="${not empty registerassetsMessage}">
            <div class="notification msgsuccess">
                <a class="close"></a>
                <p>${registerassetsMessage}</p>
            </div><!-- notification msgsuccess -->
        </c:if>

        <spring:nestedPath path="stockcontrol">
            <form id="form1" class="stdform" method="post" action="">
                <p>
                    <label>Product Type</label>
                    <span class="field">
                        <form:select path="product_type"  items="${producttypeList}" />
                    </span>
                </p>

                <p>
                    <label>Opening Stock</label>
                    <span class="field">
                        <spring:bind path="opening_stock">
                            <input type="text" name="${status.expression}" value="${status.value}" id="opening_stock" class="longinput" />
                        </spring:bind>
                    </span>
                </p>
                
                <p>
                    <label>CDC Delivered Stock</label>
                    <span class="field">

                        <spring:bind path="cdc_delivered_stock">
                            <input type="text" name="${status.expression}" value="${status.value}" id="cdc_delivered_stock" class="longinput" />
                        </spring:bind>
                    </span>
                </p>
                <p>
                    <label>Total Flow Stock</label>
                    <span class="field">

                        <spring:bind path="total_flow_stock">
                            <input type="text" name="${status.expression}" value="${status.value}" id="total_flow_stock" class="longinput" />
                        </spring:bind>
                    </span>
                </p>
                <p>
                    <label>Expired Stock</label>
                    <span class="field">

                        <spring:bind path="expired_stock">
                            <input type="text" name="${status.expression}" value="${status.value}" id="expired_stock" class="longinput" />
                        </spring:bind>
                    </span>
                </p>
                <p>
                    <label>Prior Day Sales</label>
                    <span class="field">

                        <spring:bind path="prior_day_sales">
                            <input type="text" name="${status.expression}" value="${status.value}" id="prior_day_sales" class="longinput" />
                        </spring:bind>
                    </span>
                </p>
                
                <p>
                    <label>Target Sales</label>
                    <span class="field">

                        <spring:bind path="target_sales">
                            <input type="text" name="${status.expression}" value="${status.value}" id="target_sales" class="longinput" />
                        </spring:bind>
                    </span>
                </p>
                <p>
                    <label>Empties Available</label>
                    <span class="field">

                        <spring:bind path="empties_available">
                            <input type="text" name="${status.expression}" value="${status.value}" id="empties_available" class="longinput" />
                        </spring:bind>
                    </span>
                </p>
                <p>
                    <label>Order</label>
                    <span class="field">

                        <spring:bind path="order">
                            <input type="text" name="${status.expression}" value="${status.value}" id="order" class="longinput" />
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

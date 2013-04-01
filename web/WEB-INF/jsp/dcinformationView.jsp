<%-- 
    Document   : dcinformation
    Created on : Feb 28, 2013, 11:04:59 AM
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
        <li class="current"><a href="registerdcinformation.htm">DC Information</a></li>
        <li><a href="registerdcowner.htm">DC Owner</a></li>
    </ul><!--maintabmenu-->


    <div class="content">

        <div class="contenttitle">
            <h2 class="form"><span>DC Information Form</span></h2>
        </div><!--contenttitle-->

        <br />

        <c:if test="${not empty dcinfoMessage}">
            <div class="notification msgsuccess">
                <a class="close"></a>
                <p>${dcinfoMessage}</p>
            </div><!-- notification msgsuccess -->
        </c:if>

        <spring:nestedPath path="dcinformation">

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
                    <label>Director</label>
                    <span class="field">
                        <form:select path="dcowner"  items="${dcownerList}" id="selection" />

                    </span>
                </p>

                <p>
                    <label>Telephone</label>
                    <span class="field">

                        <spring:bind path="telephone">
                            <input type="text" name="${status.expression}" value="${status.value}" id="telephone" class="longinput" />                                
                        </spring:bind>
                    </span>
                </p>

                <p>
                    <label>Location</label>
                    <span class="field">

                        <spring:bind path="location">
                            <input type="text" name="${status.expression}" value="${status.value}" id="location" class="longinput" />                                
                        </spring:bind>
                    </span>
                </p>

                <p>
                    <label>Location</label>
                    <span class="field">
                        <textarea cols="80" rows="5" name="${status.expression}" value="${status.value}" class="mediuminput" id="location"></textarea>
                    </span> 
                </p>

                <p>
                    <label>Upload Photo:</label>
                    <span class="field">
                        <input type="file">
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

                <p>
                    <label>Start date of Contract</label>
                    <span class="field">

                        <spring:bind path="start_date_of_contract">
                            <input type="text" name="${status.expression}" value="${status.value}" id="start_date_of_contract" class="longinput" />                                
                        </spring:bind>
                    </span>
                </p>

                <p>
                    <label>Expiry date of Contract</label>
                    <span class="field">

                        <spring:bind path="expiry_date_of_contract">
                            <input type="text" name="${status.expression}" value="${status.value}" id="expiry_date_of_contract" class="longinput" />                                
                        </spring:bind>
                    </span>
                </p>


                <br />

                <p class="stdformbutton">
                    <button class="submit radius2">Submit</button>
                </p>
            </form>


            <br clear="all" /><br />


        </spring:nestedPath>
    </div>

</div>  
<!--Registration of dcinfo end-->


<%@include file="includes/footer.jsp" %>
<% }%>
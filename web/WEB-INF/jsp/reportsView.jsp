<%-- 
    Document   : reportsView
    Created on : Feb 25, 2013, 7:42:51 PM
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
        <li><a href="reports.htm">Graphical</a></li>
        <li  class="current"><a href="registerassetstype.htm">Tabular</a></li>
    </ul><!--maintabmenu-->


    <div class="content"> 


        <div class="contenttitle">
            <h2 class="chart"><span>Simple Chart</span></h2>
        </div><!--contenttitle-->
        <br />
        <div id="chartplace2" style="height:300px;"></div>

        <br />

        <div class="contenttitle">
            <h2 class="chart"><span>Bar Graph</span></h2>
        </div><!--contenttitle-->
        <br />
        <div id="bargraph" style="height:300px;"></div>

        <br />

        <div class="contenttitle">
            <h2 class="chart"><span>Real Time Chart</span></h2>
        </div><!--contenttitle-->
        
        <br />
        
        <div id="realtime" style="height:300px;"></div>
        <p>You can update a chart periodically to get a real-time effect
            by using a timer to insert the new data in the plot and redraw it.</p>

        <br />

        <div class="one_half">

            <div class="contenttitle">
                <h2 class="chart"><span>Pie Chart</span></h2>
            </div><!--contenttitle-->
            <br />
            <p>Adjusted the radius values to place them within the pie.</p>
            <br />
            <div id="piechart" style="height: 250px;"></div>

        </div><!--one_half-->

        <div class="one_half last">

            <div class="contenttitle">
                <h2 class="chart"><span>Pie Chart</span></h2>
            </div><!--contenttitle-->
            <br />
            <p>Default pie graph when legend is disabled. Since the labels would normally be outside the container, the graph is resized to fit.</p>
            <div id="piechart3" style="height: 250px;"></div>

        </div><!--one_half-->

        <br clear="all" /><br />

    </div>
</div>

<%@include file="includes/footer.jsp" %>
<% }%>

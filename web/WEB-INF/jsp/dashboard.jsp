<%-- 
    Document   : registration
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
        <li class="current"><a href="">Profile</a></li>
    </ul><!--maintabmenu-->

    <div class="content">
        <ul class="widgetlist">
            <li><a href="./calendar.html" class="events">Latest Events</a></li>
            <li><a href="./editor.html" class="message">New Message</a></li>
            <li><a href="./dashboard.html" class="upload">Upload Image</a></li>
            <li><a href="./calendar.html" class="events">Statistics</a></li>
            <li><a href="./editor.html" class="message">New Message</a></li>
        </ul>

        <br clear="all" /><br />

        <div class="contenttitle">
            <h2 class="chart"><span>Simple Chart</span></h2>
        </div><!--contenttitle-->
        <br />
        <div id="chartplace2" style="height:300px;"></div>

        <br /><br />

        <div class="one_half">

            <div class="widgetbox">
                <div class="title"><h2 class="tabbed"><span>Latest Announcement</span></h2></div>
                <div class="widgetcontent announcement">
                    <p>
                        <span class="radius2">Jan 19, 2012</span> <br />Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium.</p>
                    <p>
                        <span class="radius2">Jan 18, 2012</span> <br />Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo.</p>
                </div><!--widgetcontent-->
            </div><!--widgetbox-->

        </div><!--one_half-->

        <div class="one_half last">

            <div class="widgetbox">
                <div class="title"><h2 class="tabbed"><span>Statements</span></h2></div>
                <div class="widgetcontent padding0 statement">
                    <table cellpadding="0" cellspacing="0" border="0" class="stdtable">
                        <colgroup>
                            <col class="con0" />
                            <col class="con1" />
                            <col class="con0" />
                        </colgroup>
                        <thead>
                            <tr>
                                <th class="head0">Date</th>
                                <th class="head1">Sales</th>
                                <th class="head0">Earnings</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>01/12/12</td>
                                <td>10</td>
                                <td>$250.12</td>
                            </tr>
                            <tr>
                                <td>01/11/12</td>
                                <td>5</td>
                                <td>$100.43</td>
                            </tr>
                            <tr>
                                <td>01/10/12</td>
                                <td>22</td>
                                <td>$1010.00</td>
                            </tr>
                            <tr>
                                <td>01/09/12</td>
                                <td>21</td>
                                <td>$1000.23</td>
                            </tr>
                            <tr>
                                <td>01/08/12</td>
                                <td>14</td>
                                <td>$500.22</td>
                            </tr>
                        </tbody>
                    </table>
                </div><!--widgetcontent-->
            </div><!--widgetbox-->                        
        </div><!--one_half-->

        <br clear="all" /><br />
        
         <div class="widgetbox" style="width: 300px">
            <div class="title"><h2 class="general"><span>Recent Users</span></h2></div>
            <div class="widgetcontent userlistwidget">
                <ul>
                    <li>
                        <div class="avatar"><img src="<%= request.getContextPath()%>/Resources/images/avatar2.png" alt="" /></div>
                        <div class="info">
                            <a href="">Billie Norris</a> <br />
                            Software Engineer <br /> 18 minutes ago
                        </div><!--info-->
                    </li>
                    <li>
                        <div class="avatar"><img src="<%= request.getContextPath()%>/Resources/images/avatar2.png" alt="" /></div>
                        <div class="info">
                            <a href="">Billie Norris</a> <br />
                            Software Engineer <br /> 18 minutes ago
                        </div><!--info-->
                    </li>
                </ul>
                <br clear="all" />
                <a href="" class="more">View More Users</a>
            </div><!--widgetcontent-->
        </div><!--widgetbox-->

    </div><!--content-->

</div><!--maincontentinner-->


<%@include file="includes/footer.jsp" %>
<% }%>
<%-- 
    Document   : index
    Created on : Feb 16, 2013, 9:46:27 PM
    Author     : KSC
--%>
<%
    if (null == session.getAttribute("session_id")) {
        response.sendRedirect("");
    } else {
%>
<%@include file="includes/header.jsp" %>
<div class="maincontentinner">
    <ul class="maintabmenu">
        <li class="current"><a href="users">Register Users</a></li>
        <li><a href="registeruserstype.htm">Register User Types</a></li>
    </ul><!--maintabmenu-->


    <div class="content">

        <div class="contenttitle radiusbottom0">
            <h2 class="table"><span>All Users</span></h2>

        </div><!--contenttitle-->
        <!-- load users data -->
        <div id="usersdetails"></div>
        <script type="text/javascript">

            jQuery.noConflict();
            (function($) {
                $.ajax({
                    url: url_context_path + "/users_detials",
                    type: "POST",
                    data: {},
                    success: function(response) {
                        if (response.status === "SUCCESS") {
                            $("#usersdetails").html(url_context_path + response.result);
                        }

                    },
                    error: function(e) {
                        $("#usersdetails").html(e);
                    }
                });
            })(jQuery);

        </script>


        <br /><br />        



        <div class="contenttitle">
            <h2 class="form"><span>User Form</span></h2>
        </div><!--contenttitle-->

        <br />
        <div class="notification msgsuccess">
            <a class="close"></a>
            <p id="msgsuccess"></p>
        </div><!-- notification msgsuccess -->

        <div class="notification msgerror">
            <a class="close"></a>
            <p id="msgerror"></p>
        </div><!-- notification msgerror -->

        <form id="formUser" class="stdform">
            <p>
                <label>Username</label>
                <span class="field"><input type="text" name="username"  id="username" class="longinput" /></span>
            </p>
            <p>
                <label>Password</label>
                <span class="field"><input type="password" path="password" id="password" class="longinput" /></span> 
            </p>

            <p>
                <label>First Name</label>
                <span class="field"><input type="text" name="fname" id="fname" class="longinput" /></span>
            </p>
            <p>
                <label>Last Name</label>
                <span class="field"><input type="text" name="lname" id="lname" class="longinput" /></span>
            </p>

            <p>                
                <label>User Permissions</label>
                <span class="field">

                    <select name="permissions"  id="permissions">
                        <c:forEach items="${userstypeList}" var="type">
                            <option value="${type.key}">${type.value}</option>
                        </c:forEach>
                    </select>

                </span>
            </p>

            <br />

            <p class="stdformbutton">
                <button class="submit radius2" id="submitUserDetails">Submit</button>
            </p>

            <script type="text/javascript">
                jQuery.noConflict();
                (function($) {
                    $("#submitUserDetails").click(function(e) {
                        e.preventDefault();
                        // clear the scene
                        $('.notification').hide('fast');

                        // get the form values
                        var username = $('#username').val();
                        var password = $('#password').val();
                        var fname = $('#fname').val();
                        var lname = $('#lname').val();
                        var permissions = $('#permissions').val();
                        if (username === "" || password === "" || fname === "" || lname === "" || permissions === "") {
                            $('#msgerror').html("All the fields are required");
                            $('.msgerror').show('fast');
                        } else {
                            $.ajax({
                                type: "POST",
                                url: url_context_path + "/users",
                                data: "username=" + username + "&password=" + password + "&fname=" + fname + "&lname=" + lname + "&permissions=" + permissions,
                                success: function(response) {
                                    // we have the response
                                    $('#msgsuccess').html(response);
                                    $('.msgsuccess').show('fast');
                                },
                                error: function(e) {

                                }
                            });
                        }

                    });

                })(jQuery);
            </script>

        </form>




    </div>
</div>






<%@include file="includes/footer.jsp" %>
<% }%>
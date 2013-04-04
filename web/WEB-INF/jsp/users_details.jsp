<%-- 
    Document   : users_details
    Created on : Mar 29, 2013, 11:53:58 PM
    Author     : KSC
--%>
<div class="tableoptions">
    <button class="radius3">Edit Selected</button> &nbsp;
    <button class="deletebutton radius3">Delete Selected</button> &nbsp;
    <select class="radius3">
        <option value="">Show All</option>
        <option value="">Rendering Engine</option>
        <option value="">Platform</option>
    </select> &nbsp;
    <button class="radius3">Apply Filter</button>&nbsp;
    <div class="reportIcons">
        <img src="<%= request.getContextPath()%>/Resources/images/icons/pdf_document.png" alt="PDF" title="PDF Doc" />&nbsp; 
        <img src="<%= request.getContextPath()%>/Resources/images/icons/xls_document.png" alt="XLS" title="Excel Sheet" />&nbsp;
        <img src="<%= request.getContextPath()%>/Resources/images/icons/print_document.png" alt="Print" title="Print Doc" />&nbsp;
    </div>
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
            <th class="head0">Actions</th>
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
            <th class="head0">Actions</th>
        </tr>
    </tfoot>
    <tbody id="getAllUsersDetails"></tbody>
    <script type="text/javascript">

        jQuery.noConflict();

        (function($) {

            function getAllUsersDetails() {
                $.ajax({
                    url: url_context_path + "/get_all_users_detials?userId=9",
                    type: "POST",
                    success: function(response) {
                        $("#getAllUsersDetails").html(response);
                    },
                    error: function(e) {
                        $("#getAllUsersDetails").html(e);
                    }
                });
            }

            getAllUsersDetails();
        })(jQuery);

    </script>

</table>

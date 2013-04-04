(function($) {
    $.ajax({
        url: url_context_path + "/delete_user",
        type: "POST",
        data: {userId: userId},
        success: function(data) {
            getAllUsersDetails();
        }
    });

})(jQuery);

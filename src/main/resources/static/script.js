$("#editBtn").click(function() {
    var url = $("#settings").val();
    if (url != "") {
        window.location = "/file_format/edit/" + url;
    }
});
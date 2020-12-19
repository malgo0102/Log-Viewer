$("#editBtn").click(function () {
    const url = $("#settings").val();
    if (url !== "") {
        window.location = "/file_format/edit/" + url;
    }
});


$("#deleteBtn").click(function () {
    const url = $("#settings").val();
    if (url !== "") {
        window.location = "/file_format/delete/" + url;
    }
});




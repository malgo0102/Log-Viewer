/*
$("#editBtn").click(function () {
    const url = $("#settings").val();
    if (url !== "") {
        window.location = "/file_format/edit/" + url;
    }
});*/

/*
$("#deleteBtn").click(function () {
    const url = $("#settings").val();
    if (url !== "") {
        window.location = "/file_format/delete/" + url;
    }
});*/


// it's working but could use some re-factoring to clear the warnings

$("#settings").on('change', function() {
    $("#editBtn").prop('disabled', this.value === '0')
        .click(function() {
            const url = $("#settings").val();
            if (url !== ""){
                window.location = "/file_format/edit/" + url;
            }
        });
});

$("#settings").on('change', function() {
    $("#deleteBtn").prop('disabled', this.value === '0')
        .click(function() {
            const url = $("#settings").val();
            if (url !== ""){
                window.location = "/file_format/delete/" + url;
            }
        });
});







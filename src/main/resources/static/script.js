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

const settings = $("#settings");

settings.on('change', function() {
    $("#editBtn").prop('disabled', this.value === '0')
        .click(function() {
            const url = $("#settings").val();
            if (url !== ""){
                window.location = "/file_format/edit/" + url;
            }
        });
});

settings.on('change', function() {
    $("#deleteBtn").prop('disabled', this.value === '0')
        .click(function() {
            const url = $("#settings").val();
            if (url !== ""){
                window.location = "/file_format/delete/" + url;
            }
        });
});

settings.on('change', function() {
    $("#parseBtn").prop('disabled', this.value === '0')
        .click(function() {
            const url = $("#settings").val();
            if (url !== ""){
                window.location = "/table/setting/" + url;
            }
        });
});

// add new setting form: disables delimiter if user selects json as file type
$("#fileType").on('change', function() {
    $("#regex").prop('disabled', this.value === "JSON")
});





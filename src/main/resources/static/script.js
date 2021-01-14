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

// file_format_add.html: disables delimiter and headers input field if user selects JSON as a file type
$("#fileType").on('change', function() {
    $("#regex").prop('disabled', this.value === "JSON")
    $("#headers").prop('disabled', this.value === "JSON")
});




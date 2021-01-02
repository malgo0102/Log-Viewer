$("#showStatistics").click(function() {
    const selectedColHeader = $("#selectColHeader").val();
    if (selectedColHeader !== ""){
        const obj = {
            selectedHeader: selectedColHeader
        }

        window.location = "/statistics?" + $.param(obj);
    }
});
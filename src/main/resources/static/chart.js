const chooseX = $("#chooseX");
const chooseY = $("#chooseY");

chooseX.on('change', function() {
    let urlY;

    chooseY.on('change', function () {
        $("#generate").prop(disabled,  this.value === '1')
            .click(function() {
                if ( $("#chooseY").val() !== ""){
                   urlY = $("#chooseY").val();
                }
            });
    })

    $("#generate").prop(disabled, this.value === '0' && this.value === '1')
        .click(function() {
          const urlX = $("#chooseX").val();
          const urlY = $("#chooseY").val();
            if (urlX !== "" && urlY !== ""){
                window.location = "/file_format/delete/" + urlX + urlY;
            }
        });
});
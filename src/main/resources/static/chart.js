$("#generate").click(function() {
          const urlX = $("#chooseX").val();
          const urlY = $("#chooseY").val();
            if (urlX !== "" && urlY !== ""){
                window.location = "/chart" + urlX + urlY;
            }
});

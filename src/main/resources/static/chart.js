$("#generate").click(function() {
          const urlX = $("#chooseX").val();
          const urlY = $("#chooseY").val();
            if (urlX !== "" && urlY !== ""){
                const obj = {
                    x: urlX,
                    y: urlY
                }

                window.location = "/chart?" + $.param(obj);
            }
});

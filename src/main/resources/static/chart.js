$("#generate").click(function() {
          const urlX = $("#chooseX").val();
          const urlY = $("#chooseY").val();
            if (urlX !== "" && urlY !== ""){
                const obj = {
                    x: urlX,
                    y: urlY
                }


                alert($.param(obj));
                window.location = "/chart?" + $.param(obj);
            }
});

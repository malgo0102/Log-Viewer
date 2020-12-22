const textX = document.getElementById("hX").value;
const textY = document.getElementById("hY").value;

const x = document.getElementById("x").value;
const y = document.getElementById("y").value;

document.addEventListener('DOMContentLoaded', function () {
    var chart = Highcharts.chart('container', {
        chart: {
            type: 'line'
        },
        title: {
            text: 'Log viewer chart'
        },
        xAxis: {
            title: {
                text: textX
            },
            categories: x
        },
        yAxis: {
            title: {
                text: textY
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: [{
            name: 'Log',
            data: y
        }]
    });
});

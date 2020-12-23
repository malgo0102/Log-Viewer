package logViewer.Controller;

import logViewer.Model.TableData;
import logViewer.Model.ChartAxies;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChartController {
    @GetMapping ("/chartForm")
    public String chooseAxis(HttpServletRequest request, Model model){
        TableData tableData = (TableData) request.getSession().getAttribute("tableData");

        List<List<String>> rows = tableData.getRows();
        List<String> headersX = tableData.getHeaders();
        List<String> headersY = new ArrayList<>();

        List row = rows.get(0);

        for(int i=0; i < row.size(); i++) {
            try {
                Float.parseFloat((String) row.get(i));
                headersY.add(headersX.get(i));
            } catch (NumberFormatException ex) {}
        }

        model.addAttribute("headersX", headersX);
        model.addAttribute("headersY", headersY);

        return "chart-form";
    }

    @GetMapping("/chart")
    public String showChart(HttpServletRequest request, Model model,
                            @ModelAttribute("chart") ChartAxies chart,
                            @RequestParam(value = "x") String x, @RequestParam(value = "y") String y ) {

        TableData tableData = (TableData) request.getSession().getAttribute("tableData");

        List<String> xAxis = new ArrayList<>();
        List<Float> yAxis = new ArrayList<>();

        List<List<String>> rows = tableData.getRows();
        List<String> headers = tableData.getHeaders();

        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).contains(x)) {
                for (int j = 2; j < 20; j++) {
                    model.addAttribute("hX", x);
                    xAxis.add(rows.get(j).get(i));
                }
            }

            if (headers.get(i).contains(y)) {
                if (rows.size() < 20) {
                    for (int k = 2; k < rows.size(); k++) {
                        try {
                            model.addAttribute("hY", y);
                            Float.parseFloat(rows.get(k).get(i));
                            yAxis.add(Float.valueOf(rows.get(k).get(i)));
                        } catch (NumberFormatException ex) {
                        }
                    }
                }

                for (int k = 2; k < 20; k++) {
                    try {
                        model.addAttribute("hY", chart.getY());
                        Float.parseFloat(rows.get(k).get(i));
                        yAxis.add(Float.valueOf(rows.get(k).get(i)));
                    } catch (NumberFormatException ex) {}
                }
            }
        }

        model.addAttribute("x", xAxis);
        model.addAttribute("y", yAxis);

        return "chart";
    }
}
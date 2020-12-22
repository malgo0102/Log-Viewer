package logViewer.Controller;

import logViewer.Model.TableData;
import logViewer.Model.ChartAxies;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChartController {
    @GetMapping("/chart")
    public String showChart(HttpServletRequest request, Model model, @ModelAttribute("chart") ChartAxies chart) {
        TableData tableData = (TableData) request.getSession().getAttribute("tableData");

        List<String> xAxies = new ArrayList<>();
        List<Float> yAxies = new ArrayList<>();

        List<List<String>> rows = tableData.getRows();
        List<String> headers = tableData.getHeaders();

        for(int i = 0; i < headers.size(); i++) {
            if (headers.get(i).contains(chart.getX())) {
                for(int j = 2; j < 20; j++) {
                    model.addAttribute("hX", chart.getX());
                    xAxies.add(rows.get(j).get(i));
                }
            }

            if(headers.get(i).contains(chart.getY())) {
                for(int k = 2; k < 20; k++) {
                    try {
                        model.addAttribute("hY", chart.getY());
                        Float.parseFloat(rows.get(k).get(i));
                        yAxies.add(Float.valueOf(rows.get(k).get(i)));
                    } catch (NumberFormatException ex) {
                    }
                }
            }
        }

        model.addAttribute("x", xAxies);
        model.addAttribute("y", yAxies);

        return "chart";
    }
}

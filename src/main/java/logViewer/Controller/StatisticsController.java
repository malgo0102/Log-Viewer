package logViewer.Controller;

import logViewer.Model.TableData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class StatisticsController {

    TableData tableData;

    @GetMapping("/statistics")
    public String getStatistics (HttpServletRequest request) {
        tableData = (TableData) request.getSession().getAttribute("tableData");
        if (tableData == null) {
            //model.addAttribute("message", "Please select a file to upload!");

            return "statistics";
        }
        return "redirect:/statistics";
    }

    @PostMapping("/statistics")
    public String calculate (HttpServletRequest request, Model model) {

        tableData = (TableData) request.getSession().getAttribute("tableData");

        List<List<String>> rows = tableData.getRows();
        List<String> columnString = tableData.rowsToColumns(rows).get(5);
        List<Double> column = new ArrayList<>();
        List<List<String>> columns = new ArrayList<>();

        try {
            column = tableData.stringToDoubleColumn(columnString);
        } catch (Exception ex) { }

        double min = tableData.getMin(column); //double min = 5.1; //
        double max = tableData.getMax(column); //double max = 6.1; //

        System.out.println(min);
        System.out.println(max);

        model.addAttribute("min", min);
        model.addAttribute("max", max);

        return "statistics";
    }
}

package logViewer.Controller;

import logViewer.Model.FileFormat;
import logViewer.Model.TableData;
import logViewer.Model.Search;
import logViewer.Parser.CsvParser;
import logViewer.Parser.JsonParser;
import logViewer.Parser.Parser;

import logViewer.Repository.FileFormatRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ParserController {

    TableData tableData;
    FileFormatRepository fileFormatRepo;

    public ParserController(FileFormatRepository fileFormatRepo) {
        this.fileFormatRepo = fileFormatRepo;
    }

    @GetMapping("/table")
    public String showTable(HttpServletRequest request, Model model) {
        tableData = (TableData) request.getSession().getAttribute("tableData");

        if (tableData == null) {
            //model.addAttribute("message", "Please select a file to upload!");

            return "table";
        }
        System.out.println();

        List<List<String>> rows = tableData.getRows();
        List<String> headers = tableData.getHeaders();

        model.addAttribute("showSearch", true);
        model.addAttribute("error", false);
        model.addAttribute("headers", headers);
        model.addAttribute("rows", rows);

        return "table";
    }

    @GetMapping("/table/setting/{id}")
    public String parseFile(@PathVariable("id") int id, HttpServletRequest request, Model model) {
        try {
            // Fetch selected setting from db
            FileFormat fileFormat = fileFormatRepo.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid file format id: " + id));
            // Check file type
            Parser parser;
            if (fileFormat.getFileType().equals("CSV")) {
                // Check if setting has custom headers
               //if (!fileFormat.getHeaders().isEmpty()) {
                //}
                parser = new CsvParser();
            } else {
                parser = new JsonParser();
            }

            String file = (String) request.getSession().getAttribute("file");
            tableData = parser.parse(file, fileFormat);

            request.getSession().setAttribute("tableData", tableData);

            List<List<String>> rows = tableData.getRows();
            List<String> headers = tableData.getHeaders();

            model.addAttribute("showSearch", true);
            model.addAttribute("error", false);
            model.addAttribute("headers", headers);
            model.addAttribute("rows", rows);

        } catch (Exception ex) {
            model.addAttribute("error", true);
            model.addAttribute("message", "Error occurred: " + ex.getMessage());
        }

        return "table";
    }

    @GetMapping(value = "/search")
    public String search(@ModelAttribute("search") Search search, Model model) {
        List<List<String>> rows = tableData.getRows();
        List<String> headers = tableData.getHeaders();
        List<List<String>> filteredRows = new ArrayList<>();

        for (List row : rows) {
            if (row.contains(search.getSearch())) {
                filteredRows.add(row);
            }
        }

        model.addAttribute("showSearch", true);
        model.addAttribute("clearSearch", true);
        model.addAttribute("headers", headers);
        model.addAttribute("rows", filteredRows);

        return "table";
    }

    @GetMapping("/clearSearch")
    private String clearSearch(Model model) {
        List<List<String>> rows = tableData.getRows();
        List<String> headers = tableData.getHeaders();

        model.addAttribute("showSearch", true);
        model.addAttribute("headers", headers);
        model.addAttribute("rows", rows);

        return "table";
    }
}

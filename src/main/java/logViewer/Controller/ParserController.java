package logViewer.Controller;

import logViewer.Model.FileFormat;
import logViewer.Model.TableData;
import logViewer.Parser.CsvParser;
import logViewer.Parser.Parser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ParserController {

  TableData tableData;
  @PostMapping("/table")
  public String uploadFile(@RequestParam("file") MultipartFile multipartFile, Model model) {

    if (multipartFile.isEmpty()) {
      model.addAttribute("error", true);
      model.addAttribute("message", "Please select a CSV file to upload.");
    } else {
      try {
        //if (csv file):
       Parser parser = new CsvParser();
        // if (json file):
      //  Parser parser = new JsonParser();

        String file = parser.readFile(multipartFile);
        tableData = parser.parse(file);
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
    }

    return "table";
  }

  @RequestMapping(value="/table")
  public String search(@RequestParam("search") String search, Model model) {
    List<List<String>> rows = tableData.getRows();
    List<String> headers = tableData.getHeaders();
    List<List<String>> filteredRows = new ArrayList<>();

      for (List row : rows) {
      if (row.contains(search)) {
        filteredRows.add(row);
      }
    }

      model.addAttribute("headers", headers);
      model.addAttribute("rows", filteredRows);

      return "table";
    }
}

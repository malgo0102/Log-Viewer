package logViewer.Controller;

import logViewer.Model.TableData;
import logViewer.Parser.CsvParser;
import logViewer.Parser.Parser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ParserController {

  TableData tableData;

  //@GetMapping("/table")
  //public String showTable() { return "table"; }

  @PostMapping("/table")
  public String uploadFile(HttpServletRequest request, Model model) {
      try {
        //if (csv file):
       Parser parser = new CsvParser();
        // if (json file):
        // Parser parser = new JsonParser();

        //String file = parser.readFile(multipartFile);
        //request.getSession().setAttribute("file", file);
        String file = (String)request.getSession().getAttribute("file");

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

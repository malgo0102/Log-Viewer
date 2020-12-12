package logViewer.Controller;

import logViewer.Model.TableData;
import logViewer.Parser.CsvParser;

import logViewer.Parser.JsonParser;
import logViewer.Parser.Parser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ParserController {

  @GetMapping("/")
  public String showIndex(){
    return "index";
  }

  // TESTING
  @GetMapping("/import")
  public String importSettings(Model m) {
    List<String> fileSettings = List.of("Novo Nordisk logs", "Rovsing logs", "Lenovo logs");
    m.addAttribute("file_settings", fileSettings);

    return "import";
  }

  @PostMapping("/table")
  public String uploadFile(@RequestParam("file") MultipartFile multipartFile, Model model) {
    // todo: choose manually file type
    if (multipartFile.isEmpty()) {
      model.addAttribute("error", true);
      model.addAttribute("message", "Please select a CSV file to upload.");
    } else {
      try {
        //if (csv file):
        Parser parser = new CsvParser();
        // if (json file):
        //Parser parser = new JsonParser();

        String file = parser.readFile(multipartFile);
        TableData tableData = parser.parse(file);
        List<List<String>> rows = tableData.getRows();
        List<String> headers = tableData.getHeaders();

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

}

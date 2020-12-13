package logViewer.Controller;

import logViewer.Model.FileFormat;

// import logViewer.Repository.FileFormatRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileFormatController {

//  FileFormatRepository fileFormatRepo;

  // TESTING
  @GetMapping("/file_format")
  public String importSettings(Model m) {
    FileFormat fileFormat = new FileFormat();
    m.addAttribute("file_settings", fileFormat.getName());

    return "file_format";
  }

  // TESTING
  @GetMapping("/file_format/add")
  public String addSetting (Model m) {
    FileFormat fileFormat = new FileFormat();
    m.addAttribute("file_settings", fileFormat.getName());

    return "file_format_add";
  }
}

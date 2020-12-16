package logViewer.Controller;

import logViewer.Model.FileFormat;

import logViewer.Repository.FileFormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FileFormatController {

  FileFormatRepository fileFormatRepo;

  public FileFormatController(FileFormatRepository fileFormatRepo) {
    this.fileFormatRepo = fileFormatRepo;
  }

  // TESTING
  @GetMapping("/file_format/add")
  public String getFileSettingForm(Model model) {
    // create model attribute to bind form data
    model.addAttribute("file_settings", new FileFormat());
    return "file_format_add";
  }

  // TESTING
  @PostMapping("/file_format/add")
  public String saveSetting (@ModelAttribute("file_settings") FileFormat fileFormat ) {
    // save file format setting to database
    System.out.println(fileFormat.toString());
    fileFormatRepo.save(fileFormat);
    return "file_format_add";
  }
}

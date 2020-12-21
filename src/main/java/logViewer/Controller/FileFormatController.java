package logViewer.Controller;

import logViewer.Model.FileFormat;
import logViewer.Repository.FileFormatRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class FileFormatController {

    FileFormatRepository fileFormatRepo;

    public FileFormatController(FileFormatRepository fileFormatRepo) {
        this.fileFormatRepo = fileFormatRepo;
    }

    // Fetch settings (file formats) from db and populate the form drop-down list
    @GetMapping("file_format")
    public String getAllSettings(Model model) {
        //settings.forEach(System.out::println);
        model.addAttribute("fileFormats", fileFormatRepo.findAll());
        return "file_format";
    }

    //  Apply file format to file contents
    @PostMapping("/file_format")
    public String applyFileFormat(@ModelAttribute("file_format") FileFormat fileFormat, HttpServletRequest request, Model m) {
        // select fileFormat(setting):
        // retrieve fileFormat name to know ID to apply from the settings list
        // fileFormat.getId
        // send fileFormat to @PostMapping "/table" parseFile(): FileFormat fileFormat = request.getSession().setAttribute("fileFormat");

        // add fileFormat(setting):
        // hide delimiter and headers form if file type chosen = json
        // check if file contains column headers:
            // 1. read first line and
            // 2. ask user "Are these headers?" fileFormat.setHeaders()
        // else apply column headers from the form - fileFormat.setHeaders()

        return "file_format";
    }

    @GetMapping("/file_format/add")
    public String getFileSettingForm(Model model) {
        // Create model attribute to bind form data
        model.addAttribute("fileFormat", new FileFormat());

        return "file_format_add";
    }

    @PostMapping("/file_format/add")
    public String saveSetting(@ModelAttribute("fileFormat") FileFormat fileFormat) {
        //System.out.println(fileFormat.toString());
        fileFormatRepo.save(fileFormat);

        return "redirect:/file_format";
    }

    // Fetch a selected setting from db and display it in a form to be updated
    @GetMapping("file_format/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model) {
        FileFormat fileFormat = fileFormatRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid file format id: " + id));

        model.addAttribute("fileFormat", fileFormat);

        return "file_format_edit";
    }

    // Updates db after a setting is edited
    @PostMapping("/file_format/update/{id}")
    public String updateSetting(@PathVariable("id") int id, @ModelAttribute("fileFormat") FileFormat fileFormat, Model model) {
        fileFormatRepo.save(fileFormat);

        model.addAttribute("fileFormats", fileFormatRepo.findAll());

        return "redirect:/file_format";
    }

    // Removes a selected setting from db
    @GetMapping("/file_format/delete/{id}")
    public String deleteSetting(@PathVariable("id") int id, Model model) {
        FileFormat fileFormat = fileFormatRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid file format id: " + id));
        fileFormatRepo.delete(fileFormat);
        // Show info: "Setting " + fileFormat.name + " was deleted from the database."

        model.addAttribute("fileFormats", fileFormatRepo.findAll());

        return "redirect:/file_format";
    }

}

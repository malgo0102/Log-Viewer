package logViewer.Controller;

import logViewer.Model.FileFormat;
import logViewer.Repository.FileFormatRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class FileFormatController {

    FileFormatRepository fileFormatRepo;

    public FileFormatController(FileFormatRepository fileFormatRepo) { this.fileFormatRepo = fileFormatRepo; }

    // Fetch settings (file formats) from the db and populate the form drop-down list
    @GetMapping("file_format")
    public String getAllSettings(Model model) {
        //Iterable<FileFormat> fileFormats = fileFormatRepo.findAll();
        //settings.forEach(System.out::println);
        //model.addAttribute("fileFormat", new FileFormat());
        model.addAttribute("fileFormats", fileFormatRepo.findAll());

        return "file_format";
    }

    //  Apply file format to file contents
    @PostMapping("/file_format")
    public String applyFileFormat(@ModelAttribute("file_format") FileFormat fileFormat, HttpServletRequest request, Model m) {

        return "file_format";
    }

    @GetMapping("/file_format/add")
    public String getFileSettingForm(Model model) {
        // create model attribute to bind form data
        model.addAttribute("fileFormat", new FileFormat());

        return "file_format_add";
    }

    @PostMapping("/file_format/add")
    public String saveSetting(@ModelAttribute("fileFormat") FileFormat fileFormat) {
        // save file format setting to database
        //System.out.println(fileFormat.toString());
        fileFormatRepo.save(fileFormat);

        return "redirect:/file_format";
    }

    // todo
    // Fetch a selected setting from db and display it in a form to be updated
    @GetMapping("file_format/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model) {
        System.out.println(id);

        //.orElseThrow(() -> new IllegalArgumentException("Invalid SettingsId: " + id));
        model.addAttribute("file_format", fileFormatRepo.findById(id));

        return "file_format_edit";
    }

    // todo
    // Remove a selected setting from the db

}

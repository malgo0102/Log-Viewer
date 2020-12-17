package logViewer.Controller;

import logViewer.Model.FileFormat;

import logViewer.Repository.FileFormatRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class FileFormatController {

    FileFormatRepository fileFormatRepo;

    public FileFormatController(FileFormatRepository fileFormatRepo) {
        this.fileFormatRepo = fileFormatRepo;
    }

    @GetMapping("/file_format/add")
    public String getFileSettingForm(@ModelAttribute("item")FileFormat fileFormat, Model model) {
        // create model attribute to bind form data
        model.addAttribute("file_settings", new FileFormat());
        return "file_format_add";
    }

    @PostMapping("/file_format/add")
    public String saveSetting(@ModelAttribute("file_settings") FileFormat fileFormat) {
        // save file format setting to database
        //System.out.println(fileFormat.toString());
        fileFormatRepo.save(fileFormat);
        return "file_format";
    }

    // this method will fetch all settings from the db and populate the form drop-down list
    @GetMapping("file_format")
    public String getAllSettings(Model model) {
        Iterable<FileFormat> settings = fileFormatRepo.findAll();
        //settings.forEach(System.out::println);
        model.addAttribute("item", new FileFormat());
        model.addAttribute("settings", settings);
        return "file_format";
    }

    // todo
    // this method will fetch the selected setting from db and display it in a form to be updated
    @GetMapping("file_format/edit/{id}")
    public String showFormEdit(@PathVariable("id") int id, Model model) {
        System.out.println(id);
        Optional<FileFormat> fileFormat = fileFormatRepo.findById(id);
        System.out.println(fileFormat);
                //.orElseThrow(() -> new IllegalArgumentException("Invalid SettingsId: " + id));
        model.addAttribute("file_format", fileFormat);
        return "file_format_edit";
    }

    // todo
    // this method will remove a selected setting from the db


}

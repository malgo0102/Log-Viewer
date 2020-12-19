package logViewer.Controller;

import logViewer.Model.FileFormat;

import logViewer.Parser.CsvParser;
import logViewer.Parser.Parser;
import logViewer.Repository.FileFormatRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Controller
public class FileFormatController {

    FileFormatRepository fileFormatRepo;

    public FileFormatController(FileFormatRepository fileFormatRepo) {
        this.fileFormatRepo = fileFormatRepo;
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
        return "file_format";
    }

    // this method will fetch all settings from the db and populate the form drop-down list
    @GetMapping("file_format")
    public String getAllSettings(Model model) {
        Iterable<FileFormat> fileFormats = fileFormatRepo.findAll();
        //settings.forEach(System.out::println);
        //model.addAttribute("fileFormat", new FileFormat());
        model.addAttribute("fileFormats", fileFormats);

        return "file_format";
    }

    @PostMapping("/file_format")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile, @ModelAttribute("file_format")FileFormat fileFormat,HttpServletRequest request, Model m) {
        if (multipartFile.isEmpty()) {
            m.addAttribute("message", "Please select a file to upload!");
            return "index";
        } else {
            //if (csv file):
            Parser parser = new CsvParser();
            // if (json file):
            // Parser parser = new JsonParser();
            try {
                String file = parser.readFile(multipartFile);
                // https://stackoverflow.com/questions/18791645/how-to-use-session-attributes-in-spring-mvc
                request.getSession().setAttribute("file", file);
                // m.addAttribute("file", file);
            } catch (Exception e) {
                m.addAttribute("error", true);
                m.addAttribute("message", "Error occurred: " + e.getMessage());
            }
        }

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

package logViewer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    // TESTING
    @PostMapping("/file_format")
    public String goToSettings(@RequestParam("file") MultipartFile file, Model model) {
        //FileFormat fileFormat = new FileFormat();
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload!");
            return "index";
        }
        model.addAttribute("file", file);
        //model.addAttribute("file_settings", fileFormat.getName());

        return "file_format";
    }

    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }

    @GetMapping("/contact")
    public String showContact() {
        return "contact";
    }
}

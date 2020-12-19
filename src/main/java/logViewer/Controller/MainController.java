package logViewer.Controller;

import logViewer.Parser.CsvParser;
import logViewer.Parser.Parser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping("/")
    public String showIndex() {

        return "index";
    }

    // Read file and save it to session as a String
    @PostMapping("/")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request, Model m) {
        if (multipartFile.isEmpty()) {
            m.addAttribute("message", "Please select a file to upload!");

            return "index";
        } else {
            Parser parser = new CsvParser();
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

        return "redirect:/file_format";
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

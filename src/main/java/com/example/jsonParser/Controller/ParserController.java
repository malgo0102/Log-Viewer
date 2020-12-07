package com.example.jsonParser.Controller;

import com.example.jsonParser.Model.TableData;
import com.example.jsonParser.Parser.JsonParser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.List;

@Controller
public class ParserController {

  @GetMapping("/")
  public String showIndex(){
    return "index";
  }

  @GetMapping("/import")
  public String importSettings(Model m) {
    List<String> fileSettings = List.of("Novo Nordisk logs", "Rovsing logs", "Lenovo logs");
    m.addAttribute("file_settings", fileSettings);

    return "import";
  }

  @GetMapping("/table")
  public String showTable(Model m){
    JsonParser parser = new JsonParser();
    File file = new File("iris.json");
    TableData tableData = parser.parse(file);
    List<List<String>> rows = tableData.getRows();
    List<String> headers = tableData.getHeaders();

    m.addAttribute("headers", headers);
    m.addAttribute("rows", rows);

    return "table";
  }

//  @PostMapping("/table")
//  public String showTable(){

//    return "redirect:/table";
//  }
}

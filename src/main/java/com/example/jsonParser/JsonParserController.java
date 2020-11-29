package com.example.jsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JsonParserController {

  @GetMapping("/")
  public String showIndex(){
    return "index";
  }

  @PostMapping("/table")
  public String showTable(Model m){
    List<String> headers = new ArrayList<>();
    headers.add("#");
    headers.add("Timestamp");
    headers.add("Name");

    List<String> row = new ArrayList<>();
    row.add("1");
    row.add("ts");
    row.add("name1");

    List<List<String>> rows = new ArrayList<>();
    rows.add(row);

    m.addAttribute("headers", headers);
    m.addAttribute("rows", rows);

    return "table";
  }
}

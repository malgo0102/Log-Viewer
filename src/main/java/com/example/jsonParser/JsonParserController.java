package com.example.jsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class JsonParserController {

  @GetMapping("/")
  public String showIndex(){
    return "index";
  }

//  @GetMapping("/table")
//  public String showTable(){
//    return "table";
//  }

  @PostMapping("/table")
  public String showTable(Model m){
    JsonParser jsonParser = new JsonParser();
    LogData logData = new LogData();
    File file = new File("iris.json");
    logData = jsonParser.parse(file);
    ArrayList<HashMap<String, String>> rows = new ArrayList<>();
    List<String> headers = new ArrayList<>();
    for (String key : rows.get[0].keySet()) {
      System.out.println( key );
    }

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

    System.out.println(headers);
    System.out.println(row);
    System.out.println(rows);

    return "table";
  }
}

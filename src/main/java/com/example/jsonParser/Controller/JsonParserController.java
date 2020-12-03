package com.example.jsonParser.Controller;

import com.example.jsonParser.Model.TableData;

import com.example.jsonParser.Parser.Parser;
import org.springframework.boot.json.JsonParser;
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
    Parser parser = new Parser();
    TableData tableData = new TableData();
    File file = new File("iris.json");
    tableData = parser.parse(file);
    List<List<String>> rows = tableData.getRows();
    List<String> headers = tableData.getHeaders();


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

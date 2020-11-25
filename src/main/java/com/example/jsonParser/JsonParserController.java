package com.example.jsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JsonParserController {

  @Autowired
  private JsonParser jsonParser;

  @GetMapping("/")
  public String showIndex(){
    return "index";
  }

  @PostMapping("/log")
}

package com.example.jsonParser.Parser;

import com.example.jsonParser.Model.TableData;

import java.io.File;

public interface Parser {

  //LogData logData = new LogData();
  //File file = new File();

  TableData parse(File file);
}

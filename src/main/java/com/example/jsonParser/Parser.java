package com.example.jsonParser;

import java.io.File;

public interface Parser {

  //LogData logData = new LogData();
  //File file = new File();

  LogData parse(File file);
}

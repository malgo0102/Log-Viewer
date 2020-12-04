package com.example.jsonParser.Parser;

import com.example.jsonParser.Model.TableData;

import java.io.File;

public interface Parser {

  TableData parse(File file);

}

package com.example.jsonParser.Parser;

import java.io.File;
import java.io.FileReader;
import java.util.*;

import com.example.jsonParser.Model.TableData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonParser implements Parser {

  public TableData parse(File file){
    TableData tableData = new TableData();
    List<List<String>> rows = new ArrayList<>();
    try {
      JSONParser jsonParser = new JSONParser();


      List<String> row = new ArrayList<>();
      // Parsing file (array of jsons) and casting to JSONArray
      JSONArray ja = (JSONArray) jsonParser.parse(new FileReader(file));
      //
      for(int i=0; i<ja.size(); i++){
        JSONObject jo = (JSONObject)ja.get(i);
        Set<String> keys = jo.keySet();
        //System.out.println(jo.get("petalLength"));
        for(String key:keys){
          String value = jo.get(key).toString();
          row.add(value);
        }

        rows.add(row);
      }
    } catch(Exception e){
      e.printStackTrace();
    }
    tableData.
    tableData.setRows(rows);
    return tableData;
  }
}
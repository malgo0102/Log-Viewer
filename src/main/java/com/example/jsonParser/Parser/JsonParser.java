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

    Set<String> keys = new HashSet<>();

    try {
      JSONParser jsonParser = new JSONParser();
      // Parsing file (array of jsons) and casting to JSONArray
      JSONArray ja = (JSONArray) jsonParser.parse(new FileReader(file));

      for(int i=0; i<ja.size(); i++){
        JSONObject jo = (JSONObject)ja.get(i);

        keys = jo.keySet();
        List<String> row = new ArrayList<>();
        //System.out.println(jo.get("petalLength"));
        for(String key:keys){
          String value = jo.get(key).toString();
          row.add(value);
        }

        rows.add(row);
        System.out.println(row);
      }
    } catch(Exception e){
      e.printStackTrace();
    }
    List<String> headers = new ArrayList<>(keys);
    tableData.setHeaders(headers);
    tableData.setRows(rows);
    System.out.println(headers);
    //System.out.println(rows);

    return tableData;
  }
}
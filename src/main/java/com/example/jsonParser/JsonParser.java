package com.example.jsonParser;

import java.io.File;
import java.io.FileReader;
import java.util.*;

import com.example.jsonParser.Parser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser implements Parser {


  File file = new File("iris.json");

  public LogData parse(File file){
    LogData logData = new LogData();
    try {

      JSONParser jsonParser = new JSONParser();

      ArrayList<HashMap<String, String>> rows = new ArrayList<>();
      //https://stackoverflow.com/questions/47436239/how-do-i-parse-json-objects-from-a-jsonarray
      // Parsing file (array of jsons) and casting to JSONArray
      JSONArray ja = (JSONArray) jsonParser.parse(new FileReader(file));
      //
      for(int i=0; i<ja.size(); i++){
        JSONObject jo = (JSONObject)ja.get(i);
        Set<String> keys = jo.keySet();
        //System.out.println(jo.get("petalLength"));
        HashMap<String, String> map = new HashMap<>();
        //
        for(String key:keys){
          //System.out.println(key);
          String value = jo.get(key).toString();
          map.put(key,value);
        }

        rows.add(map);
        logData.setRows(rows);

        // https://www.tutorialspoint.com/json_simple/json_simple_quick_guide.htm
      }

    } catch(Exception e){
      e.printStackTrace();
    }
    return logData;
  }
}
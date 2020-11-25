import java.io.File;
import java.io.FileReader;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser{

  static void parse(){
    try {
      JSONParser jsonParser = new JSONParser();
      File file = new File("iris.json");

      ArrayList<Map<String, String>> rows = new ArrayList<>();
      //https://stackoverflow.com/questions/47436239/how-do-i-parse-json-objects-from-a-jsonarray
      // Parsing file (array of jsons) and casting to JSONArray
      JSONArray ja = (JSONArray) jsonParser.parse(new FileReader(file));
      //
      for(int i=0; i<ja.size(); i++){
        JSONObject jo = (JSONObject)ja.get(i);
        Set<String> keys = jo.keySet();
        //System.out.println(jo.get("petalLength"));
        Map<String, String> map = new HashMap<>();
        //
        for(String key:keys){
          System.out.println(key);
          String value = jo.get(key).toString();
          map.put(key,value);
        }
        rows.add(map);
        // https://www.tutorialspoint.com/json_simple/json_simple_quick_guide.htm
      }
    } catch(Exception e){
      e.printStackTrace();
    }
  }
}
package logViewer.Parser;

import logViewer.Model.TableData;

import java.io.FileReader;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonParser extends Parser {

    @Override
    public TableData parse(String file) {
        TableData tableData = new TableData();
        List<List<String>> rows = new ArrayList<>();
        Set<String> keys = new HashSet<>();

        try {
            JSONParser jsonParser = new JSONParser();
            // Parsing file (array of jsons) and casting to JSONArray
            JSONArray ja = (JSONArray) jsonParser.parse(new FileReader(file));

            for (int i = 0; i < ja.size(); i++) {
                JSONObject jo = (JSONObject) ja.get(i);
                keys = jo.keySet();
                List<String> row = new ArrayList<>();
                //System.out.println(jo.get("petalLength"));

                for (String key : keys) {
                    String value = jo.get(key).toString();
                    row.add(value);
                }

                rows.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> headers = new ArrayList<>(keys);

        tableData.setHeaders(headers);
        tableData.setRows(rows);

        return tableData;
    }
}
package logViewer.Parser;

import logViewer.Model.FileFormat;
import logViewer.Model.TableData;

import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonParser extends Parser {

    @Override
    public TableData parse(String file, FileFormat fileFormat) {
        TableData tableData = new TableData();
        List<List<String>> rows = new ArrayList<>();
        Set<String> keys = new HashSet<>();

        try {
            // org.json.simple.parser.JSONParser;
            JSONParser jsonParser = new JSONParser();
            // Parsing file (array of jsons) and casting to JSONArray
            JSONArray ja = (JSONArray) jsonParser.parse(file);

            for (int i = 0; i < ja.size(); i++) {
                JSONObject jo = (JSONObject) ja.get(i);
                keys = jo.keySet();
                List<String> row = new ArrayList<>();

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
package logViewer.Parser;

import logViewer.Model.TableData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CsvParser extends Parser {

    @Override
    public TableData parse(String file, FileFormat fileFormat) {
        TableData tableData = new TableData();

        // Create a list which holds lists of rows
        List<List<String>> rows = new ArrayList<>();

        // Create a list which holds table headers
        ArrayList<String> headers = new ArrayList<>();

        // Create a list which holds an event
        List<String> row = new ArrayList<>();

        // Read the file line by line
        String[] lines = file.split("\n");
        for (String line : lines) {
            // Get all row available in an event
            row = Arrays.asList(line.split(fileFormat.getRegex()));
            rows.add(row);
        }

        // Print all lines
        rows.forEach(System.out::println);

        //Populate headers if not included in selected setting
        //for (int i = 0; i < row.size(); i++) {
         //   headers.add("Header " + (i + 1));
       // }

        tableData.setHeaders(fileFormat.getHeaders());
        //tableData.setHeaders(headers);
        tableData.setRows(rows);

        return tableData;
    }


}

package logViewer.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TableData {

    private List<String> headers = new ArrayList<>();
    private List<List<String>> rows = new ArrayList<>();
    private List<String> column = new ArrayList<>();
    private List<List<String>> columns = new ArrayList<>();

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }

    public List<String> getColumn() {
        return column;
    }

    public void setColumn(List<String> column) {
        this.column = column;
    }

    public List<List<String>> getColumns() {
        return columns;
    }

    public void setColumns(List<List<String>> columns) {
        this.columns = columns;
    }

    public List<List<String>> rowsToColumns(List<List<String>> rows) {
        List<List<String>> columns = new ArrayList<>();
        for (List row : rows) {
            for (int i=0; i < row.size(); i++) {
                if (columns.size() < row.size()) {
                    List<String> column = new ArrayList<>();
                    columns.add(column);
                }
                columns.get(i).add(row.get(i).toString());
            }
        }
        //System.out.println(columns.get(0));

        return columns;
    }

    public List<Float> stringToFloatColumn(List<String> column) {
        List<Float> columnFloat = new ArrayList<>();
        for(String value : column) {
            columnFloat.add(Float.parseFloat(value));
        }

        return columnFloat;
    }

    public Float getMax(List<Float> column) {
        if (column == null || column.size() == 0)
            return Float.MIN_VALUE;

        return Collections.max(column);
    }

    public Float getMin(List<Float> column) {
        if (column == null || column.size() == 0)
            return Float.MAX_VALUE;

        return Collections.min(column);
    }

}

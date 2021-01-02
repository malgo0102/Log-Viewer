package logViewer.Model;

import java.util.ArrayList;
import java.util.Comparator;
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

        return columns;
    }

    public List<Double> stringToDoubleColumn(List<String> column) {
        List<Double> columnDouble = new ArrayList<>();
        for(String value : column) {
            columnDouble.add(Double.parseDouble(value));
        }

        return columnDouble;
    }

    public double getMax(List<Double> column) {
        double max = column.stream().max(Comparator.comparing(Double::valueOf)).get();
        return max;
    }

    public double getMin(List<Double> column) {
        double min = column.stream().min(Comparator.comparing(Double::valueOf)).get();

        return min;
    }

}

package com.example.jsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class LogData {

  //private HashMap<String, String> row = new HashMap<>();
  private ArrayList<HashMap<String, String>> rows = new ArrayList<>();

//  public HashMap<String, String> getRow() {
//    return row;
//  }
//  public void setRow(HashMap<String, String> data) {
//    this.row = data;
//  }

  public ArrayList<HashMap<String, String>> getRows() {
    return rows;
  }

  public void setRows(ArrayList<HashMap<String, String>> rows) {
    this.rows = rows;
  }



}

package com.example.jsonParser.Model;

public class FileFormat {
  // File extension
  private String fileType;
  private String regex;

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public String getRegex() {
    return regex;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }
}

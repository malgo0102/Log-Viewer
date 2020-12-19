package logViewer.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FileFormat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  // File extension
  private String fileType;
  private String regex;
  @ElementCollection
  private List<String> headers = new ArrayList<>();

  public FileFormat() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

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

  public List<String> getHeaders() {
    return headers;
  }

  public void setHeaders(List<String> headers) {
    this.headers = headers;
  }

  @Override
  public String toString() {
    return "FileFormat{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", fileType='" + fileType + '\'' +
            ", regex='" + regex + '\'' +
            ", headers=" + headers +
            '}';
  }

}

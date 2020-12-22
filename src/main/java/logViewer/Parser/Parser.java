package logViewer.Parser;

import logViewer.Model.TableData;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public abstract class Parser {

    public abstract TableData parse(String file);

    public String readFile(MultipartFile multipartFile) throws Exception {
        try {
            BufferedReader bufferedReader;
            // Create the file reader
            bufferedReader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
            String line = "";
            String file = "";
            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                // Save the file as a string with lines separated by new line
                file = file + line + "\n";
            }
            return file;
        } catch (Exception e) {
            throw new Exception("Error: couldn't process the file: " + e);
        }
    }

}

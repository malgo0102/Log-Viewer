### Log Viewer

This is a JAVA Spring Boot application for reading log files and representing them in a table.

Functionalities:
- Choose and upload file
- Select file format
- Parse file
- Search
- Generate chart
- Statistics 

**Input**

- CSV file
- JSON file

**Output**

Table wth log file data separated in events:
| Header 1 | Header 2 | Header 3 | Header 4 |
|----------|----------|----------|----------|
| Event1   | Event2   | Event 3  | Event 4  |



### How to run and use the system

1. Clone git repository by using `git clone <repository-url>`
2. Open the application using your prefer IDE (ex: IntelliJ IDEA)
3. Go to `application.properties` and add your database credentials (username, password)
4. Run the project
5. Open locahost:8080
6. Upload file, select parsing format and parse the file
7. Search, generate chart and see statistics
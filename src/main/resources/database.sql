DROP DATABASE log_viewer;
CREATE DATABASE log_viewer;

INSERT INTO file_format (id, file_type, name) VALUES ("1", "JSON", "My JSON setting");
INSERT INTO file_format (id, file_type, name, regex) VALUES ("2", "CSV", "My CSV setting", "[ ,^]+" );

INSERT INTO file_format_headers (file_format_id, headers) VALUES ("2", "IP address");
INSERT INTO file_format_headers (file_format_id, headers) VALUES ("2", "Date");
INSERT INTO file_format_headers (file_format_id, headers) VALUES ("2", "Request");
INSERT INTO file_format_headers (file_format_id, headers) VALUES ("2", "URL");
INSERT INTO file_format_headers (file_format_id, headers) VALUES ("2", "HTTP");
INSERT INTO file_format_headers (file_format_id, headers) VALUES ("2", "Status");
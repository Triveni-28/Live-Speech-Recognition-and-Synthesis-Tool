CREATE DATABASE IF NOT EXISTS speech_tool;
USE speech_tool;
CREATE TABLE IF NOT EXISTS speech_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    user_input TEXT NOT NULL,
    web_query TEXT NOT NULL,
    system_response TEXT NOT NULL
);

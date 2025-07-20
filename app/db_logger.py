import mysql.connector
from datetime import datetime
from app.config import DB_CONFIG

class DBLogger:
    def __init__(self):
        try:
            self.conn = mysql.connector.connect(**DB_CONFIG)
            self.cursor = self.conn.cursor()
            self._create_table()
        except mysql.connector.Error as err:
            print(f"[DB ERROR] {err}")

    def _create_table(self):
        self.cursor.execute("""
            CREATE TABLE IF NOT EXISTS speech_logs (
                id INT AUTO_INCREMENT PRIMARY KEY,
                input_text TEXT NOT NULL,
                output_text TEXT NOT NULL,
                timestamp DATETIME DEFAULT CURRENT_TIMESTAMP
            )
        """)
        self.conn.commit()

    def log(self, input_text, output_text):
        try:
            query = "INSERT INTO speech_logs (input_text, output_text, timestamp) VALUES (%s, %s, %s)"
            values = (input_text, output_text, datetime.now())
            self.cursor.execute(query, values)
            self.conn.commit()
        except mysql.connector.Error as err:
            print(f"[LOG ERROR] {err}")

    def close(self):
        if self.conn.is_connected():
            self.cursor.close()
            self.conn.close()

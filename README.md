Speech Recognition Tool - Accessibility Assistant
Offline Speech-to-Speech Search Tool (Java and Python Versions)

Overview:
This project is an offline voice-based assistant designed for accessibility, especially for visually impaired users. It captures real-time voice input, performs a web search, reads out the result using text-to-speech, and logs each interaction. The tool is available in two versions: one built in Java and the other in Python.

Common Features:
Voice input using microphone

Web search performed based on spoken query

Speaks the top result aloud using text-to-speech

Logs voice queries into a MySQL database

Offline support for speech recognition and TTS

Accessible design for users with visual or reading impairments

Java Version:

Technologies Used-

CMU Sphinx for voice recognition

FreeTTS for text-to-speech output

Jsoup for web scraping

MySQL for local logging

Java Swing for basic interface or console-based

How to Run-

Install Java Development Kit (JDK)

Set up MySQL and run the SQL script to create the database

Download required libraries: freetts jar, jsoup jar, mysql connector jar

Place jars in a lib folder and include them in your project

Configure CMU Sphinx model files in the resources folder

Run Main.java file

Python Version:

Technologies Used-

SpeechRecognition library for capturing audio

pyttsx3 for offline text-to-speech

Requests and BeautifulSoup for search and scraping

MySQL for logging user queries

Flask for basic user interface

How to Run-

Install Python 3.8 or higher

Install the required Python libraries using pip

Set up MySQL and run the SQL script to create the database

Update your database credentials in the script

Run the Python file

#Access the tool via the Flask UI or directly through terminal input

MySQL Setup (Common for both versions):

Create the database and table by executing-

Create database speech_logs
Use speech_logs
Create table queries
id int auto_increment primary key
query_text text
timestamp timestamp default current_timestamp

Deployment:

Both versions can be used as standalone offline desktop applications

Optional: Package the Java version into a JAR and create an installer

Optional: Deploy the Python version online using AWS EC2 for extended accessibility

Use Cases:

Assisting blind or visually impaired users to access web information

Supporting users with reading or language difficulties

Voice-controlled search tool for classrooms, libraries, and kiosks

Future Scope:

Multilingual voice support

Wake-word detection like Hey Assistant

Cloud deployment with HTTPS

Voice-based navigation for websites or desktop apps

License:
This project is licensed under the MIT License

Author:
Triveni G
Year 2025

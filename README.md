Speech Recognition Tool – Accessibility Assistant (Offline)
-Hackathon Project Offline Project | Java + SQL  
-Real-Time Speech-to-Speech Assistant designed for **visually impaired** users.  
-Works **without GUI** and responds through voice using open-source tools.

Features
-Converts **speech input** to text using CMU Sphinx
-Performs **web search** with Jsoup
-Responds back using **FreeTTS**
-Logs queries to **MySQL database**
-Fully designed with **accessibility and offline use** in mind

Project Structure
SpeechRecognitionTool/
├── app/
│ ├── src/
│ │ └── main/java/com/speechapp/
│ │ ├── SpeechApp.java 
│ │ ├── VoiceListener.java 
│ │ ├── WebSearcher.java 
│ │ ├── TTSOutput.java 
│ │ └── DatabaseManager.java 
│ ├── lib/ (JARs (not committed to GitHub))
│ ├── resources/
│ │ └── sphinx-config/ (Acoustic models, dictionaries)
│ └── index.html 
├── README.md
└── .gitignore
|__run.java
|__deployment_online_instructions.txt

Requirements
- Java JDK 11 or higher
- MySQL Server
- Microphone access (for speech input)
- Internet (optional, for live search)
- Downloaded libraries:
  - `freetts.jar`
  - `jsoup-1.15.4.jar`
  - `mysql-connector-java-8.0.xx.jar`
  - CMU Sphinx acoustic model files

Installation & Setup
Clone the Repository
```bash
git clone https://github.com/<your-username>/SpeechRecognitionTool.git
cd SpeechRecognitionTool

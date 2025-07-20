Speech Recognition Tool - Python (Offline Version)

Voice-Enabled Real-Time Search Tool

This project is a Python-based speech-to-speech accessibility tool designed for users with language or reading barriers. It listens to speech input, searches the web for answers, and reads the result aloud — completely offline (except web search, which uses minimal internet). Designed especially for visually impaired users.

Features
- Real-time speech input using microphone.
- Web search performed based on spoken query.
- Reads out the first result using text-to-speech (TTS).
- Python backend with Flask-based minimal UI.
- Stores query history in MySQL database.
- Accessibility-first design.
 
Tech Stack
- Python 3.8+
- Flask - Web interface
- SpeechRecognition - For capturing voice input
- pyttsx3- Offline TTS engine
- BeautifulSoup (bs4)- Web scraping
- MySQL- Logging past voice queries

Folder Structure
SpeechRecognitionTool_Python/
│
├── app/
│   ├── main.py               # Flask entrypoint
│   ├── speech_handler.py     # Captures and transcribes audio
│   ├── web_searcher.py       # Searches the web
│   ├── speaker.py            # Reads aloud the response
│   ├── db_logger.py          # Logs interactions to MySQL
│   ├── config.py             # DB credentials & configs
│   |__UI.py
├── templates/
│   ├── index.html            # Minimal frontend
│
├── static/
│   ├── style.css             # Styling for UI
│
├── run_offline.py            # Script to run offline web app
├── requirements.txt          # Dependencies
├── speech_tool.sql           # MySQL DB schema
├── README.md                 # Project documentation


Installation
1.Clone the Repository
```bash
git clone https://github.com/yourusername/SpeechRecognitionTool_Python.git
cd SpeechRecognitionTool_Python
```
2. Set up a Python Virtual Environment (Optional but recommended)
```bash
python -m venv venv
source venv/bin/activate   # On Windows: venv\Scripts\activate
```
3. Install Dependencies
```bash
pip install -r requirements.txt
```

4. Configure MySQL
- Open `app/config.py` and enter your MySQL username, password, and database name.
- Create the database using the script:

```bash
mysql -u root -p < speech_tool.sql
```

Running the Tool (Offline)

```bash
python run_offline.py
```

Then open your browser and go to: `http://127.0.0.1:5000`
How It Works

- You click the "Start Listening" button.
- The app records your voice, transcribes it, and searches it on the web.
- It fetches the first result, converts it to speech, and speaks it out loud.
- Every interaction is stored in a MySQL table for future analysis or audit.

Dependencies
- Flask
- speechrecognition
- pyttsx3
- pyaudio
- mysql-connector-python
- beautifulsoup4
- requests

Future Upgrades

- AWS Lambda integration for online speech processing
- Add support for multiple languages
- Store history in cloud DB (RDS) or NoSQL
- Voice-activated GUI (voice commands instead of buttons)

Use Case
This tool can assist:

- Visually impaired users
- Users with reading or literacy challenges
- Users wanting a screenless query experience (like Alexa)


Developed By
G Triveni – 6th Sem, CSE  
GSSSIETW, Mysuru | 2025 Hackathon Project

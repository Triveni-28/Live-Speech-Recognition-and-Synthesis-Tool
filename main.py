from app.speech_listener import listen_to_user
from app.web_searcher import search_web
from app.speaker import speak
from app.database_logger import log_to_db
from flask import Flask, render_template, request, jsonify

app = Flask(__name__)

@app.route("/")
def index():
    return render_template("index.html")

@app.route("/start", methods=["POST"])
def start_interaction():
    try:
        query = listen_to_user()
        if not query:
            return jsonify({"response": "Sorry, I didn't catch that."})

        result = search_web(query)
        speak(result)
        log_to_db(query, result)
        return jsonify({"response": result})

    except Exception as e:
        return jsonify({"response": f"Error: {str(e)}"})

if __name__ == "__main__":
    app.run(debug=True)

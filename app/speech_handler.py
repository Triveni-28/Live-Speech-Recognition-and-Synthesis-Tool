import speech_recognition as sr

def listen_to_user(language="en-US"):
    recognizer = sr.Recognizer()
    mic = sr.Microphone()

    with mic as source:
        print("Listening... Please speak now.")
        recognizer.adjust_for_ambient_noise(source)
        audio = recognizer.listen(source)

    try:
        print("Recognizing...")
        text = recognizer.recognize_google(audio, language=language)
        print(f"You said: {text}")
        return text

    except sr.UnknownValueError:
        print("Sorry, could not understand your speech.")
        return None
    except sr.RequestError as e:
        print(f"Could not request results from Google Speech Recognition; {e}")
        return None

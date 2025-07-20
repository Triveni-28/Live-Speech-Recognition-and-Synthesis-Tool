import pyttsx3

class Speaker:
    def __init__(self, voice_gender="female", rate=150):
        self.engine = pyttsx3.init()
        voices = self.engine.getProperty('voices')

        # Set voice based on gender
        if voice_gender == "female":
            self.engine.setProperty('voice', voices[1].id)  # Usually index 1 is female
        else:
            self.engine.setProperty('voice', voices[0].id)  # Usually index 0 is male

        self.engine.setProperty('rate', rate)

    def speak(self, text):
        print(f"Speaking: {text}")
        self.engine.say(text)
        self.engine.runAndWait()

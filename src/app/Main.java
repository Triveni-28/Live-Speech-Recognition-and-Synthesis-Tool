package app;

public class Main {
    public static void main(String[] args) {
        SpeechListener listener = new SpeechListener();
        String query = listener.listen();

        if (query != null && !query.isEmpty()) {
            String result = WebSearcher.search(query);
            Speaker.speak(result);
            DatabaseLogger.logQuery(query, result);
        } else {
            Speaker.speak("Sorry, I didn't catch that.");
        }
    }
}

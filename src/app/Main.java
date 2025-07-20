package app;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Speech Recognition Tool...");
        String query = SpeechListener.listen();
        if (query != null && !query.isEmpty()) {
            String result = WebSearcher.search(query);
            Speaker.speak(result);
            DatabaseLogger.log(query, result);
        }
    }
}

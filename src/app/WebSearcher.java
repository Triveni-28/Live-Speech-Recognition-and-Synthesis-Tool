package app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebSearcher {
    public static String search(String query) {
        try {
            String url = "https://en.wikipedia.org/wiki/" + query.replace(" ", "_");
            Document doc = Jsoup.connect(url).get();
            Elements paragraphs = doc.select("p");
            return paragraphs.first().text();
        } catch (Exception e) {
            return "Sorry, I couldn't find information.";
        }
    }
}

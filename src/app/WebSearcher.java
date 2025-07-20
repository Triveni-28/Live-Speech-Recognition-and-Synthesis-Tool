package app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebSearcher {
    public static String search(String query) {
        try {
            String url = "https://www.google.com/search?q=" + query.replace(" ", "+");
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
            Elements results = doc.select("div[data-attrid='wa:/description'] span");
            if (!results.isEmpty()) {
                return results.first().text();
            } else {
                return "No result found.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to fetch result.";
        }
    }
}


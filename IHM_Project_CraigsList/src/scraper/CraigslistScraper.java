package scraper;

import models.Forum;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CraigslistScraper {

    public List<Forum> scrapeForums(String url) throws IOException {
        List<Forum> forums = new ArrayList<>();  
        Document doc = Jsoup.connect(url).get();
        Elements forumLists = doc.select("ul.col li");

        for (Element forum : forumLists) {
            
            String name = forum.select("a").text().replaceAll("\\s*\\d+$", "");
            String link = "https://forums.craigslist.org/" + forum.select("a").attr("href");
            Element threadCountElement = forum.selectFirst(".threadcount");
            int threadCount = 0;
            if (threadCountElement != null) {
                threadCount = Integer.parseInt(threadCountElement.text());
            }
            forums.add(new Forum(name, link, threadCount));
        }
        return forums;
    }
}

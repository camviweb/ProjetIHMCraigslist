import scraper.CraigslistScraper;
import models.Forum;

import java.io.IOException;
import java.util.List;

import analysis.DataAnalyzer;

public class MainScraper {
	public static void main(String [] args) throws IOException {
		String url = "https://forums.craigslist.org/?areaID=81";
		System.out.println("--Démarrage du Scraping--"+"\n");
		
		CraigslistScraper scraper = new CraigslistScraper();
		List<Forum> forums= scraper.scrapeForums(url);
		
		if(forums.isEmpty()) {
			System.out.println("Aucune donnée récupérée.");
			return;
		}
		
		System.out.println("Scraping terminé. "+ forums.size()+ " forums récupérés."+"\n");
		
		System.out.println("--Analyse des données--"+"\n");
		DataAnalyzer.analyzeForums(forums);

	}
	

}

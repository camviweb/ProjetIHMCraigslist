package analysis;

import models.Forum;
import java.util.List;

public class DataAnalyzer {

    public static void analyzeForums(List<Forum> forums) {
       
        System.out.println("Nombre total de forums : " + forums.size());

        Forum mostActive = null;
        for (Forum forum : forums) {
            if (mostActive == null || forum.getThreadCount() > mostActive.getThreadCount()) {
                mostActive = forum;
            }
        }
        if (mostActive != null) {
            System.out.println("Forum le plus actif : " + mostActive.getName()
                    + " avec " + mostActive.getThreadCount() + " discussions.");
        }

        int inactiveForums = 0;
        for (Forum forum : forums) {
            if (forum.getThreadCount() == 0) {
                inactiveForums++;
            }
        }
        System.out.println("Nombre de forums sans discussions : " + inactiveForums);

        int totalDiscussions = 0;
        for (Forum forum : forums) {
            totalDiscussions += forum.getThreadCount();
        }
        double averageDiscussions = forums.isEmpty() ? 0 : (double) totalDiscussions / forums.size();
        System.out.println("Nombre  de discussions moyen par forum : " + String.format("%.2f", averageDiscussions));

        System.out.println("\nListe des forums :");
        for (Forum forum : forums) {
            System.out.println(forum);
        }
    }
}


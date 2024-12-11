package application;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProduitModel {
    private String headerText = "En-tête du Forum";
    private String navText = "Barre de Navigation";
    private String contentText = "Zone de Contenu";
    private String footerText = "Pied de Page";

    public String getHeaderText() {
        return headerText;
    }

    public String getNavText() {
        return navText;
    }

    public String getContentText() {
        return contentText;
    }

    public String getFooterText() {
        return footerText;
    }
}


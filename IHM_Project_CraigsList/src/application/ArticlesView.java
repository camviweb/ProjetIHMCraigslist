package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ArticlesView {
    private HBox topHBox;
    private HBox navHBox;
    private HBox footer;
    private Button btnImage1;
    private VBox mainContent; // Utilisation de VBox pour empiler les sections verticalement

    public ArticlesView() {
        topHBox = createTopHBox();
        navHBox = createNavHBox();
        footer = createFooter();
        mainContent = createMainContent();
    }

    public HBox getTopHBox() {
        return topHBox;
    }

    public HBox getNavHBox() {
        return navHBox;
    }

    public HBox getFooter() {
        return footer;
    }

    public VBox getMainContent() {
        return mainContent;
    }
    
    public Button getButton() {
    	return btnImage1;
    }

    // Méthode pour créer l'en-tête (top box)
    private HBox createTopHBox() {
        HBox headerBox = new HBox();
        headerBox.setPadding(new Insets(10));
        headerBox.setSpacing(10);
        headerBox.getStyleClass().add("header");

        // Logo et titre
        Image logoImage = new Image(getClass().getResourceAsStream("/application/img/logo_cs.png"));
        ImageView logoView = new ImageView(logoImage);
        logoView.setFitWidth(50);
        logoView.setFitHeight(50);

        Label titleLabel = new Label("CraigsList", logoView);
        titleLabel.setContentDisplay(ContentDisplay.LEFT);
        titleLabel.getStyleClass().add("title");

        // Barre de recherche
        HBox searchBox = new HBox(5);
        searchBox.setStyle("-fx-alignment: center;");
        TextField searchField = new TextField();
        searchField.setPromptText("Recherche");
        searchField.getStyleClass().add("searchfield");

        Button searchButton = new Button("🔍");
        searchButton.getStyleClass().add("search-button");

        searchBox.getChildren().addAll(searchField, searchButton);

        // Icônes avec libellés
        VBox favoritesBox = createIconWithLabel("/application/img/favorites.png", "Favoris");
        VBox chatBox = createIconWithLabel("/application/img/chat.png", "Chat");
        VBox accountBox = createIconWithLabel("/application/img/account.png", "Compte");
        VBox languageBox = createIconWithLabel("/application/img/language.png", "Français");

        HBox rightIcons = new HBox(20, favoritesBox, chatBox, accountBox, languageBox);
        rightIcons.setSpacing(20);

        // Espacement flexible
        Region leftSpacer = new Region();
        Region rightSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        headerBox.getChildren().addAll(titleLabel, leftSpacer, searchBox, rightSpacer, rightIcons);
        return headerBox;
    }

    private VBox createIconWithLabel(String iconPath, String labelText) {
        Image iconImage = new Image(getClass().getResourceAsStream(iconPath));
        ImageView iconView = new ImageView(iconImage);
        iconView.setFitWidth(40); // Taille agrandie
        iconView.setFitHeight(40);

        Label label = new Label(labelText);
        label.setStyle("-fx-font-size: 12px; -fx-text-alignment: center;");

        VBox iconWithLabel = new VBox(5, iconView, label);
        iconWithLabel.setStyle("-fx-alignment: center;");
        return iconWithLabel;
    }

    private HBox createNavHBox() {
        HBox navBox = new HBox();
        navBox.setPadding(new Insets(10));
        navBox.setSpacing(5);
        navBox.getStyleClass().add("navbar");

        // Créer les boutons des sections
        Button servicesButton = new Button("Services");
        Button jobsButton = new Button("Emplois");
        Button forumsButton = new Button("Forums");
        Button sellButton = new Button("À Vendre");
        Button realEstateButton = new Button("Immobilier");
        Button cvButton = new Button("CV");

        // Appliquer la classe CSS par défaut pour tous les boutons
        servicesButton.getStyleClass().add("nav-button");
        jobsButton.getStyleClass().add("nav-button"); // Activer le style pour le bouton "A Vendre"
        forumsButton.getStyleClass().add("nav-button"); 
        sellButton.getStyleClass().add("nav-button-active");
        realEstateButton.getStyleClass().add("nav-button");
        cvButton.getStyleClass().add("nav-button");

        // Configuration de l'espacement flexible pour que les boutons remplissent l'espace
        HBox.setHgrow(servicesButton, Priority.ALWAYS);
        HBox.setHgrow(jobsButton, Priority.ALWAYS);
        HBox.setHgrow(forumsButton, Priority.ALWAYS);
        HBox.setHgrow(sellButton, Priority.ALWAYS);
        HBox.setHgrow(realEstateButton, Priority.ALWAYS);
        HBox.setHgrow(cvButton, Priority.ALWAYS);

        // Définir la largeur maximale des boutons pour qu'ils prennent toute la largeur disponible
        servicesButton.setMaxWidth(Double.MAX_VALUE);
        jobsButton.setMaxWidth(Double.MAX_VALUE);
        forumsButton.setMaxWidth(Double.MAX_VALUE);
        sellButton.setMaxWidth(Double.MAX_VALUE);
        realEstateButton.setMaxWidth(Double.MAX_VALUE);
        cvButton.setMaxWidth(Double.MAX_VALUE);

        // Ajouter les boutons à la barre de navigation
        navBox.getChildren().addAll(
            servicesButton,
            jobsButton,
            forumsButton,
            sellButton,
            realEstateButton,
            cvButton
        );

        return navBox;
    }

    
    // Contenu principal avec les sections des thèmes en vertical
    private VBox createMainContent() {
		// Créer le conteneur HBox central
		VBox centre = new VBox();
		centre.setPadding(new Insets(10, 0, 30, 0));
		
		// Créer le conteneur HBox filtres de recherche 
		HBox filtres = new HBox(70);
		filtres.setPadding(new Insets(15, 0, 15, 0));
		
		//Créer le conteneur HBox filtres de recherche 
		HBox images = new HBox(120);
		images.setPadding(new Insets(15, 0, 15, 0));
		
		
		// Ajouter les filtres
		Button btnCategory = new Button("Catégorie		>");
		Button btnLocation = new Button("Localisation		>");
		Button btnPrix = new Button("Prix		>");
		Button btnPlusFiltres = new Button("Plus de filtres		>");
		btnCategory.getStyleClass().add("button-filtres");
		btnLocation.getStyleClass().add("button-filtres");
		btnPrix.getStyleClass().add("button-filtres");
		btnPlusFiltres.getStyleClass().add("button-filtres");
		
		// Créer des régions flexibles pour les filtres 
		Region leftSpacer4 = new Region();
		Region rightSpacer4 = new Region();
					
		// Ajouter des labels au footer 
		HBox.setHgrow(leftSpacer4, Priority.ALWAYS);
		HBox.setHgrow(rightSpacer4, Priority.ALWAYS);
		
		filtres.getChildren().addAll(leftSpacer4, btnCategory, btnLocation, btnPrix, btnPlusFiltres, rightSpacer4);
		
		Label labelCentre = new Label("En ce moment sur CraigsList");
		labelCentre.getStyleClass().add("label-articles");
		
		//Creation des images des produits avec leurs description
		VBox box1 = new VBox();
		Image image1 = new Image(getClass().getResourceAsStream("/application/img/img1.png"));
		ImageView imageView1 = new ImageView(image1);
		btnImage1 = new Button("Pendentif Coeur \n5€");
		btnImage1.getStyleClass().add("button-articles");
		
		box1.getChildren().addAll(imageView1, btnImage1);
	
		VBox box2 = new VBox();
		Image image2 = new Image(getClass().getResourceAsStream("/application/img/img2.png"));
		ImageView imageView2 = new ImageView(image2);
		Button btnImage2 = new Button("Sony PlayStation (PS5) \n350€");
		btnImage2.getStyleClass().add("button-articles");
		
		box2.getChildren().addAll(imageView2, btnImage2);
		
		VBox box3 = new VBox();
		Image image3 = new Image(getClass().getResourceAsStream("/application/img/img3.png"));
		ImageView imageView3= new ImageView(image3);
		Button btnImage3 = new Button("Replica - Eau de parfum \n100€");
		btnImage3.getStyleClass().add("button-articles");
		
		box3.getChildren().addAll(imageView3, btnImage3);
		
		// Propriétés de l'image
		imageView1.setFitWidth(250);
		imageView1.setFitHeight(250);
		
		imageView2.setFitWidth(250);
		imageView2.setFitHeight(250);
		
		imageView3.setFitWidth(250);
		imageView3.setFitHeight(250);
		
		// Créer des régions flexibles pour les filtres 
		Region leftSpacer5 = new Region();
		Region rightSpacer5 = new Region();
							
		// Ajouter les labels au filtres 
		HBox.setHgrow(leftSpacer5, Priority.ALWAYS);
		HBox.setHgrow(rightSpacer5, Priority.ALWAYS);
		        
		images.getChildren().addAll(leftSpacer5, box1, box2, box3, rightSpacer5);
		
		centre.getChildren().addAll(filtres, labelCentre, images);
		
    	return centre;
    }

    private HBox createFooter() {
        HBox footerBox = new HBox();
        footerBox.setPadding(new Insets(10));
        footerBox.setSpacing(5);
        footerBox.getStyleClass().add("footer");

        Button helpButton = new Button("Aide");
        Button faqButton = new Button("FAQ");
        Button legalButton = new Button("Mentions Légales");
        Button privacyButton = new Button("Politique de confidentialité");

        helpButton.getStyleClass().add("footer-button");
        faqButton.getStyleClass().add("footer-button");
        legalButton.getStyleClass().add("footer-button");
        privacyButton.getStyleClass().add("footer-button");

        HBox.setHgrow(helpButton, Priority.ALWAYS);
        HBox.setHgrow(faqButton, Priority.ALWAYS);
        HBox.setHgrow(legalButton, Priority.ALWAYS);
        HBox.setHgrow(privacyButton, Priority.ALWAYS);

        helpButton.setMaxWidth(Double.MAX_VALUE);
        faqButton.setMaxWidth(Double.MAX_VALUE);
        legalButton.setMaxWidth(Double.MAX_VALUE);
        privacyButton.setMaxWidth(Double.MAX_VALUE);

        footerBox.getChildren().addAll(helpButton, faqButton, legalButton, privacyButton);
        return footerBox;
    }
}

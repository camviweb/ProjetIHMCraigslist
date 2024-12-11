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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ProduitView {
    private HBox topHBox;
    private HBox navHBox;
    private HBox footer;
    private HBox images;
    private VBox mainContent; // Utilisation de VBox pour empiler les sections verticalement

    public ProduitView() {
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
    
    public HBox getImages() {
    	return images;
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
        jobsButton.getStyleClass().add("nav-button"); 
        forumsButton.getStyleClass().add("nav-button"); 
        sellButton.getStyleClass().add("nav-button-active"); // Activer le style pour le bouton "A Vendre"
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
		VBox centre = new VBox(10);
		centre.setPadding(new Insets(30,0,30,0));
		
		// Créer le conteneur HBox user : l'utilisateur qui poste l'annonce
		HBox user = new HBox();
		user.setPadding(new Insets(10,560,10,10));
		HBox.setMargin(user, new Insets(0, 0, 0, 150));
		user.setStyle("	-fx-font-family: TT Fors; -fx-background-color: white; ");
		
		Image userIcon = new Image(getClass().getResourceAsStream("/application/img/account.png"));
		ImageView imageViewIcon = new ImageView(userIcon);
		imageViewIcon.setFitWidth(30);
		imageViewIcon.setFitHeight(30);
		Label labelUser = new Label("tolbiac013");
		labelUser.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
		Label labelDate = new Label(", il y a 3 jours");
		labelDate.setStyle("-fx-font-size: 18px; ");
		Image stars = new Image(getClass().getResourceAsStream("/application/img/stars.png"));
		ImageView imageViewStars = new ImageView(stars);
		imageViewStars.setFitWidth(155);
		imageViewStars.setFitHeight(30);
		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		user.getChildren().addAll(imageViewIcon, labelUser, labelDate, imageViewStars);
		HBox wrapper = new HBox();
		wrapper.getChildren().add(user);
		
		// Créer le conteneur HBox content : la photo et le description du produit
		HBox content = new HBox(20);
		content.setAlignment(Pos.CENTER);
		
		Image image1 = new Image(getClass().getResourceAsStream("/application/img/img1.png"));
		ImageView imageView1 = new ImageView(image1);
		imageView1.setFitWidth(350);
		imageView1.setFitHeight(350);
		
		// Créer le conteneur VBox avec le description du produit
		VBox text = new VBox();
		text.setPadding(new Insets(10));
		text.getStyleClass().add("produit-description");
		
		Label titre = new Label("Pendentif Coeur 5€");
		titre.setStyle("-fx-text-fill: #8c52ff; -fx-font-size: 30px;");
		
		Label description = new Label("Description :");
		description.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		Label textDescription = new Label("Magnifique pendentif en forme de cœur, en or véritable, idéal pour un\n"
				+ "cadeau ou pour compléter votre collection de bijoux. Ce bijou délicat\n"
				+ "allie élégance et simplicité, parfait pour toutes les occasions.");
		textDescription.setStyle("-fx-font-size: 18px;");
		
		Label etat = new Label("État :");
		etat.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		Label textEtat = new Label("Occasion, bien entretenue.");
		textEtat.setStyle("-fx-font-size: 18px;");
		
		Label localisation = new Label("Localisation :");
		localisation.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		Label textLocalisation = new Label("Paris, Île de France, France");
		textLocalisation.setStyle("-fx-font-size: 18px;");
		
		Button btnAcheter = new Button("Acheter");
		btnAcheter.getStyleClass().add("nav-button-active");
		btnAcheter.setStyle("-fx-cursor: hand; ");
		
		text.getChildren().addAll(titre, description, textDescription, etat, textEtat, localisation, textLocalisation, btnAcheter);
		content.getChildren().addAll(imageView1, text);

		centre.getChildren().addAll(wrapper, content);
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

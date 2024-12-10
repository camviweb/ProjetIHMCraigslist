package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class HomeView {
    private HBox topHBox;
    private HBox navHBox;
    private VBox mainContent;
    private HBox footer;

    public HomeView() {
        topHBox = createTopHBox();
        navHBox = createNavHBox();
        mainContent = createMainContent();
        footer = createFooter();
    }

    public HBox getTopHBox() {
        return topHBox;
    }

    public HBox getNavHBox() {
        return navHBox;
    }

    public VBox getMainContent() {
        return mainContent;
    }
    public HBox getFooter() {
        return footer;
    }

    public VBox getMainLayout() {
        VBox layout = new VBox();
        layout.getChildren().addAll(topHBox, navHBox, mainContent, footer);
        layout.setSpacing(0); // Espacement entre les sections
        layout.setPadding(new Insets(0)); // Marges autour du layout
        return layout;
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

    // Méthode pour créer la barre de navigation
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

        servicesButton.getStyleClass().add("nav-button");
        jobsButton.getStyleClass().add("nav-button");
        forumsButton.getStyleClass().add("nav-button");
        sellButton.getStyleClass().add("nav-button");
        realEstateButton.getStyleClass().add("nav-button");
        cvButton.getStyleClass().add("nav-button");

        HBox.setHgrow(servicesButton, Priority.ALWAYS);
        HBox.setHgrow(jobsButton, Priority.ALWAYS);
        HBox.setHgrow(forumsButton, Priority.ALWAYS);
        HBox.setHgrow(sellButton, Priority.ALWAYS);
        HBox.setHgrow(realEstateButton, Priority.ALWAYS);
        HBox.setHgrow(cvButton, Priority.ALWAYS);

        servicesButton.setMaxWidth(Double.MAX_VALUE);
        jobsButton.setMaxWidth(Double.MAX_VALUE);
        forumsButton.setMaxWidth(Double.MAX_VALUE);
        sellButton.setMaxWidth(Double.MAX_VALUE);
        realEstateButton.setMaxWidth(Double.MAX_VALUE);
        cvButton.setMaxWidth(Double.MAX_VALUE);

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

    // Contenu principal
    private VBox createMainContent() {
        VBox mainContentBox = new VBox();
        mainContentBox.getStyleClass().add("main-content"); // Classe CSS pour le style global du contenu principal

        // Section gauche : Image
        VBox leftBox = new VBox();
        Image mainImage = new Image(getClass().getResourceAsStream("/application/img/dressing.png")); 
        ImageView mainImageView = new ImageView(mainImage);
        mainImageView.setFitWidth(700); // Largeur ajustée
        mainImageView.setPreserveRatio(true);

        leftBox.getChildren().add(mainImageView);
        leftBox.getStyleClass().add("left-box"); // Classe CSS pour la section gauche
        leftBox.setAlignment(Pos.CENTER); // Centrer l'image dans la VBox

     // Section droite : Titre et bouton
        VBox rightBox = new VBox();
        Label title = new Label("Le site de petites annonces et de forums de discussion");
        title.getStyleClass().add("main-title"); // Classe CSS pour le titre principal

        // Charger l'icône
        Image plusIcon = new Image(getClass().getResourceAsStream("/application/img/plus_icon.png"));
        ImageView plusIconView = new ImageView(plusIcon);
        plusIconView.setFitWidth(20); // Largeur ajustée pour l'icône
        plusIconView.setFitHeight(20); // Hauteur ajustée pour l'icône

        // Créer le bouton avec l'icône
        Button actionButton = new Button(" Déposez votre annonce en un clic !", plusIconView);
        actionButton.getStyleClass().add("action-button"); // Classe CSS pour le bouton d'action
        actionButton.setContentDisplay(ContentDisplay.LEFT); // Positionner l'icône à gauche du texte

        rightBox.getChildren().addAll(title, actionButton);
        rightBox.getStyleClass().add("right-box"); // Classe CSS pour la section droite
        rightBox.setAlignment(Pos.CENTER); // Centrer le contenu verticalement
        rightBox.setSpacing(35); // Espacement vertical entre les éléments


        // Conteneur central : Divise l'image à gauche et le texte à droite
        HBox centralBox = new HBox();
        centralBox.getChildren().addAll(leftBox, rightBox);
        centralBox.getStyleClass().add("central-box"); // Classe CSS pour le conteneur central
        centralBox.setSpacing(100); // Espacement horizontal entre les deux colonnes
        centralBox.setAlignment(Pos.CENTER);

        // Ajouter le conteneur central au contenu principal
        mainContentBox.getChildren().add(centralBox);
        VBox.setVgrow(mainContentBox, Priority.ALWAYS); // Permet au contenu principal de pousser le footer vers le bas

        return mainContentBox;
    }



    // Méthode pour créer le footer
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

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

public class ForumView {
    private HBox topHBox;
    private HBox navHBox;
    private HBox footer;
    private VBox mainContent; // Utilisation de VBox pour empiler les sections verticalement

    public ForumView() {
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
        forumsButton.getStyleClass().add("nav-button-active"); // Activer le style pour le bouton "Forums"
        sellButton.getStyleClass().add("nav-button");
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
        VBox mainContentBox = new VBox();
        mainContentBox.setPadding(new Insets(20));
        mainContentBox.setSpacing(20);
        mainContentBox.setStyle("-fx-background-color: #EBD1EF;");

        // Titre principal
        Label mainTitle = new Label("Voici nos forums ! ");
        mainTitle.getStyleClass().add("main-title"); // Appliquer la classe CSS
        mainTitle.setAlignment(Pos.CENTER);
        mainTitle.setMaxWidth(Double.MAX_VALUE);

        // Petite phrase sous le titre
        Label subtitle = new Label("Si tu n'as pas trouvé ton bonheur, tu peux également créer un nouveau forum !");
        subtitle.getStyleClass().add("subtitle"); // Appliquer la classe CSS
        subtitle.setAlignment(Pos.CENTER);
        subtitle.setMaxWidth(Double.MAX_VALUE);

        // Bouton "Publier une nouvelle discussion" avec une image
        Image chatIcon = new Image(getClass().getResourceAsStream("/application/img/white_chat_icon.png")); // Charger l'image
        ImageView chatIconView = new ImageView(chatIcon);
        chatIconView.setFitWidth(20); // Ajuster la largeur de l'image
        chatIconView.setFitHeight(20); // Ajuster la hauteur de l'image

        Button createDiscussionButton = new Button("Publier une nouvelle discussion", chatIconView); // Ajouter l'image et le texte
        createDiscussionButton.setContentDisplay(ContentDisplay.LEFT); // Positionner l'image à gauche du texte
        createDiscussionButton.getStyleClass().add("discussion-button"); // Appliquer la classe CSS
        createDiscussionButton.setOnMouseEntered(e -> {
            createDiscussionButton.getStyleClass().add("discussion-button-hover");
        });
        createDiscussionButton.setOnMouseExited(e -> {
            createDiscussionButton.getStyleClass().remove("discussion-button-hover");
        });

        // Conteneur pour aligner le bouton à gauche
        HBox buttonBox = new HBox(createDiscussionButton);
        buttonBox.setAlignment(Pos.CENTER_LEFT);
        buttonBox.setPadding(new Insets(10, 0, 0, 0));

        // Conteneur central pour le titre et le sous-titre
        VBox headerBox = new VBox(10, mainTitle, subtitle, buttonBox);
        headerBox.setAlignment(Pos.CENTER);

        // Ajout des thèmes
        mainContentBox.getChildren().addAll(
            headerBox,
            createTheme("Sport", new String[][]{
                {"S’améliorer au basket 🏀", "07/09/24", "27 réponses", "12 participants"},
                {"Football Américain 🏈", "29/07/24", "110 réponses", "45 participants"},
                {"Jeux Olympiques 🏅", "15/08/24", "554 réponses", "230 participants"},
                {"Paris-Barcelone 🏃", "14/02/24", "61 réponses", "30 participants"},
                {"Techniques de natation 🏊", "22/03/24", "43 réponses", "18 participants"}
            }),
            createTheme("Cinéma", new String[][]{
                {"Top des meilleurs films 2024 🎥", "03/12/24", "300 réponses", "150 participants"},
                {"Séries à voir absolument 📺", "01/11/24", "200 réponses", "100 participants"},
                {"Films de super-héros en 2024 🦸", "10/08/24", "87 réponses", "40 participants"},
                {"Les classiques du cinéma 🎞️", "05/02/24", "120 réponses", "50 participants"},
                {"Analyse des Oscars 2024 🏆", "20/01/24", "180 réponses", "70 participants"}
            }),
            createTheme("Sciences", new String[][]{
                {"Dernières découvertes en physique ⚛️", "08/10/24", "100 réponses", "50 participants"},
                {"Avancées en biotechnologie 🧬", "15/09/24", "75 réponses", "30 participants"},
                {"L'intelligence artificielle 🤖", "30/06/24", "200 réponses", "90 participants"},
                {"La conquête spatiale 🚀", "01/04/24", "300 réponses", "130 participants"},
                {"Les énergies renouvelables 🌱", "12/12/24", "150 réponses", "60 participants"}
            }),
            createTheme("Cuisine", new String[][]{
                {"Recettes faciles 🍳", "12/06/24", "42 réponses", "20 participants"},
                {"Cuisine du monde 🌍", "18/07/24", "89 réponses", "40 participants"},
                {"Secrets de la pâtisserie 🍰", "05/03/24", "120 réponses", "50 participants"},
                {"Plats végétariens 🥗", "22/01/24", "60 réponses", "25 participants"},
                {"Techniques de cuisson parfaites 🔥", "09/09/24", "80 réponses", "35 participants"}
            }),
            createTheme("Histoire", new String[][]{
                {"Les grandes batailles ⚔️", "10/05/24", "20 réponses", "10 participants"},
                {"Civilisations antiques 🏺", "15/02/24", "75 réponses", "30 participants"},
                {"La Seconde Guerre mondiale 🌍", "01/09/24", "150 réponses", "70 participants"},
                {"Les empires coloniaux 🗺️", "28/06/24", "45 réponses", "20 participants"},
                {"Personnages historiques célèbres 👑", "12/03/24", "100 réponses", "50 participants"}
            })
        );

        return mainContentBox;
    }

    private VBox createTheme(String themeTitle, String[][] forums) {
        VBox themeBox = new VBox();
        themeBox.setPadding(new Insets(10));
        themeBox.setSpacing(10);

        // Titre du thème
        Label themeLabel = new Label(themeTitle);
        themeLabel.getStyleClass().add("theme-title");
        themeLabel.setMaxWidth(Double.MAX_VALUE);

        // Liste des forums
        VBox forumList = new VBox();
        forumList.setSpacing(5);

        for (String[] forum : forums) {
            forumList.getChildren().add(createForumRow(forum[0], forum[1], forum[2], forum[3]));
        }

        themeBox.getChildren().addAll(themeLabel, forumList);
        return themeBox;
    }

    private HBox createForumRow(String title, String date, String responses, String participants) {
        HBox forumRow = new HBox();
        forumRow.setPadding(new Insets(5));
        forumRow.setSpacing(20);
        forumRow.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: white;");

        // Colonne gauche : Titre + date
        VBox leftColumn = new VBox();
        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        Label dateLabel = new Label(date);
        dateLabel.setStyle("-fx-font-size: 15px; -fx-text-fill: gray;");
        leftColumn.getChildren().addAll(titleLabel, dateLabel);

        // Colonne droite : Réponses + Participants
        VBox rightColumn = new VBox();
        Label responsesLabel = new Label(responses);
        responsesLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        Label participantsLabel = new Label(participants);
        participantsLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: gray;");
        rightColumn.setAlignment(Pos.CENTER_RIGHT);
        rightColumn.getChildren().addAll(responsesLabel, participantsLabel);

        // Ajouter les colonnes à la ligne
        forumRow.getChildren().addAll(leftColumn, rightColumn);
        HBox.setHgrow(leftColumn, Priority.ALWAYS);
        return forumRow;
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

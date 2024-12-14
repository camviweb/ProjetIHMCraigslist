package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private StackPane rootPane;

    @Override
    public void start(Stage primaryStage) {
        // Création des vues
        final HomeView homeView = new HomeView();
        final ForumView forumView = new ForumView();
        final ArticlesView articlesView = new ArticlesView();
        final ProduitView produitView = new ProduitView(); 

        // Conteneur principal (StackPane pour changer les vues)
        rootPane = new StackPane();
        rootPane.getChildren().add(homeView.getMainLayout()); // Charger HomeView par défaut

        // Gestion de la navigation vers les pages depuis HomeView
        for (int i = 0; i < homeView.getNavHBox().getChildren().size(); i++) {
            if (homeView.getNavHBox().getChildren().get(i) instanceof Button) {
                Button navButton = (Button) homeView.getNavHBox().getChildren().get(i);
                if (navButton.getText().equalsIgnoreCase("Forums")) {
                    navButton.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
                        @Override
                        public void handle(javafx.event.ActionEvent event) {
                            rootPane.getChildren().clear();
                            rootPane.getChildren().add(createForumScrollPane(forumView));
                        }
                    });
                }
                if (navButton.getText().equalsIgnoreCase("À Vendre")) {
                    navButton.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
                    	
                        @Override
                        public void handle(javafx.event.ActionEvent event) {
                            rootPane.getChildren().clear();
                            rootPane.getChildren().add(createArticlesScrollPane(articlesView));
                        }
                    });
                    if (articlesView.getButton() != null && articlesView.getButton() instanceof Button ) {
                    	Button produitButton = (Button) articlesView.getButton();
                        if (produitButton.getText().equalsIgnoreCase("Pendentif Coeur \n5€")) {
                        	produitButton.setOnAction(event -> {
                        		rootPane.getChildren().clear();
                                rootPane.getChildren().add(createProduitScrollPane(produitView));
                        	});
                        }
                    }
                }
            }
        }

        // Gestion de la redirection
        addCraigsListNavigation(homeView, forumView, articlesView, produitView);

        // Création de la scène principale
        Scene scene = new Scene(rootPane, 1000, 700);
        scene.getStylesheets().add(getClass().getResource("/application/resources/styles.css").toExternalForm());

        primaryStage.setTitle("CraigsList Interface");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ScrollPane createForumScrollPane(ForumView forumView) {
        VBox forumLayout = new VBox(
            forumView.getTopHBox(),
            forumView.getNavHBox(),
            forumView.getMainContent(),
            forumView.getFooter()
        );

        ScrollPane scrollPane = new ScrollPane(forumLayout);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        return scrollPane;
    }

    private ScrollPane createArticlesScrollPane(ArticlesView articlesView) {
        VBox forumLayout = new VBox(
        	articlesView.getTopHBox(),
            articlesView.getNavHBox(),
            articlesView.getMainContent(),
            articlesView.getFooter()
        );

        ScrollPane scrollPane = new ScrollPane(forumLayout);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        return scrollPane;
    }
    
    private ScrollPane createProduitScrollPane(ProduitView produitView) {
        VBox forumLayout = new VBox(
        	produitView.getTopHBox(),
            produitView.getNavHBox(),
            produitView.getMainContent(),
            produitView.getFooter()
        );

        ScrollPane scrollPane = new ScrollPane(forumLayout);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        return scrollPane;
    }

    private void addCraigsListNavigation(HomeView homeView, ForumView forumView, ArticlesView articlesView, ProduitView produitView) {
        // Redirection depuis HomeView
        for (int i = 0; i < homeView.getTopHBox().getChildren().size(); i++) {
            if (homeView.getTopHBox().getChildren().get(i) instanceof Label) {
                Label titleLabel = (Label) homeView.getTopHBox().getChildren().get(i);
                if (titleLabel.getText().equalsIgnoreCase("CraigsList")) {
                    titleLabel.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>() {
                        @Override
                        public void handle(javafx.scene.input.MouseEvent event) {
                            rootPane.getChildren().clear();
                            rootPane.getChildren().add(homeView.getMainLayout());
                        }
                    });
                }
            }
        }

        // Redirection depuis ForumView
        for (int i = 0; i < forumView.getTopHBox().getChildren().size(); i++) {
            if (forumView.getTopHBox().getChildren().get(i) instanceof Label) {
                Label titleLabel = (Label) forumView.getTopHBox().getChildren().get(i);
                if (titleLabel.getText().equalsIgnoreCase("CraigsList")) {
                    titleLabel.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>() {
                        @Override
                        public void handle(javafx.scene.input.MouseEvent event) {
                            rootPane.getChildren().clear();
                            rootPane.getChildren().add(homeView.getMainLayout());
                        }
                    });
                }
            }
        }
        for (int i = 0; i < forumView.getNavHBox().getChildren().size(); i++) {
            if (forumView.getNavHBox().getChildren().get(i) instanceof Button) {
                Button navButton = (Button) forumView.getNavHBox().getChildren().get(i);
                if (navButton.getText().equalsIgnoreCase("À Vendre")) {
                    navButton.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
                    	
                        @Override
                        public void handle(javafx.event.ActionEvent event) {
                            rootPane.getChildren().clear();
                            rootPane.getChildren().add(createArticlesScrollPane(articlesView));
                        }
                    });
                }
            }
        }
        
        // Redirection depuis ArticlesView
        for (int i = 0; i < articlesView.getTopHBox().getChildren().size(); i++) {
            if (articlesView.getTopHBox().getChildren().get(i) instanceof Label) {
                Label titleLabel = (Label) articlesView.getTopHBox().getChildren().get(i);
                if (titleLabel.getText().equalsIgnoreCase("CraigsList")) {
                    titleLabel.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>() {
                        @Override
                        public void handle(javafx.scene.input.MouseEvent event) {
                            rootPane.getChildren().clear();
                            rootPane.getChildren().add(homeView.getMainLayout());
                        }
                    });
                }
            }
        }
        for (int i = 0; i < articlesView.getNavHBox().getChildren().size(); i++) {
            if (articlesView.getNavHBox().getChildren().get(i) instanceof Button) {
                Button navButton = (Button) articlesView.getNavHBox().getChildren().get(i);
                if (navButton.getText().equalsIgnoreCase("Forums")) {
                    navButton.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
                        @Override
                        public void handle(javafx.event.ActionEvent event) {
                            rootPane.getChildren().clear();
                            rootPane.getChildren().add(createForumScrollPane(forumView));
                        }
                    });
                }
            }
        }
       
        // Redirection depuis ProduitView
        for (int i = 0; i < produitView.getTopHBox().getChildren().size(); i++) {
            if (produitView.getTopHBox().getChildren().get(i) instanceof Label) {
                Label titleLabel = (Label) produitView.getTopHBox().getChildren().get(i);
                if (titleLabel.getText().equalsIgnoreCase("CraigsList")) {
                    titleLabel.setOnMouseClicked(new javafx.event.EventHandler<javafx.scene.input.MouseEvent>() {
                        @Override
                        public void handle(javafx.scene.input.MouseEvent event) {
                            rootPane.getChildren().clear();
                            rootPane.getChildren().add(homeView.getMainLayout());
                        }
                    });
                }
            }
        }
        for (int i = 0; i < produitView.getNavHBox().getChildren().size(); i++) {
            if (produitView.getNavHBox().getChildren().get(i) instanceof Button) {
                Button navButton = (Button) produitView.getNavHBox().getChildren().get(i);
                if (navButton.getText().equalsIgnoreCase("Forums")) {
                    navButton.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
                        @Override
                        public void handle(javafx.event.ActionEvent event) {
                            rootPane.getChildren().clear();
                            rootPane.getChildren().add(createForumScrollPane(forumView));
                        }
                    });
                }
                if (navButton.getText().equalsIgnoreCase("À Vendre")) {
                    navButton.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
                    	
                        @Override
                        public void handle(javafx.event.ActionEvent event) {
                            rootPane.getChildren().clear();
                            rootPane.getChildren().add(createArticlesScrollPane(articlesView));
                        }
                    });
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

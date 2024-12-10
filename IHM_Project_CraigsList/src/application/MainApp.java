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

        // Conteneur principal (StackPane pour changer les vues)
        rootPane = new StackPane();
        rootPane.getChildren().add(homeView.getMainLayout()); // Charger HomeView par défaut

        // Gestion de la navigation vers ForumView depuis HomeView
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
            }
        }

        // Gestion de la redirection vers HomeView depuis ForumView
        addCraigsListNavigation(homeView, forumView);

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

    private void addCraigsListNavigation(HomeView homeView, ForumView forumView) {
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
    }

    public static void main(String[] args) {
        launch(args);
    }
}

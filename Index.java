package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Index extends Application {
	@Override
	
	public void start(Stage primaryStage) {
		// Créer un conteneur VBox
		VBox root1 = new VBox(5);
		root1.getStyleClass().add("background");
		// Créer des conteneurs HBox
		HBox root2 = new HBox(5);
		HBox barNavigation = new HBox(150);
		barNavigation.getStyleClass().add("backgroundbarre");
		// Créer un label
		Label label = new Label("CraigsList");
		// Créer un bouton poster une annonce
		Button add = new Button("Déposez votre annonce en un clic !");
		add.getStyleClass().add("addbutton");
		// Créer une image 
		Image im1 = new Image(getClass().getResourceAsStream("/Images/logo_trans.png"));
		ImageView imView = new ImageView(im1);
		// Propriétés de l'image
		imView.setFitWidth(50);
        	imView.setFitHeight(50);
		// Propriétés du label
		label.getStyleClass().add("labeltitre");
		label.setGraphic(imView);
		label.setGraphicTextGap(5);
		label.setContentDisplay(ContentDisplay.LEFT);
		// Ajouter les éléments au conteneur HBox
		root2.getChildren().addAll(imView, label);
		// Créer des labels pour la barre de navigation 
		Label service = new Label("Services");
		Label emploi = new Label("Emplois");
		Label forum = new Label("Forums");
		Label vendre = new Label("A vendre");
		Label immo = new Label("Immobilier");
		Label cv = new Label("CV");
		service.getStyleClass().add("labelbarre");
		emploi.getStyleClass().add("labelbarre");
		forum.getStyleClass().add("labelbarre");
		vendre.getStyleClass().add("labelbarre");
		immo.getStyleClass().add("labelbarre");
		cv.getStyleClass().add("labelbarre");
		// Ajouter les labels à la barre de navigation 
		barNavigation.getChildren().addAll(service, emploi, forum, vendre, immo, cv);
		// Ajouter les éléments au conteneur VBox
		root1.getChildren().addAll(root2, barNavigation, add);
		// Créer la scène
		Scene scene = new Scene(root1, 1500, 700);
		// Configurer la scène principale
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		primaryStage.setTitle("Craigslist");
		// Mettre la scène dans le stage
		primaryStage.setScene(scene);
		// Afficher la fenêtre
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

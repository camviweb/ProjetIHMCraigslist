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
	public void start(Stage primaryStage) {
		// Créer un conteneur VBox
		VBox root1 = new VBox(5);
		// Créer un conteneur HBox
		HBox root2 = new HBox(5);
		// Créer un label
		Label label = new Label("CraigsList");
		// Créer un bouton poster une annonce
		Button add = new Button("Déposez votre annonce en un clic !");
		// Créer une image 
		Image im1 = new Image(getClass().getResourceAsStream("/Images/logo.png"));
		ImageView imView = new ImageView(im1);
		// Propriétés du label
		label.setGraphic(imView);
		label.setGraphicTextGap(50);
		label.setContentDisplay(ContentDisplay.LEFT);
		// Ajouter les éléments au conteneur HBox
		root2.getChildren().addAll(imView, label);
		// Ajouter les éléments au conteneur VBox
		root1.getChildren().addAll(root2, add);
		// Créer la scène
		Scene scene = new Scene(root1, 1500, 700);
		// Configurer la scène principale
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
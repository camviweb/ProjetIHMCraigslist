package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Index extends Application {
	@Override
	
	public void start(Stage primaryStage) {
		// Créer le conteneur VBox principal
		VBox root1 = new VBox(5);
		root1.getStyleClass().add("background");

		// Créer le conteneur VBox de droite pour le HBox central 
		VBox root3 = new VBox(30);
		
		// Créer le conteneur VBox de gauche pour le HBox central 
		VBox root4 = new VBox();
		
		// Créer le conteneur HBox du haut 
		HBox root2 = new HBox();
		root2.setPadding(new Insets(15, 10, 0, 10));

		// Créer le contenur HBox barre de navigation 
		HBox barNavigation = new HBox(120);
		barNavigation.getStyleClass().add("backgroundbarre");

		// Créer le conteneur HBox central
		HBox centre = new HBox(100);
		centre.setPadding(new Insets(30, 30, 30, 30));
		
		// Créer le conteneur HBox footer 
		HBox footer = new HBox(230);
		footer.setPadding(new Insets(15, 0, 15, 0));
		footer.getStyleClass().add("backgroundfooter");
		
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

		// Créer un TextField pour la barre de recherche 
		TextField searchField = new TextField();
		searchField.setPromptText("Recherche");
		searchField.getStyleClass().add("searchfield");
		
		// Créer un bouton pour lancer la recherche (à implémenter)
		Button searchButton = new Button();

		// Créer des régions flexibles pour la mise en page du premier HBox 
		Region leftSpacer1 = new Region();
		Region rightSpacer1 = new Region();
		
		// Ajouter les éléments au conteneur HBox
		HBox.setHgrow(leftSpacer1, Priority.ALWAYS);
		HBox.setHgrow(rightSpacer1, Priority.ALWAYS);
		root2.getChildren().addAll(imView, label, leftSpacer1, searchField, rightSpacer1);
		
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

		// Créer des régions flexibles pour la mise en page de la barre de navigation
		Region leftSpacer2 = new Region();
		Region rightSpacer2 = new Region();
		
		// Ajouter les labels à la barre de navigation 
		HBox.setHgrow(leftSpacer2, Priority.ALWAYS);
		HBox.setHgrow(rightSpacer2, Priority.ALWAYS);
		barNavigation.getChildren().addAll(leftSpacer2, service, emploi, forum, vendre, immo, cv, rightSpacer2);

		// Créer des labels pour le footer
		Label aide = new Label("Aide");
		Label faq = new Label("FAQ");
		Label ml = new Label("Mentions légales");
		Label poli = new Label("Politique de confidentialité");
		aide.getStyleClass().add("labelfooter");
		faq.getStyleClass().add("labelfooter");
		ml.getStyleClass().add("labelfooter");
		poli.getStyleClass().add("labelfooter");
				
		// Créer des régions flexibles pour le footer
		Region leftSpacer3 = new Region();
		Region rightSpacer3 = new Region();
			
		// Ajouter les labels au footer 
		HBox.setHgrow(leftSpacer3, Priority.ALWAYS);
		HBox.setHgrow(rightSpacer3, Priority.ALWAYS);
		footer.getChildren().addAll(leftSpacer3, aide, faq, ml, poli, rightSpacer3);
		
		// Créer un label pour le titre du site 
		Label titre = new Label("Le site de petites annonces et de forums de discussion");
		titre.getStyleClass().add("labeltitre");
		titre.setWrapText(true);
		titre.setMaxWidth(400); // Définir une largeur fixe pour le Label
				
		// Ajouter les éléments au conteneur VBox de droite 
		root3.getChildren().addAll(titre, add);
		
		// Créer une image 
		Image im2 = new Image(getClass().getResourceAsStream("/Images/dressing.png"));
		ImageView imView2 = new ImageView(im2);
				
		// Propriétés de l'image
		imView2.setFitWidth(700);
		imView2.setPreserveRatio(true);

		// Ajouter les éléments au conteneur VBox de gauche 
		root4.getChildren().add(imView2);
		
		// Ajouter les éléments au conteneur HBox central 
		centre.getChildren().addAll(root4, root3);
		
		// Ajouter les éléments au conteneur VBox
		root1.getChildren().addAll(root2, barNavigation, centre, footer);
		
		// Créer la scène
		Scene scene = new Scene(root1, 1500, 700);
		
		// Configurer la scène principale
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		primaryStage.setTitle("Craigslist");
		
		// Mettre la scène dans le stage
		primaryStage.setScene(scene);

		// Modifier le focus pour bien afficher le TextField
		label.requestFocus();
		
		// Afficher la fenêtre
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

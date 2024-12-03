package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller implements EventHandler<ActionEvent> {
	private View view;
	private Model model;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void handle(ActionEvent event) {
		
	}
}

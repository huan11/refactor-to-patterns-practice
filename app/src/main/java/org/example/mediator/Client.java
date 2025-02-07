package org.example.mediator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client extends Application {

	@Override
	public void start(Stage primaryStage) {
		UIMediator mediator = new UIMediator();
		
		VBox root = new VBox(10);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(10));
		
		TextBox textBox = new TextBox(mediator);
		CustomLabel label = new CustomLabel(mediator);
		Slider slider = new Slider(mediator);
		
		root.getChildren().addAll(textBox, label, slider);
		
		Scene scene = new Scene(root, 300, 200);
		primaryStage.setTitle("Mediator Pattern Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

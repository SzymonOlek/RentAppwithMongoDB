package client;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class newStage {
	
	static Stage nextStage;
	
	static FXMLLoader loader;

	static StackPane stackPane;

	static Scene scene;

	static void setEverything(Scene scene,Stage nextStage) {
		
		newStage.nextStage = nextStage;
		newStage.scene=scene;
		
	}
	
	static void show() {
		
		
		
		nextStage.setScene(scene);


		nextStage.show();
		
	}
	
	
	
	
	

}
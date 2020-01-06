package client;
import org.bson.Document;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import client.newStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {

//		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		try {

			// Creating Credentials
			MongoCredential credential;
			credential = MongoCredential.createCredential("Simon", "mydb", "1234".toCharArray());
			System.out.println("Connected to the database successfully");

			MongoClient mongoClient = new MongoClient();

			

			MongoDatabase database = mongoClient.getDatabase("mydb");
			System.out.println("connected!!!");



			System.out.println("Credentials ::"+ credential);  



			MongoCollection<Document> collection = database.getCollection("Uzytkownik"); 
			FindIterable<Document> iterDoc = collection.find(); 

			System.out.println("Collection myCollection selected successfully"); 

			for(Document x : iterDoc) {
	
				System.out.println(x.getString("nazwa"));
	
				mongoClient.close();
	
}
//System.out.println(collection.find());

		} catch (Exception e) {

		}
		
//		MyDatabase db = new MyDatabase();
//		
//		db.insertUser("Adam Kowalski", "mail123@tmail.com");
//				
		launch(args);
		

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/LogIn.fxml"));
		
		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);
		
		primaryStage.setTitle("APLIKACJA");
		
		newStage.setEverything(scene, primaryStage);
		
		newStage.show();
		
	}

}

package client;

import java.io.IOException;
import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class ClientController {
	
	String yourID;

	//////////////////////////////////////////////////////// rent

	@FXML
	private TextField getID;

	@FXML
	private TextField dzienOd;

	@FXML
	private TextField rokOd;

	@FXML
	private TextField dzienDo;

	@FXML
	private TextField miesDo;

	@FXML
	private TextField rokDo;

	@FXML
	private Button accept;

	@FXML
	private Button backRent;

	@FXML
	private TextField miesOd;

	@FXML
	private MenuButton store;
	
	boolean added = false;
	

	@FXML
	void OnActionAccept(ActionEvent event) {
		
		

	}

	@FXML
	void OnActionBackRent(ActionEvent event) throws IOException {

		System.out.println("KLIENT");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/mainPage.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("KLIENT");

		newStage.scene = scene;
		newStage.show();

	}

	@FXML
	void mouseBackground(MouseEvent event) {

if (added == false) {
    		
    		MyDatabase db = new MyDatabase();
    		db.setStores();

    		ArrayList<Store> stores = ID.sklepy;
    		for(Store s : stores)
			 {

				MenuItem temp1 = new MenuItem(s.getName());

				temp1.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						store.setText(((MenuItem) e.getSource()).getText());
					}

				});

				store.getItems().add(temp1);

			}
			added = true;
		}

	}

	////////////////////////////////////////////////////////////////// log in

	@FXML
	private Button MakeAccount;

	@FXML
	private Button LogIn;

	@FXML
	private PasswordField password;

	@FXML
	private TextField login;
	
	
	
	private boolean correctLogged() {
		
		MyDatabase db = new MyDatabase();
		
		String s =db.checkUser(login.getText(), password.getText());
		
		if(s != "error") {
			
			ID.id=s;			
			
			return true;
		}
			
		login.clear();
		password.clear();
		
		login.setPromptText("bledne dane");
		password.setPromptText("bledne dane");
		return false;
	}

	@FXML
	void OnActionLogIn(ActionEvent event) throws IOException {
		
		
		
		if(correctLogged()) {
		
		
		
		System.out.println("KLIENT");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/mainPage.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("KLIENT");

		newStage.scene = scene;
		newStage.show();
		
		
		}
		
		
		
		
	}

	@FXML
	void OnActionMakeAccount(ActionEvent event) throws IOException {

		System.out.println("KLIENT");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/MakeAccount.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("KLIENT");

		newStage.scene = scene;
		newStage.show();

	}

	///////////////////////////////////////////////////////////////////// main page
	
    @FXML
    private Button logOut;

    @FXML
    private Label YourID;
    
	@FXML
	private StackPane backgroundMainPage;

	@FXML
	private Button clientRent;

	@FXML
	private Button Change;

	@FXML
	private Button returnItem;

	@FXML
	private Button Pay;
	
    @FXML
    void OnActionLogOut(ActionEvent event) throws IOException {

		System.out.println("KLIENT");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/LogIn.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("KLIENT");

		newStage.scene = scene;
		newStage.show();
    	
    }

	@FXML
	void OnActionChange(ActionEvent event) throws IOException {

		System.out.println("KLIENT");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/changeClient.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("KLIENT");

		newStage.scene = scene;
		newStage.show();

	}
	
    @FXML
    void SetUserID(MouseEvent event) {
    	
    	YourID.setText("Twoje ID to: " + ID.id+"  Twoja nazwa : " +ID.nazwa+  " email: "+ID.email + "  saldo: " +ID.saldo);
    	

    }

	@FXML
	void OnActionClientRent(ActionEvent event) throws IOException {
		System.out.println("KLIENT");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/Rent.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("KLIENT");

		newStage.scene = scene;
		newStage.show();
	}

	@FXML
	void OnActionPay(ActionEvent event) throws IOException {
		System.out.println("KLIENT");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/Pay.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("KLIENT");

		newStage.scene = scene;
		newStage.show();

	}

	@FXML
	void OnActionReturnItem(ActionEvent event) {
		
		
		
		

	}

	/////////////////////////////////////////////////////////////////////// change
	/////////////////////////////////////////////////////////////////////// NAME /
	/////////////////////////////////////////////////////////////////////// Email

	@FXML
	void OnActionBackChange(ActionEvent event) throws IOException {
		System.out.println("KLIENT");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/mainPage.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("KLIENT");

		newStage.scene = scene;
		newStage.show();
	}

	@FXML
	private TextField newEmail;

	@FXML
	private TextField newName;

	@FXML
	private Button backChange;

	@FXML
	void OnActionNewEmail(ActionEvent event) {

		if(!newEmail.getText().trim().isEmpty()) {
			MyDatabase db = new MyDatabase();
			
			db.setNewEmail(newEmail.getText().trim());
			ID.email=newEmail.getText().trim();
		}
		
	}

	@FXML
	void OnActionNewName(ActionEvent event) {

		if(!newName.getText().trim().isEmpty()) {
			MyDatabase db = new MyDatabase();
			
			db.setNewName(newName.getText().trim());
			ID.nazwa=newName.getText().trim();
		}
		
	}

	/////////////////////////////////////////////////////////////////// pay for item

	@FXML
	private Button payItem;

	@FXML
	private Button backPay;

	@FXML
	private TextField idPayItem;

	@FXML
	void OnActionPayBack(ActionEvent event) throws IOException {

		System.out.println("KLIENT");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/mainPage.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("KLIENT");

		newStage.scene = scene;
		newStage.show();

	}

	@FXML
	void OnActionPayItem(ActionEvent event) {
		
		if (!idPayItem.getText().trim().isEmpty()) {
			
			try {
			int money = Integer.parseInt(idPayItem.getText().trim());
			MyDatabase db = new MyDatabase();
			db.pay(money);
			ID.saldo-=money;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	///////////////////////////////////////////////////////////////// make account

	@FXML
	private Button backMakeAccount;

	@FXML
	private Button makeNewAccount;

	@FXML
	private TextField emailMakeAccount1;

	@FXML
	private TextField nameMakeAccount;

	@FXML
	private PasswordField passwordFirst;

	@FXML
	private PasswordField passwordAgain;

	@FXML
	void OnActionBackMakeAccount(ActionEvent event) throws IOException {

		System.out.println("KLIENT");
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/LogIn.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("KLIENT");

		newStage.scene = scene;
		newStage.show();

	}

	private boolean checkIfCorrect() {

		if (nameMakeAccount.getText().trim().isEmpty()) {
			nameMakeAccount.setPromptText("WYPELNIJ");

			return false;

		}
		if (emailMakeAccount1.getText().trim().isEmpty()) {

			emailMakeAccount1.setPromptText("WYPELNIJ");

			return false;
		}

		if (passwordFirst.getText().trim().isEmpty()) {

			passwordFirst.setPromptText("WYPELNIJ");
			return false;
		}
		if (passwordAgain.getText().trim().isEmpty()) {

			passwordAgain.setPromptText("WYPELNIJ");
			return false;
		}

		if (!passwordAgain.getText().equals(passwordFirst.getText())) {
			passwordAgain.clear();
			passwordAgain.setPromptText("HASLO MUSZA PASOWAC");
			return false;

		}
		return true;

	}

	@FXML
    void OnActionMakeNewAccount(ActionEvent event) {
    	
    	if(checkIfCorrect()) {
    		
    		MyDatabase db = new MyDatabase();

    		db.insertUser(nameMakeAccount.getText(), emailMakeAccount1.getText(), passwordAgain.getText());

    		
    	}


    }
	
	

}

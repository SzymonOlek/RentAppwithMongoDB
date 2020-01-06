package employ;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class employeeController {
	
	
	private void loadScene(String s) throws IOException {
		
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/"+s+".fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("EMPLOYEE");

		newStage.scene = scene;
		newStage.show();
		
		
	}

	//////////////////////////////////////////////////////////main page
	
    @FXML
    private Label data;
	
	@FXML
    private StackPane Background;

    @FXML
    private Button Product;

    @FXML
    private Button Rent;

    @FXML
    private Button Store;

    @FXML
    private Button Employ;

    @FXML
    private Button logOut;
    
    @FXML
    private Button returnItememploy;
    

    @FXML
    private Button zapytania;

    @FXML
    void OnAciotnZapytania(ActionEvent event) {

    	try {
			loadScene("Zapytania");
		} catch (IOException e) {

			e.printStackTrace();
		}
    	
    }

    @FXML
    void OnAciotnReturnItemEmploy(ActionEvent event) {
    	try {
			loadScene("ReturnItem");
		} catch (IOException e) {
	
			e.printStackTrace();
		}
    }
    

    
    @FXML
    void OnActionLogOut(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/LogIn.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("EMPLOYEE");

		newStage.scene = scene;
		newStage.show();
    }
    
    @FXML
    void ReadData(MouseEvent event) {
    	
    	data.setText("Twoje ID pracownika to: "+ID.id + " , nazwa: "+ID.nazwa + " sklep: "+ ID.store);
    	
    }

    @FXML
    void OnActionEmploy(ActionEvent event) throws IOException {

    	loadScene("AddEmployee");
    	
//		FXMLLoader loader = new FXMLLoader();
//
//		loader.setLocation(this.getClass().getResource("/fxml/AddEmployee.fxml"));
//
//		StackPane stackPane = (StackPane) loader.load();
//
//		Scene scene = new Scene(stackPane);
//
//		newStage.nextStage.setTitle("EMPLOYEE");
//
//		newStage.scene = scene;
//		newStage.show();

    }

    @FXML
    void OnActionProduct(ActionEvent event) throws IOException {

    	loadScene("AddProduct");
    	
//		FXMLLoader loader = new FXMLLoader();
//
//		loader.setLocation(this.getClass().getResource("/fxml/AddProduct.fxml"));
//
//		StackPane stackPane = (StackPane) loader.load();
//
//		Scene scene = new Scene(stackPane);
//
//		newStage.nextStage.setTitle("EMPLOYEE");
//
//		newStage.scene = scene;
//		newStage.show();

    }

    @FXML
    void OnActionRent(ActionEvent event) throws IOException {
    	

		
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/Rent.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("EMPLOYEE");

		newStage.scene = scene;
		
		newStage.show();

    }

    @FXML
    void OnActionStore(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/AddStore.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("EMPLOYEE");

		newStage.scene = scene;
		newStage.show();

    }
	
	///////////////////////////////////////////////////////////////////////////// add product
    
    @FXML
    private TextField nazwa;

    @FXML
    private TextField cost;

    @FXML
    private TextField waga;

    @FXML
    private Button addProduct;

    @FXML
    private Button back;
    
    private boolean checkIfProductOK() {
    	
    	if(nazwa.getText().trim().isEmpty())return false;
    	if(cost.getText().trim().isEmpty())return false;
    	if(waga.getText().trim().isEmpty())return false;
    	

    	
    	
    	return true;
    }

    @FXML
    void OnActionAddProduct(ActionEvent event) {
    	
    	if(checkIfProductOK()) {
    		
        	try {
        		
        		int a = Integer.parseInt(cost.getText());
        		int b = Integer.parseInt(waga.getText());
        		
        		MyDatabase db = new MyDatabase();
        		
        		db.insertItem(nazwa.getText(), b, a);
        		
        	 	loadScene("mainPage");
        		
        		
        		
        	}catch(Exception e) {
        		cost.clear();
        	}
    		
    	}

    }

    @FXML
    void OnActionBack(ActionEvent event) throws IOException {
    	

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/mainPage.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("EMPLOYEE");

		newStage.scene = scene;
		newStage.show();

    }
    
    
    
    //////////////////////////////////////////////////////////////////////////////////// rent
    @FXML
    private TextField productID;

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

    @FXML
    private TextField klientID;
    
    boolean added=false;
    
    private boolean checkIfRentOk() {
    	
    	if(store.getText().equals("Sklep")) return false;
    	if(productID.getText().trim().isEmpty())return false;
    	if(dzienOd.getText().trim().isEmpty())return false;
    	if(rokOd.getText().trim().isEmpty())return false;
    	if(dzienDo.getText().trim().isEmpty())return false;
    	if(rokDo.getText().trim().isEmpty())return false;
    	if(miesDo.getText().trim().isEmpty())return false;
    	if(miesOd.getText().trim().isEmpty())return false;
    	if(klientID.getText().trim().isEmpty())return false;

    	
    	return true;
    }

    @FXML
    void OnActionAccept(ActionEvent event) {
    	
    	if(checkIfRentOk()) {
    		
    		try {
    			
    			int id =Integer.parseInt(productID.getText());
    			int dzienStart =Integer.parseInt(dzienOd.getText());
    			int rokStart =Integer.parseInt(rokOd.getText());
    			int dzienEnd = Integer.parseInt(dzienDo.getText());
    	    	int miesEnd =Integer.parseInt(miesDo.getText());
    	    	int rokEnd=Integer.parseInt(rokDo.getText());
    	    	int miesStart =Integer.parseInt(miesOd.getText());
    	    	int klientIndex =Integer.parseInt(klientID.getText());
    			
    			MyDatabase db = new MyDatabase();
    			
    			db.insertRent(store.getText(), klientIndex, id, dzienStart, miesStart, rokStart, dzienEnd, miesEnd, rokEnd);
    			
    		 	loadScene("mainPage");
    			
    			
    			
    		}catch(Exception e) {
    			
    			
    		}
    		
    		
    		
    	}

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

    @FXML
    void OnActionBackRent(ActionEvent event) throws IOException {

    	
    	loadScene("mainPage");
		
    	
//		FXMLLoader loader = new FXMLLoader();
//
//		loader.setLocation(this.getClass().getResource("/fxml/mainPage.fxml"));
//
//		StackPane stackPane = (StackPane) loader.load();
//
//		Scene scene = new Scene(stackPane);
//
//		newStage.nextStage.setTitle("EMPLOYEE");
//
//		newStage.scene = scene;
//		newStage.show();
//    	
    	
    }
    
    //////////////////////////////////////////////////////////////// log in

    @FXML
    private Button LogIn;

    @FXML
    private PasswordField password;

    @FXML
    private TextField login;
    
    private boolean correctLogged() {
		
		MyDatabase db = new MyDatabase();

		Long s =db.checkEmployee(login.getText(), password.getText());
		
		if(s != -1) {
			
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

    		FXMLLoader loader = new FXMLLoader();

    		loader.setLocation(this.getClass().getResource("/fxml/mainPage.fxml"));

    		StackPane stackPane = (StackPane) loader.load();

    		Scene scene = new Scene(stackPane);

    		newStage.nextStage.setTitle("EMPLOYEE");

    		newStage.scene = scene;
    		newStage.show();
    		
    		
    		}

    }
    
    
    /////////////////////////////////////////////////////////////////////// return Item

    @FXML
    private Button backReturnItem;

    @FXML
    private Button returnItem;

    @FXML
    private TextField idReturnItem;

    @FXML
    private TextField dataOddaniaMies;

    @FXML
    private TextField dataOddaniaDzien;

    @FXML
    private TextField dataOddaniaRok;

    @FXML
    void OnActionBackReturnItem(ActionEvent event) {
    	
    	try {
			loadScene("mainPage");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

    }
    
    private boolean checkIfReturnCorrect() {
    	
    	if(idReturnItem.getText().trim().isEmpty())return false;
    	if(dataOddaniaMies.getText().trim().isEmpty())return false;
    	if(dataOddaniaDzien.getText().trim().isEmpty())return false;
    	if(dataOddaniaRok.getText().trim().isEmpty())return false;

    	return true;
    }

    @FXML
    void OnaActionReturnItem(ActionEvent event) {
    	if(checkIfReturnCorrect()) {
    		
    		try {
    			
    			int dzien,mies,rok,id;
    			
    			id=Integer.parseInt(idReturnItem.getText());
    			dzien=Integer.parseInt(dataOddaniaDzien.getText());
    			mies=Integer.parseInt(dataOddaniaMies.getText());
    			rok=Integer.parseInt(dataOddaniaRok.getText());
    			
    			MyDatabase db = new MyDatabase();
    			
    			Rent rent = db.findRent(id);
    			if(rent != null) {
    		
    			int daysStart = 365*rent.getRokOd()+31*rent.getMiesOd()+rent.getDzienOD();
    			int daysEnd = 365*rok+31*mies+dzien;
    			
    			if(daysStart < daysEnd) {
    			
    				int countDays=daysEnd-daysStart;
    				
    				Item item = db.findItem(rent.getIdItem());
    				
    				if(item!= null) {
    					
    					int money = countDays*item.cena;
    					
    					db.setSaldo(rent.getKlientID(), money);
    					
    					loadScene("mainPage");
    					
    				}
    				
    			}
    			
    			}
    		}catch(Exception e ) {
    			
    			
    			
    		}

    		
    	}
    	

    }
    ////////////////////////////////////////////////////////////////////////// add employ 
    @FXML
    private Button addEmploy;

    @FXML
    private Button backAddEmpoloy;

    @FXML
    private TextField emailEmploy;

    @FXML
    private TextField nameEmploy;

    @FXML
    private TextField passwordEmploy;
    
    @FXML
    private MenuButton storeEmploy;
    
    @FXML
    void readStoresEmploy(MouseEvent event) {

    	
    	
    	if (added == false) {
    		
    		MyDatabase db = new MyDatabase();
    		db.setStores();

    		ArrayList<Store> stores = ID.sklepy;
    		for(Store s : stores)
			 {

				MenuItem temp1 = new MenuItem(s.getName());

				temp1.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						storeEmploy.setText(((MenuItem) e.getSource()).getText());
					}

				});

				storeEmploy.getItems().add(temp1);

			}
			added = true;
		}

    }
    
    private boolean checkEmployData() {
    	
    	if(emailEmploy.getText().trim().isEmpty())return false;
    	if(nameEmploy.getText().trim().isEmpty())return false;
    	if(passwordEmploy.getText().trim().isEmpty())return false;
    	if(storeEmploy.getText().trim().equals("Sklep"))return false;
    	return true;
    }

    @FXML
    void OnActionAddEmploy(ActionEvent event) {
    	if(checkEmployData()) {
    		
    		MyDatabase db =  new MyDatabase();
    		
    		db.insertEmploy(nameEmploy.getText(), emailEmploy.getText(), passwordEmploy.getText(),storeEmploy.getText().trim());
    		
    		try {
				loadScene("mainPage");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
    	}
    	
    }

    @FXML
    void OnActionBackAddEmploy(ActionEvent event) throws IOException {
    	
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/mainPage.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("EMPLOYEE");

		newStage.scene = scene;
		newStage.show();
    	

    }
    
    
    ///////////////////////////////////////////////////////////////////////        add store
    
    
    @FXML
    private Button backAddStore;

    @FXML
    private Button AddStore;

    @FXML
    private TextField lokalizacja;

    @FXML
    private TextField size;

    @FXML
    private TextField name;
    
    boolean checkIfStoreDataCorrect() {
    	
    	if(size.getText().trim().isEmpty())return false;
    	if(lokalizacja.getText().trim().isEmpty())return false;
    	if(name.getText().trim().isEmpty())return false;
    	
    	
    	return true;
    }

    @FXML
    void OnActionAddStore(ActionEvent event) {

    	if(checkIfStoreDataCorrect()) {
    		
    		MyDatabase db = new MyDatabase();
    		
    		db.insertStore(name.getText(), lokalizacja.getText(), size.getText());
    		
    		try {
				loadScene("mainPage");
			} catch (IOException e) {
		
				e.printStackTrace();
			}
			
    		
    	}
    	
    }

    @FXML
    void OnActionBackAddStore(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(this.getClass().getResource("/fxml/mainPage.fxml"));

		StackPane stackPane = (StackPane) loader.load();

		Scene scene = new Scene(stackPane);

		newStage.nextStage.setTitle("EMPLOYEE");

		newStage.scene = scene;
		newStage.show();
    	
    	
    }
    
    ///////////////////////////////////////////////////////// zapytania
    
    @FXML
    private TextArea textArea;

    @FXML
    private Button test;

    @FXML
    private Button backZapytania;

    @FXML
    void OnActionbackZapytania(ActionEvent event) {

    	
    	try {
			loadScene("mainPage");
		} catch (IOException e) {

			e.printStackTrace();
		}
    }

    @FXML
    void OnActiontest(ActionEvent event) {
    	textArea.setText("");
    	MyDatabase db = new MyDatabase();
    	
    	db.findPracownik();
    	
    	textArea.setText(ID.temp);
    	
    }


    @FXML
    void ShowRent(ActionEvent event) {
    	textArea.setText("");
    	MyDatabase db = new MyDatabase();
    	
    	db.showRent();
    	textArea.setText(ID.temp);
    	
    }

    @FXML
    void fiveDESCProduct(ActionEvent event) {
    	textArea.setText("");
    	MyDatabase db = new MyDatabase();
    	
    	db.show5ProductDESC();
    	
    	textArea.setText(ID.temp);

    }

    @FXML
    void showCollections(ActionEvent event) {
    	textArea.setText("");
    	MyDatabase db = new MyDatabase();
    	db.showCollections();
    	textArea.setText(ID.temp);
    	
    }

    @FXML
    void showProducts(ActionEvent event) {
    
    	textArea.setText("");
    	MyDatabase db = new MyDatabase();
    	
    	db.showProdukt();
    	textArea.setText(ID.temp);
    	
    }

    @FXML
    void showStore(ActionEvent event) {
    	textArea.setText("");
    	MyDatabase db = new MyDatabase();
    	
    	db.showStores();
    	
    	textArea.setText(ID.temp);
    	
    }

    @FXML
    void showUsers(ActionEvent event) {
    	textArea.setText("");
    	MyDatabase db = new MyDatabase();
    
    	db.showUser();
    	
    	textArea.setText(ID.temp);
    }

    
    
    
    @FXML
    void productRangeIndex(ActionEvent event) {

    	
    	textArea.setText("");
    	MyDatabase db = new MyDatabase();
    
    	db.showProduktRange36();
    	
    	textArea.setText(ID.temp);
    	
    	
    }
    
    @FXML
    void countProducts(ActionEvent event) {

    	textArea.setText("");
    	MyDatabase db = new MyDatabase();
    
    	db.countProduct();
    	
    	textArea.setText(ID.temp);
    	
    	
    	
    }
    
    
    
    
    
    

}
  


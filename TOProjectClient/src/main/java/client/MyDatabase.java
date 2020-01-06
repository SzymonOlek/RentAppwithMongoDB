package client;
import org.bson.Document;


import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;


public class MyDatabase {

	static MongoCredential credential = MongoCredential.createCredential("Simon", "mydb", "1234".toCharArray());

	MongoClient mongoClient = new MongoClient();
	
	MongoDatabase database = mongoClient.getDatabase("mydb");
	
	public MyDatabase() {

	}
	
	public void insertUser(String login , String email, String password) {
		
	      MongoCollection<Document> collection2 = database.getCollection("Uzytkownik"); 
	      
	      System.out.println("Collection selected successfully");

	      Document document = new Document() 
	      .append("Login", login) 
	      .append("email", email) 
	      .append("haslo", password)
	      .append("index" , collection2.count()+1)
	      .append("saldo", 0);
	      
	      collection2.insertOne(document); 
	      System.out.println("Document inserted successfully"); 
		
		
		
	}
	
	public String checkUser(String login , String password) {
		
		MongoCollection<Document> collection = database.getCollection("Uzytkownik"); 
		
		FindIterable<Document> iterDoc = collection.find(); 
		
		for(Document x : iterDoc) {
			
			if(x.getString("Login").equals(login) && x.getString("haslo").equals(password)) {
				

				ID.email=x.getString("email");
				ID.nazwa=x.getString("Login");
				ID.saldo=x.getInteger("saldo");
				
				return Long.toString(x.getLong("index"));

			}
			
		}
		
		
		
		return "error";
	}
	
	void insertRent(String terminDo , String terminOd , String IDrzedmiotu) {
		
	      MongoCollection<Document> collection2 = database.getCollection("Wypozyczenia"); 
	      
	      System.out.println("Collection selected successfully");

	      Document document = new Document() 
	      .append("KlientID",ID.id)
	      .append("Data wypozyczenia", terminOd) 
	      .append("Data planowanego oddania", terminDo) 
	      .append("id przedmiotu", IDrzedmiotu)
	      .append("staz", 0)
	      .append("index" , collection2.count()+1);
	      collection2.insertOne(document); 
	      System.out.println("Document inserted successfully"); 
		
		
		
	}
	
//		collection.updateOne(Filters.eq("index", id), Updates.inc("saldo", saldo));
	
	
	
	void setNewEmail(String mail) {
		
	      MongoCollection<Document> collection2 = database.getCollection("Uzytkownik"); 
	      
	      collection2.updateOne(Filters.eq("index", Integer.parseInt(ID.id)), Updates.set("email", mail));
		
		
	}
	
	void setNewName(String name) {
		
	      MongoCollection<Document> collection2 = database.getCollection("Uzytkownik"); 
	      
	      collection2.updateOne(Filters.eq("index", Integer.parseInt(ID.id)), Updates.set("Login", name));
		
		
	}
	
	void pay(int money) {
		
	      MongoCollection<Document> collection2 = database.getCollection("Uzytkownik"); 
	      
	      collection2.updateOne(Filters.eq("index", Integer.parseInt(ID.id)), Updates.inc("saldo", money*(-1)));
		
		
	}
	
	public void setStores() {
		
		MongoCollection<Document> collection = database.getCollection("Sklep"); 
		
		FindIterable<Document> iterDoc = collection.find(); 
		
		String name,lok,pow;
		
		for(Document x : iterDoc) {
			
			
			name=x.getString("Nazwa");
			lok=x.getString("Lokalizacja");
			pow=x.getString("powierzchnia");
			
			Store sklep = new Store(name,lok,pow);
			
			ID.sklepy.add(sklep);
			
		}
		
		
		
	
	}
	

}

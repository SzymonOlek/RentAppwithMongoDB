package employ;
import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.operation.OrderBy;

public class MyDatabase {

	static MongoCredential credential = MongoCredential.createCredential("Simon", "mydb", "1234".toCharArray());

	MongoClient mongoClient = new MongoClient();
	
	MongoDatabase database = mongoClient.getDatabase("mydb");
	
	public MyDatabase() {



	}
	

	void insertUser(String nazwa , String email, String password) {
		
	      MongoCollection<Document> collection2 = database.getCollection("Uzytkownik"); 
	      
	      System.out.println("Collection selected successfully");

	      Document document = new Document() 
	      .append("nazwa", nazwa) 
	      .append("email", email) 
	      .append("halso", password)
	      .append("index" , collection2.count()+1);
	      collection2.insertOne(document); 
	  	System.out.println("Dodano Klienta");
		
		
		
	}
	
	void insertEmploy(String nazwa , String email, String password,String store) {
		
	      MongoCollection<Document> collection2 = database.getCollection("Pracownik"); 
	      
	      System.out.println("Collection selected successfully");

	      Document document = new Document() 
	      .append("Login", nazwa) 
	      .append("email", email) 
	      .append("haslo", password)
	      .append("staz", 0)
	      .append("sklep", store)
	      .append("index" , collection2.count()+1);
	      collection2.insertOne(document); 
	  	System.out.println("Dodano Pracownika");
		
		
		
	}
	
	void insertRent(String store , int clientID, int IDrzedmiotu, int dzienStart , int miesStart , int rokStart , int dzienEnd , int miesEnd , int rokEnd) {
		
	      MongoCollection<Document> collection2 = database.getCollection("Wypozyczenia"); 
	      
	      System.out.println("Collection selected successfully");
	      
	      Document document = new Document()
	      .append("Sklep", store)
	      .append("KlientID",clientID)
	      .append("DzienOd", dzienStart) 
	      .append("MiesOd", miesStart) 
	      .append("RokOd", rokStart) 
	      .append("DzienDo", dzienEnd) 
	      .append("MiesDo", miesEnd) 
	      .append("RokDo", rokEnd) 
	      .append("idItem", IDrzedmiotu)
	      .append("index" , collection2.count()+1);
	      collection2.insertOne(document); 
	      ID.lastRentID=(int)collection2.count();
	  	System.out.println("Dodano Wypozyczenie");
		
		
		
	}
	
	
	
	void insertItem(String name, int waga , int cost) {
		
		   MongoCollection<Document> collection2 = database.getCollection("Produkt"); 
		
		   Document document = new Document() 
				      .append("nazwa", name) 
				      .append("waga", waga) 
				      .append("koszt", cost)
				      .append("index" , collection2.count()+1);
				      collection2.insertOne(document); 
		
		System.out.println("Dodano Przedmiot");
	}
	
	public Long checkEmployee(String login , String password) {
		
		MongoCollection<Document> collection = database.getCollection("Pracownik"); 
		
		FindIterable<Document> iterDoc = collection.find(); 
		
		for(Document x : iterDoc) {
			
			if(x.getString("Login").equals(login) && x.getString("haslo").equals(password)) {
				
				ID.email=x.getString("email");
				ID.nazwa=x.getString("Login");
				ID.staz=x.getInteger("staz");
				ID.store=x.getString("sklep");
				
				return x.getLong("index");

			}
			
		}
		
		
		
		return (long) -1;
	}
	
	void insertStore(String nazwa , String lokalizacja, String powierzchnia) {
		
	      MongoCollection<Document> collection2 = database.getCollection("Sklep"); 
	      
	      System.out.println("Collection selected successfully");

	      Document document = new Document() 
	      .append("Nazwa", nazwa) 
	      .append("Lokalizacja", lokalizacja) 
	      .append("powierzchnia", powierzchnia)
	      .append("index" , collection2.count()+1);
	      collection2.insertOne(document); 
	      System.out.println("Document inserted successfully"); 
		
		
		
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
	
	public Rent findRent(long id) {
		
		MongoCollection<Document> collection = database.getCollection("Wypozyczenia"); 
		
		FindIterable<Document> iterDoc = collection.find(); 
		
		for(Document x : iterDoc) {
			
			if(x.getLong("index").equals(id)) {
				
				Rent rent = new Rent(x.getString("Sklep"),x.getInteger("KlientID"),x.getInteger("DzienOd"),x.getInteger("MiesOd"),x.getInteger("RokOd"),x.getInteger("DzienDo"),x.getInteger("MiesDo"),x.getInteger("RokDo"),x.getInteger("idItem"));
						
				
				return rent;
				
				
			}			
		}
		
		
		
		
		return null;
		
	}
	
	public Item findItem(long id) {
		
		MongoCollection<Document> collection = database.getCollection("Produkt"); 
		
		FindIterable<Document> iterDoc = collection.find(); 
		
		for(Document x : iterDoc) {
			
			if(x.getLong("index").equals(id)) {
				
				Item item = new Item(x.getString("Nazwa"),x.getInteger("waga"),x.getInteger("koszt"));
				
				return item;
				
				
			}			
		}
		
		
		
		
		return null;
		
	}
	
//	    
	
		public void setSaldo(long id,int saldo) {
			
			MongoCollection<Document> collection = database.getCollection("Uzytkownik"); 
			
			FindIterable<Document> iterDoc = collection.find(); 
			

			collection.updateOne(Filters.eq("index", id), Updates.inc("saldo", saldo));
					

			
		}
		
		public void findPracownik() {
			
			MongoCollection<Document> collection = database.getCollection("Pracownik"); 
			
			FindIterable<Document> iterDoc = collection.find(); 

			ID.temp="";
			
			for(Document x : iterDoc) {
				
				ID.temp +="Login: ";
				ID.temp +=x.getString("Login");
				ID.temp +=" Email: ";
				ID.temp +=x.getString("email");
				ID.temp +=" haslo: ";
				ID.temp +=x.getString("haslo");
				ID.temp +=" staz: ";
				ID.temp +=x.getInteger("staz");
				ID.temp +=" sklep: ";
				ID.temp +=x.getString("sklep");
				ID.temp +=" index: ";
				ID.temp +=x.getLong("index");
				ID.temp +="\n";

			}

		}
		
		
//		DBCursor cursor = collection.find(query).sort(new BasicDBObject("_id", OrderBy.DESC.getIntRepresentation())).limit(1);
		
		public void show5ProductDESC() {
			
			MongoCollection<Document> collection = database.getCollection("Produkt"); 
			
//			FindIterable<Document> iterDoc = collection.find(); 

			FindIterable<Document> iterDoc = collection.find().sort(new BasicDBObject("index",-1)).limit(5);
			ID.temp="";
			for(Document x : iterDoc) {
				
				ID.temp +="Nazwa: ";
				ID.temp +=x.getString("nazwa");
				ID.temp +=" waga: ";
				ID.temp +=x.getInteger("waga");
				ID.temp +=" cena: ";
				ID.temp +=x.getInteger("cena");
				ID.temp +=" index: ";;
				ID.temp +=x.getLong("index");
				ID.temp +="\n";
			}

		}
		
		public void showRent() {
			
//			MongoCollection<Document> collection = database.getCollection("Wypozyczenia"); 
			
//			FindIterable<Document> iterDoc = collection.find(); 

//			FindIterable<Document> iterDoc = collection.find().sort(new BasicDBObject("_id",-1)).limit(1);
			
			MongoCollection<Document> collection = database.getCollection("Wypozyczenia"); 
			
			FindIterable<Document> iterDoc = collection.find(); 
			ID.temp="";
			for(Document x : iterDoc) {
				
		
					ID.temp +="Sklep: ";
					ID.temp +=x.getString("Sklep");
					ID.temp +=" KlientID: ";
					ID.temp +=x.getInteger("KlientID");
					ID.temp +=" DzienOd: ";
					ID.temp +=x.getInteger("DzienOd");
					ID.temp +=" MiesOd: ";
					ID.temp +=x.getInteger("MiesOd");
					ID.temp +=" RokOd: ";
					ID.temp +=x.getInteger("RokOd");
					ID.temp +=" DzienDo: ";
					ID.temp +=x.getInteger("DzienDo");
					ID.temp +=" MiesDo: ";
					ID.temp +=x.getInteger("MiesDo");
					ID.temp +=" RokDo: ";
					ID.temp +=x.getInteger("RokDo");
					ID.temp +=" idItem: ";
					ID.temp +=x.getInteger("idItem");
					ID.temp +="\n";
					
				
					
					
						
			}

		}
		
		public void showCollections() {
			ID.temp="";
			for(String name : database.listCollectionNames()) {
				
				ID.temp +="Nazwa : ";
				ID.temp +=name;

				ID.temp +="\n";
						
			}

		}
		
		public void showProdukt() {
			
			
			MongoCollection<Document> collection = database.getCollection("Produkt"); 
			
			FindIterable<Document> iterDoc = collection.find(); 
			ID.temp="";
			for(Document x : iterDoc) {
				
				ID.temp +="Nazwa: ";
				ID.temp +=x.getString("nazwa");
				ID.temp +=" waga: ";
				ID.temp +=x.getInteger("waga");
				ID.temp +=" cena: ";
				ID.temp +=x.getInteger("cena");
				ID.temp +=" index: ";;
				ID.temp +=x.getLong("index");
				ID.temp +="\n";
			}

		}
		
		public void showStores() {
			
			MongoCollection<Document> collection = database.getCollection("Sklep"); 
			
			FindIterable<Document> iterDoc = collection.find(); 
			
	
			ID.temp="";
			for(Document x : iterDoc) {
				
				ID.temp +="Nazwa: ";
				ID.temp +=x.getString("Nazwa");
				ID.temp +="Lokalizacja: ";
				ID.temp +=x.getString("Lokalizacja");
				ID.temp +="powierzchnia: ";
				ID.temp +=x.getString("powierzchnia");
				
				ID.temp +="\n";
				
				
				
			}
			
			
			
		
		}
		
			public void showUser() {
				
			     MongoCollection<Document> collection2 = database.getCollection("Uzytkownik"); 
				
				FindIterable<Document> iterDoc = collection2.find(); 
				
		
				ID.temp="";
				for(Document x : iterDoc) {
					
					ID.temp +="Login: ";
					ID.temp +=x.getString("Login");
					ID.temp +="email: ";
					ID.temp +=x.getString("email");
					ID.temp +="haslo: ";
					ID.temp +=x.getString("haslo");
					ID.temp +="saldo: ";
					ID.temp +=x.getInteger("saldo");
					ID.temp +="index: ";
					ID.temp +=x.getLong("index");
					
					ID.temp +="\n";
					
					
					
				}
				
				
				
			
			}
			
			public void showProduktRange36() {
				
				
				MongoCollection<Document> collection = database.getCollection("Produkt"); 
				
				FindIterable<Document> iterDoc = collection.find().skip(2).limit(3); 
				ID.temp="";
				for(Document x : iterDoc) {
					
					ID.temp +="Nazwa: ";
					ID.temp +=x.getString("nazwa");
					ID.temp +=" waga: ";
					ID.temp +=x.getInteger("waga");
					ID.temp +=" cena: ";
					ID.temp +=x.getInteger("cena");
					ID.temp +=" index: ";;
					ID.temp +=x.getLong("index");
					ID.temp +="\n";
				}

			}
			
			public void countProduct() {
				
				
			      MongoCollection<Document> collection2 = database.getCollection("Produkt"); 
			      
			      System.out.println("Collection selected successfully");

			      ID.temp="";
			      
			      long a = collection2.count();
			      ID.temp+=a;
				
				
			}
			
			
			
			
}

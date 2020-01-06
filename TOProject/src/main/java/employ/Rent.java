package employ;

public class Rent {

	
	String sklep;
	int klientID;
	int dzienOD,miesOd,rokOd;
	int dzienDO,miesDo,rokDo;
	int idItem;
	
	public Rent() {
		
	}
	
	public String getSklep() {
		return sklep;
	}
	public void setSklep(String sklep) {
		this.sklep = sklep;
	}
	public int getKlientID() {
		return klientID;
	}
	public void setKlientID(int klientID) {
		this.klientID = klientID;
	}
	public int getDzienOD() {
		return dzienOD;
	}
	public void setDzienOD(int dzienOD) {
		this.dzienOD = dzienOD;
	}
	public int getMiesOd() {
		return miesOd;
	}
	public void setMiesOd(int miesOd) {
		this.miesOd = miesOd;
	}
	public int getRokOd() {
		return rokOd;
	}
	public void setRokOd(int rokOd) {
		this.rokOd = rokOd;
	}
	public int getDzienDO() {
		return dzienDO;
	}
	public void setDzienDO(int dzienDO) {
		this.dzienDO = dzienDO;
	}
	public int getMiesDo() {
		return miesDo;
	}
	public void setMiesDo(int miesDo) {
		this.miesDo = miesDo;
	}
	public int getRokDo() {
		return rokDo;
	}
	public void setRokDo(int rokDo) {
		this.rokDo = rokDo;
	}
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public Rent(String sklep, int klientID, int dzienOD, int miesOd, int rokOd, int dzienDO, int miesDo, int rokDo,
			int idItem) {
		super();
		this.sklep = sklep;
		this.klientID = klientID;
		this.dzienOD = dzienOD;
		this.miesOd = miesOd;
		this.rokOd = rokOd;
		this.dzienDO = dzienDO;
		this.miesDo = miesDo;
		this.rokDo = rokDo;
		this.idItem = idItem;
	}
	
	
	
	
	
	
	
}

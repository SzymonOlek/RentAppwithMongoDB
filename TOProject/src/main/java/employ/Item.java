package employ;

public class Item {

	String nazwa;
	int waga;
	int cena;
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public int getWaga() {
		return waga;
	}
	public void setWaga(int waga) {
		this.waga = waga;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public Item(String nazwa, int waga, int cena) {
		super();
		this.nazwa = nazwa;
		this.waga = waga;
		this.cena = cena;
	}
	
	
	
	
}

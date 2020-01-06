package employ;

public class Store {

	String name;
	String localization;
	String powierzchnia;
	
	
	public String getName() {
		return name;
	}
	public Store(String name, String localization, String powierzchnia) {
		super();
		this.name = name;
		this.localization = localization;
		this.powierzchnia = powierzchnia;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocalization() {
		return localization;
	}
	public void setLocalization(String localization) {
		this.localization = localization;
	}
	public String getPowierzchnia() {
		return powierzchnia;
	}
	public void setPowierzchnia(String powierzchnia) {
		this.powierzchnia = powierzchnia;
	}
	
	
	
	
}

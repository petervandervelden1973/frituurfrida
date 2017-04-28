package be.vdab.entities;
public class Adres {
	private String straat;
	private String huisnr;
	private Gemeente gemeente;
	
	public Adres() {
	}

	public Adres(String straat, String huisnr, Gemeente gemeente) {
		this.straat = straat;
		this.huisnr = huisnr;
		this.gemeente = gemeente;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String getHuisnr() {
		return huisnr;
	}

	public void setHuisNr(String huisNr) {
		this.huisnr = huisNr;
	}

	public Gemeente getGemeente() {
		return gemeente;
	}

	public void setGemeente(Gemeente gemeente) {
		this.gemeente = gemeente;
	}
	
	
	
	
	
	
	
	
}
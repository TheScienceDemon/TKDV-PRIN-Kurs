package prin.ScienceDemon.Chapter4.Artikelbestand;

public class Artikel {
	private int nummer;
	private String name;
	private int bestand;
	
	public Artikel(int nummer, String name) {
		this.nummer = nummer;
		this.name = name;
		bestand = 0;
	}
	
	public int GibNummer() {
		return nummer;
	}
	
	public String GibName() {
		return name;
	}
	
	public int GibBestand() {
		return bestand;
	}
	
	public String toString() {
		return String.format(
			"%s: %s\nLagerbestand: %s",
			nummer, name, bestand);
	}
	
	public void ErhöheBestand(int anzahl) {
		if (anzahl > 0) {
			bestand += anzahl;
		} else {
			System.out.printf(
				"Versuchte Aufstockung von %s um einen negativen Wert: %s",
				name, anzahl);
		}
	}
	
	public void VerkaufeEinen() {
		if (bestand > 0) {
			bestand--;
		} else {
			System.out.printf(
				"Versuchter Verkauf eines nicht vorrätigen Artikels: %s",
				name);
		}
	}
}

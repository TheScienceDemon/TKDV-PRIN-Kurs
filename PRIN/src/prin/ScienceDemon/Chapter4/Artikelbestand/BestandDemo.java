package prin.ScienceDemon.Chapter4.Artikelbestand;

public class BestandDemo {
	private Bestandsverwalter verwalter;
	
	public BestandDemo() {
		verwalter = new Bestandsverwalter();
		verwalter.NeuerArtikel(new Artikel(132, "Uhrenradio"));
		verwalter.NeuerArtikel(new Artikel(37, "Mobiltelefon"));
		verwalter.NeuerArtikel(new Artikel(23, "Mikrowellenherd"));
	}
	
	public void Demo() {
		verwalter.AlleArtikelAnzeigen();
		verwalter.Aufnehmen(132, 5);
		verwalter.AlleArtikelAnzeigen();
	}
	
	public void ZeigeDetails(int nummer) {
		Artikel artikel = GibArtikel(nummer);
		if (artikel == null) { return; }

		System.out.println(artikel);
	}
	
	public void VerkaufeArtikel(int nummer) {
		Artikel artikel = GibArtikel(nummer);
		
		if (artikel == null) { return; }

		ZeigeDetails(nummer);
		artikel.VerkaufeEinen();
		ZeigeDetails(nummer);
	}
	
	public Artikel GibArtikel(int nummer) {
		Artikel artikel = verwalter.FindeArtikel(nummer);

		if (artikel != null) {
			return artikel;
		}

		System.out.printf(
			"Artikel mit Nummer \"%s\" ist nicht bekannt.",
			nummer);

		return null;
	}
	
	public Bestandsverwalter GibVerwalter() {
		return verwalter;
	}
}

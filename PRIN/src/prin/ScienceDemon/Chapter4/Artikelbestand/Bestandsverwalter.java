package prin.ScienceDemon.Chapter4.Artikelbestand;

import prin.ScienceDemon.Extensions;

import java.util.ArrayList;

public class Bestandsverwalter {
	private ArrayList<Artikel> lager;
	
	public Bestandsverwalter() {
		lager = new ArrayList<Artikel>();
	}
	
	public void NeuerArtikel(Artikel neuerArtikel) {
		boolean existiertBereits = false;

		for (Artikel artikel : lager) {
			if (neuerArtikel.GibNummer() != artikel.GibNummer()) {
				continue;
			}

			existiertBereits = true;
		}

		if (existiertBereits) { return; }

		lager.add(neuerArtikel);
	}
	
	public void Aufnehmen(int nummer, int menge) {
		Artikel artikel = FindeArtikel(nummer);

		if (artikel == null) { return; }

		artikel.ErhöheBestand(menge);
	}
	
	public Artikel FindeArtikel(int nummer) {
		for (Artikel artikel : lager) {
			if (artikel.GibNummer() != nummer) { continue; }

			return artikel;
		}

		return null;
	}

	public Artikel FindeArtikel(String name) {
		for (Artikel artikel : lager) {
			if (!artikel.GibName().equals(name)) { continue; }

			return artikel;
		}

		return null;
	}
	
	public int MengeImBestand(int nummer) {
		Artikel artikel = FindeArtikel(nummer);

		if (artikel == null) { return 0; }

		return artikel.GibBestand();
	}
	
	public void AlleArtikelAnzeigen() {
		for (Artikel artikel : lager) {
			artikel.toString();
		}
	}

	public void ArtikelAnzeigeUnter(int menge) {
		for (Artikel artikel : lager) {
			if (artikel.GibBestand() > menge) { continue; }

			String meldung = String.format(
				"Von Artikel \"%s\" nur noch weniger als %s im Bestand!",
				artikel.GibName(), artikel.GibBestand());

			Extensions.PrintToConsole(meldung);
		}
	}
}

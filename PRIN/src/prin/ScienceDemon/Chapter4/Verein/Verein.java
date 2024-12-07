package prin.ScienceDemon.Chapter4.Verein;

import prin.ScienceDemon.Extensions;

import java.util.ArrayList;

public class Verein {
	private ArrayList<Mitgliedschaft> mitglieder = new ArrayList<>();

	public Verein() {
		
	}
	
	public void Beitreten(Mitgliedschaft mitglied) {
		mitglieder.add(mitglied);
		Extensions.PrintToConsole(String.format(
			"Neues Mitglied: %s\nMitglieder im Verein: %s",
			mitglied.GibName(), mitglieder.size()));
	}

	public int GibAnzahlMitglieder() {
		return mitglieder.size();
	}

	public ArrayList<Mitgliedschaft> EntferneMitgliederVom(int jahr, int monat) {
		if (!Extensions.IstZwischen(monat, 0, 12)) {
			Extensions.PrintToConsole("Variable \"monat\" kein gültiger Monat!");
			return null;
		}

		ArrayList<Mitgliedschaft> entfernteMitglieder = new ArrayList<>();

		for (Mitgliedschaft mitglied : mitglieder) {
			if (mitglied.GibJahr() != jahr &&
				mitglied.GibMonat() != monat) { continue; }

			mitglieder.remove(mitglied);
			entfernteMitglieder.add(mitglied);
		}

		return entfernteMitglieder;
	}
}

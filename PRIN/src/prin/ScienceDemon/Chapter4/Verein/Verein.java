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
}

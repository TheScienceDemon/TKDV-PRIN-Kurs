package prin.ScienceDemon.Chapter4.Glücksspiel;

import prin.ScienceDemon.Extensions;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
	private static final boolean DEBUG = false;
	private static final int MIN_LOTTO_ZAHL = 1;
	private static final int MAX_LOTTO_ZAHL = 49;

	private ArrayList<Integer> gezogeneZahlen = new ArrayList<>();
	private int zusatzzahl;

	public void ZahlenZiehen() {
		gezogeneZahlen.clear();
		zusatzzahl = 0;

		for (int i = 0; i < 6; i++) {
			gezogeneZahlen.add(NeueZahlGenerieren(MIN_LOTTO_ZAHL, MAX_LOTTO_ZAHL));

			if (!DEBUG) { continue; }

			Extensions.PrintToConsole(String.format(
				"[DEBUG] Neue gezogene Zahl bei Index \"%s\": %s",
				i, gezogeneZahlen.get(i)));
		}

		zusatzzahl = NeueZahlGenerieren(MIN_LOTTO_ZAHL, MAX_LOTTO_ZAHL);

		if (DEBUG) {
			Extensions.PrintToConsole(String.format(
				"[DEBUG] Zusatzzahl: %s",
				zusatzzahl));
		}

		Collections.sort(gezogeneZahlen);

		Extensions.PrintToConsole("Ergebnis der Ziehung:");

		for (int i = 0; i < gezogeneZahlen.size(); i++) {
			Extensions.PrintToConsole(String.format(
				"%s. Zahl: %s",
				i + 1, gezogeneZahlen.get(i)));
		}

		Extensions.PrintToConsole(String.format(
			"Zusatzzahl: %s",
			zusatzzahl));
	}

	private int NeueZahlGenerieren(int min, int max) {
		int neueZahl = Extensions.Range(min, max);

		return !gezogeneZahlen.contains(neueZahl) ? neueZahl : NeueZahlGenerieren(min, max);
	}
}

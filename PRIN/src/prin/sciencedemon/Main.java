package prin.ScienceDemon;

import prin.ScienceDemon.Chapter4.MusikSammlungV1.MusikSammlung;
import static prin.ScienceDemon.Extensions.PrintToConsole;

public class Main {

	public static void main(String[] args) {
		MusikSammlung sammlung = new MusikSammlung();

		String[] lieder = new String[] {
			"Clair de Lune",
			"War Without Reason",
			"pq-Formel",
			"Eulers Algorithmus",
		};

		for (String lied : lieder) {
			sammlung.DateiHinzufügen(lied);
		}

		PrintToConsole(String.format(
			"Anzahl an Lieder in Sammlung: %s",
			sammlung.GibAnzahlDateien()));

		sammlung.DateiAusgeben(0);
		sammlung.DateiEntfernen(0);
		sammlung.DateiAusgeben(0);
	}
}

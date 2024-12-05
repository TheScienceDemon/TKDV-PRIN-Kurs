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

		// Code ab hier

		sammlung.IndexPrüfen(76);
	}
}

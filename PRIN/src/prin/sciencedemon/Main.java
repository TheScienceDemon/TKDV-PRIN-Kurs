package prin.ScienceDemon;

import prin.ScienceDemon.Chapter4.Glücksspiel.Lotto;

public class Main {
	public static void main(String[] args) {
		Lotto gambling = new Lotto();

		Extensions.PrintToConsole("\n\nErste Ziehung...");
		gambling.ZahlenZiehen();

		Extensions.PrintToConsole("\n\nZweite Ziehung...");
		gambling.ZahlenZiehen();

		Extensions.PrintToConsole("\n\nDritte Ziehung...");
		gambling.ZahlenZiehen();
	}
}

package prin.sciencedemon;

import prin.sciencedemon.chapter2.*;

public class Main {

	public static void main(String[] args) {
		Heizung heizung = new Heizung(15, 30);

		float temperatur = heizung.gibTemperatur();


		/*
		for (int i = 0; i < 5; i++) {
			heizung.verändereTemperatur(Heizung.TemperaturEinstellungen.WÄRMER);
		}

		for (int i = 0; i < 8; i++) {
			heizung.verändereTemperatur(Heizung.TemperaturEinstellungen.KÜHLER);
		}*/
	}
}

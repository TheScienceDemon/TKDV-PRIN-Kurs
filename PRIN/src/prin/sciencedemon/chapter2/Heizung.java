package prin.ScienceDemon.Chapter2;

import prin.ScienceDemon.Extensions;

public class Heizung {
	private float temperatur;
	private float min;
	private float max;
	private float schrittweite;

	public Heizung(float min, float max) {
		temperatur = 15;
		schrittweite = 5;

		this.min = min;
		this.max = max;
	}

	public float gibTemperatur() {
		return temperatur;
	}

	public void verändereTemperatur(TemperaturEinstellungen temperaturEinstellung) {
		temperatur = temperaturEinstellung == TemperaturEinstellungen.WÄRMER
			? temperatur + schrittweite
			: temperatur - schrittweite;

		temperatur = Extensions.Clamp(temperatur, min, max);
		System.out.println(String.format("Neue temperatur: %s", temperatur));
	}

	public void setzeSchrittweite(float neueSchrittweite) {
		if (neueSchrittweite < 0) {
			System.out.println("Variable \"neueSchrittweite\" ist negativ!\nWert wird negiert...");
		}

		schrittweite = Math.abs(neueSchrittweite);
	}

	public enum	TemperaturEinstellungen {
		WÄRMER,
		KÜHLER
	}
}

package prin.ScienceDemon.Chapter4.Bank;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Transaktion {
	private TransaktionsArten transaktionsArt;
	private double betrag;
	private LocalDate datum;
	private LocalTime uhrzeit;
	
	public Transaktion(Konto besitzer, TransaktionsArten transaktionsArt, double betrag) {
		this.transaktionsArt = transaktionsArt;
		this.betrag = betrag;

		datum = LocalDate.now();
		uhrzeit = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);

		besitzer.NeueTransaktion(this);
	}

	@Override
	public String toString() {
		return String.format(
			"%s, %s Uhr, %s, %s€",
			datum, uhrzeit, transaktionsArt, betrag);
	}
}

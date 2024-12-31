package prin.ScienceDemon.Chapter4.Bank;

import prin.ScienceDemon.Extensions;

import java.util.ArrayList;

public class Konto {
	private String kontonummer;
	private String besitzer;
	private String IBAN;
	private double überziehungslimit = 500;
	private double geldbetrag = 0;
	private ArrayList<Transaktion> transaktionsAufzeichnungen = new ArrayList<>();

	public Konto(Bank bank, String besitzer) {
		this.besitzer = besitzer;
		kontonummer = bank.KontonummerGenerieren(bank.KontoHinzufügen(this));
		IBAN = bank.IBAN_Generieren(this);
	}

	public String GetKontonummer() {
		return kontonummer;
	}

	public String GetBesitzer() {
		return besitzer;
	}

	public ArrayList<Transaktion> GetTransaktionsAufzeichnungen() {
		return transaktionsAufzeichnungen;
	}

	public void NeueTransaktion(Transaktion transaktion) {
		transaktionsAufzeichnungen.add(transaktion);
	}

	public void Einzahlen(double betrag, TransaktionsArten transaktionsArt) {
		if (!BetragNichtNiedrigerNull(betrag)) {
			Extensions.PrintToConsole(String.format(
				"""
				Achtung! Konto versucht, Betrag unter 0 einzuzahlen!
				%s
				Auszuzahlender Betrag: %s""",
				this, betrag));

			return;
		}

		new Transaktion(this, transaktionsArt, betrag);
		geldbetrag += betrag;
	}

	public void Einzahlen(double betrag) {
		if (!BetragNichtNiedrigerNull(betrag)) {
			Extensions.PrintToConsole(String.format(
				"""
				Achtung! Konto versucht, Betrag unter 0 einzuzahlen!
				%s
				Auszuzahlender Betrag: %s""",
				this, betrag));

			return;
		}

		new Transaktion(this, TransaktionsArten.Einzahlung, betrag);
		geldbetrag += betrag;
	}

	public boolean Auszahlen(double betrag) {
		if (!BetragNichtNiedrigerNull(betrag)) {
			Extensions.PrintToConsole(String.format(
				"""
				Achtung! Konto versucht, Betrag unter 0 auszuzahlen!
				%s
				Auszuzahlender Betrag: %s""",
				this, betrag));

			return false;
		}

		if (!BetragNichtGrößerGeldbetrag(betrag)) {
			Extensions.PrintToConsole(String.format(
				"Achtung! Konto hat ungenügenden Geldbetrag für Auszahlung!\n" +
				"%s -- Auszuzahlender Betrag: %s",
				this, betrag));

			return false;
		}

		if (!BetragNichtGrößerLimit(betrag)) {
			Extensions.PrintToConsole(String.format(
				"Achtung! Konto überschreitet Überziehungslimit!\n" +
					"%s -- Auszuzahlender Betrag: %s",
				this, betrag));

			return false;
		}

		new Transaktion(this, TransaktionsArten.Abhebung, betrag);
		geldbetrag -= betrag;

		return true;
	}

	public boolean Überweisen(Konto ziel, double betrag) { // Bzw. internÜberweisen
		if (!BetragNichtNiedrigerNull(betrag)) {
			Extensions.PrintToConsole(String.format(
				"""
				Achtung! Konto versucht, Betrag unter 0 zu überweisen!
				%s
				Auszuzahlender Betrag: %s""",
				this, betrag));

			return false;
		}

		if (!BetragNichtGrößerGeldbetrag(betrag)) {
			Extensions.PrintToConsole(String.format(
				"Achtung! Konto hat ungenügenden Geldbetrag für Überweisung!\n" +
				"%s -- Zu überweisender Betrag: %s",
				this, betrag));

			return false;
		}

		if (!BetragNichtGrößerLimit(betrag)) {
			Extensions.PrintToConsole(String.format(
				"Achtung! Konto überschreitet Überziehungslimit!\n" +
					"%s -- Zu überweisender Betrag: %s",
				this, betrag));

			return false;
		}

		new Transaktion(this, TransaktionsArten.Überweisung, -betrag);
		geldbetrag -= betrag;

		ziel.Einzahlen(betrag, TransaktionsArten.Überweisung);

		return true;
	}

	private boolean BetragNichtNiedrigerNull(double betrag) {
		return betrag >= 0;
	}

	private boolean BetragNichtGrößerGeldbetrag(double betrag) {
		return betrag <= geldbetrag;
	}

	private boolean BetragNichtGrößerLimit(double betrag) {
		return betrag <= überziehungslimit;
	}

	@Override
	public String toString() {
		return String.format(
			"Besitzer: %s (Kontonummer: %s)\n" +
			"Geldbetrag: %s€\n" +
			"IBAN: %s",
			besitzer, kontonummer, geldbetrag, IBAN);
	}
}

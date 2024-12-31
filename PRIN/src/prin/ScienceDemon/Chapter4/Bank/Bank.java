package prin.ScienceDemon.Chapter4.Bank;

import prin.ScienceDemon.Extensions;

import java.util.ArrayList;

public class Bank {
	private String bankIndentifiziererCode;
	private String bankleitzahl; // 8-stellig
	private String ländercode;
	private String name;
	private ArrayList<Konto> konten = new ArrayList<>();

	public Bank(String bankIndentifiziererCode, String bankleitzahl, String ländercode, String name) {
		this.bankIndentifiziererCode = bankIndentifiziererCode;
		this.bankleitzahl = bankleitzahl;
		this.ländercode = ländercode;
		this.name = name;
	}

	public ArrayList<Konto> GetKonten() {
		return konten;
	}

	public void KontenAuflisten() { // Bzw. kontenÜbersicht
		for (Konto konto: konten) {
			Extensions.PrintToConsole(
				konto.toString() + "\n");
		}
	}

	public int KontoHinzufügen(Konto neuesKonto) {
		for (Konto konto : konten) {
			if (konto.GetBesitzer().equals(neuesKonto.GetBesitzer())) {
				return 0; // Konto existiert bereits
			}
		}

		konten.add(neuesKonto);
		return konten.size();
	}

	public String KontonummerGenerieren(int zuVerarbeitendeKontonummer) {
		var kontonummer = String.valueOf(zuVerarbeitendeKontonummer);

		while (kontonummer.length() < 10) {
			kontonummer = String.format("0%s", kontonummer);
		}

		return kontonummer;
	}

	public String IBAN_Generieren(Konto konto) {
		var generierteIBAN = String.format(
			"%s %s %s",
			ländercode, bankleitzahl, konto.GetKontonummer());

		return generierteIBAN;
	}
}

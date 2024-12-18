package prin.ScienceDemon.Chapter4.Bank;

import prin.ScienceDemon.Extensions;

import java.util.ArrayList;

public class Bank {
	private String bankIndentifiziererCode;
	private int bankleitzahl; // 8-stellig
	private String ländercode;
	private String name;
	private ArrayList<Konto> konten = new ArrayList<>();

	public Bank(String bankIndentifiziererCode, int bankleitzahl, String ländercode, String name) {
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
				return 0;
			}
		}

		konten.add(neuesKonto);
		return konten.size() - 1;
	}
}

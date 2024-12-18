package prin.ScienceDemon;

import prin.ScienceDemon.Chapter4.Bank.Bank;
import prin.ScienceDemon.Chapter4.Bank.Konto;

public class Main {
	public static void main(String[] args) {
		Bank zentralBank = new Bank(
			"EZB",
			12345678,
			"DE44",
			"Europäische Zentralbank");

		new Konto(zentralBank,"Louis Steffen Ruppert");
		new Konto(zentralBank,"Gabriel Baldreich");
		new Konto(zentralBank,"Jannik Nüchter");
		new Konto(zentralBank,"Alexander Brenzel");

		zentralBank.KontenAuflisten();

		Konto kontoLouisRuppert = zentralBank.GetKonten().get(0);
		Konto kontoGabrielBaldreich = zentralBank.GetKonten().get(1);

		kontoLouisRuppert.Einzahlen(1000);
		kontoLouisRuppert.Überweisen(kontoGabrielBaldreich, 200);
	}
}

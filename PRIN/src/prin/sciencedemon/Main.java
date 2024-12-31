package prin.ScienceDemon;

import prin.ScienceDemon.Chapter4.Bank.Bank;
import prin.ScienceDemon.Chapter4.Bank.Konto;

public class Main {
	public static void main(String[] args) {
		var zentralBank = new Bank(
			"EZB",
			"12345678",
			"DE44",
			"Europäische Zentralbank");

		var kontoLouisRuppert		= new Konto(zentralBank,"Louis Steffen Ruppert");
		var kontoGabrielBaldreich	= new Konto(zentralBank,"Gabriel Baldreich");
		var kontoJannikNüchter		= new Konto(zentralBank,"Jannik Nüchter");
		var kontoAlexanderBrenzel	= new Konto(zentralBank,"Alexander Brenzel");

		kontoLouisRuppert.Einzahlen(1000);
		kontoGabrielBaldreich.Einzahlen(400);
		kontoJannikNüchter.Einzahlen(800);
		kontoAlexanderBrenzel.Einzahlen(600);

		// Louis Ruppert
		kontoLouisRuppert.Überweisen(kontoGabrielBaldreich, 200);
		kontoLouisRuppert.Überweisen(kontoJannikNüchter, 150);
		kontoLouisRuppert.Auszahlen(100);

		// Gabriel Baldreich
		kontoGabrielBaldreich.Überweisen(kontoAlexanderBrenzel, 50);
		kontoGabrielBaldreich.Einzahlen(150);

		// Jannik Nüchter
		kontoJannikNüchter.Einzahlen(69420);
		kontoJannikNüchter.Überweisen(kontoAlexanderBrenzel, 400);
		kontoJannikNüchter.Überweisen(kontoLouisRuppert, 400);

		// Herr Brenzel
		kontoAlexanderBrenzel.Auszahlen(50);
		kontoAlexanderBrenzel.Auszahlen(50);
		kontoAlexanderBrenzel.Auszahlen(50);
		kontoAlexanderBrenzel.Auszahlen(50);
		kontoAlexanderBrenzel.Auszahlen(50);

		zentralBank.KontenAuflisten();

		var transaktionenLouisRuppert = kontoLouisRuppert.GetTransaktionsAufzeichnungen();
		Extensions.PrintToConsole(transaktionenLouisRuppert.toString());
	}
}

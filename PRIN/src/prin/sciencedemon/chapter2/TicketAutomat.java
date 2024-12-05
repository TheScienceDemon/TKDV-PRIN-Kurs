package prin.ScienceDemon.Chapter2;

public class TicketAutomat {
	private int preis;
	private int bisherGezahlt;
	private int gesamtsumme;

	public TicketAutomat(int ticketpreis) {
		preis = ticketpreis;
		bisherGezahlt = 0;
		gesamtsumme = 0;
	}

	public TicketAutomat() {
		preis = 420;
		bisherGezahlt = 0;
		gesamtsumme = 0;
	}

	public int gibPreis() {
		return preis;
	}

	public int gibBisherGezahltenBetrag() {
		return bisherGezahlt;
	}

	public int gibGesamtsumme() {
		return  gesamtsumme;
	}

	public void preisAusgeben() {
		String s = String.format("Der Preis eines Tickets beträgt %s Cent.", preis);
		System.out.println(s);
	}

	public void geldEinwerfen(int betrag) {
		bisherGezahlt = bisherGezahlt + betrag;
	}

	public void ticketDrucken() {
		System.out.println("##################");
		System.out.println("# Die BlueJ-Linie");
		System.out.println("# Ticket");
		System.out.println(String.format("# %s Cent.", preis));
		System.out.println("##################");
		System.out.println();

		gesamtsumme = gesamtsumme + bisherGezahlt;
		bisherGezahlt = 0;
	}

	public void setzePreis(int neuerPreis) {
		preis = neuerPreis;
	}

	public void meldung() {
		System.out.println("Bitte wirf den passenden Geldbetrag ein");
	}
}


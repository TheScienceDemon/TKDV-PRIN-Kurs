package prin.ScienceDemon.Chapter4.Verein;

public class VereinDemo {
	private Verein verein;
	
	public VereinDemo() {
		verein = new Verein();
	}

	public void Demo() {
		verein.Beitreten(new Mitgliedschaft("David", 2, 2004));
		verein.Beitreten(new Mitgliedschaft("Michael", 1, 2004));
		System.out.printf("Der Verein hat %s Mitglieder.", verein.GibAnzahlMitglieder());
	}
}

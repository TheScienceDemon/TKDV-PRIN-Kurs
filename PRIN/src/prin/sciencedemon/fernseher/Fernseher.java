package prin.sciencedemon.fernseher;

public class Fernseher {
	private boolean istAn;
	private boolean istStumm;
	private int lautstärke;
	private int ausgewählterSender; // 0 -> 29

	public Fernseher() {
		istAn = false;
		istStumm = false;
		lautstärke = 5;
		ausgewählterSender = 0;
	}

	public void ÄndereFernseherZustand() {
		istAn = !istAn;
	}

	public void SchalteFernseherStumm() {
		istStumm = !istStumm;
	}

	public void ÄndereLautstärke(Lautstärken lautstärkeEinstellung) {
		lautstärke = lautstärkeEinstellung == Lautstärken.HOCH
			? lautstärke + 1
			: lautstärke - 1;

		istStumm = false;
	}

	public void WechsleSender(int neuerSender) {
		ausgewählterSender = neuerSender;
	}

	public enum Lautstärken {
		HOCH,
		RUNTER
	}
}

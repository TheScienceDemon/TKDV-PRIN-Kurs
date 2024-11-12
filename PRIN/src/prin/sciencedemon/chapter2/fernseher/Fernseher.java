package prin.sciencedemon.chapter2.fernseher;

import prin.sciencedemon.Extensions;

public class Fernseher {
	private boolean istAn;
	private boolean istStumm;
	private int lautstärke;
	private int ausgewählterSender; // 0 -> 29

	public Fernseher() {
		istAn = false;
		istStumm = false;
		lautstärke = 2;
		ausgewählterSender = 0;
	}

	public void ÄndereFernseherAnZustand() {
		istAn = !istAn;
	}

	public void ÄndereFernseherStummZustand() {
		istStumm = !istStumm;

		/*
		Idee dahinter ist, dass man in einer Methode "AudioAusgeben" dann sowas hat wie:

		public void AudioAusgeben() {
			if (istStumm) {
				return;
			}

			// Hier Code, der Audio ausgibt
		}

		Dadurch sollte sowas dann verhindert werden.
		 */
	}

	public void ÄndereLautstärke(int neueLautstärke) {
		if (!Extensions.IstZwischen(neueLautstärke, 0, 10)) { return; }

		lautstärke = neueLautstärke;
	}

	public void ÄndereLautstärke(Lautstärken lautstärkeEinstellung) {
		lautstärke = lautstärkeEinstellung == Lautstärken.HOCH
			? lautstärke + 1
			: lautstärke - 1;

		istStumm = false;
	}

	public void WechsleSender(int neuerSender) {
		if (!Extensions.IstZwischen(neuerSender, 0, 29)) {
			System.out.println("Variable \"neuerSender\" liegt außerhalb der möglichen Sender (OutOfBounds Exception)!");
			return;
		}

		ausgewählterSender = neuerSender;
	}

	public void GibFernseherZustandAus() {
		if (!istAn) {
			System.out.printf("An/Aus: %s%n%n", istAn);
			return;
		}

		String fernseherZustand = String.format(
			"""
			Fernseher-Zustand:
			An/Aus: %s
			Ausgewählter Sender: %s.
			Lautstärke: %s
			Stummgeschaltet: %s
			""", istAn, ausgewählterSender + 1, lautstärke, istStumm);
		System.out.println(fernseherZustand);
	}

	public enum Lautstärken {
		HOCH,
		HERUNTER
	}
}

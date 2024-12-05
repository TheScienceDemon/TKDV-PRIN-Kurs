package prin.ScienceDemon.Chapter3.Uhr;

public class Uhr {
	private UhrSegment stunden;
	private UhrSegment minuten;
	private String zeitanzeige;

	public Uhr() {
		stunden = new UhrSegment(24);
		minuten = new UhrSegment(60);
		AnzeigeAktualisieren();
	}

	public Uhr(int stunde, int minute) {
		stunden = new UhrSegment(24);
		minuten = new UhrSegment(60);
		SetzeUhrzeit(stunde, minute);
	}

	public void TaktsignalGeben() {
		minuten.Erhöhen();
		if (minuten.GibWert() == 0) {  // Limit wurde erreicht!
			stunden.Erhöhen();
		}

		AnzeigeAktualisieren();
	}

	public void SetzeUhrzeit(int stunde, int minute) {
		stunden.SetzeWert(stunde);
		minuten.SetzeWert(minute);
		AnzeigeAktualisieren();
	}

	public String GibUhrzeit() {
		return zeitanzeige;
	}

	private void AnzeigeAktualisieren() {
		zeitanzeige = String.format(
			"%s:%s",
			stunden.GibAnzeigewert(),
			minuten.GibAnzeigewert());
	}
}

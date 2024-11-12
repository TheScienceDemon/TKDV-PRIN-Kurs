package prin.sciencedemon.chapter3.uhr;

public class UhrSegment {
	private int limit;
	private int wert;

	public UhrSegment(int anzeigeLimit) {
		limit = anzeigeLimit;
		wert = 0;
	}

	public int GibWert() {
		return wert;
	}

	public String GibAnzeigewert() {
		if (wert < 10) {
			return "0" + wert;
		} else {
			return "" + wert;
		}
	}

	public void SetzeWert(int ersatzwert) {
		if ((ersatzwert >= 0) && (ersatzwert < limit)) {
			wert = ersatzwert;
		}
	}

	public void Erhöhen() {
		wert = (wert + 1) % limit;
	}
}

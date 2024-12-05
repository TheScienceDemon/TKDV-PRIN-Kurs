package prin.ScienceDemon.Chapter3.MailServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MailServer {
	private List<Nachricht> nachrichten;

	public MailServer() {
		nachrichten = new ArrayList<>();
	}

	public int AnzahlNachrichtenFür(String benutzer) {
		int anzahl = 0;

		for (Nachricht nachricht: nachrichten) {
			if (nachricht.GibEmpfänger().equals(benutzer)) {
				anzahl++;
			}
		}

		return anzahl;
	}

	public Nachricht GibNächsteNachrichtFür(String benutzer) {
		Iterator<Nachricht> it = nachrichten.iterator();

		while (it.hasNext()) {
			Nachricht nachricht = it.next();

			if (nachricht.GibEmpfänger().equals(benutzer)) {
				it.remove();

				return nachricht;
			}
		}

		return null;
	}

	public void LeiteWeiter(Nachricht nachricht) {
		nachrichten.add(nachricht);
	}
}

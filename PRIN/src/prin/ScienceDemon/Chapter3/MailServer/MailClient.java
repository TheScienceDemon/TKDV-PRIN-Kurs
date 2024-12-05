package prin.ScienceDemon.Chapter3.MailServer;

public class MailClient {
	private MailServer server;
	private String benutzer;

	public MailClient(MailServer server, String benutzer) {
		this.server = server;
		this.benutzer = benutzer;
	}

	public Nachricht GibNächsteNachricht() {
		return server.GibNächsteNachrichtFür(benutzer);
	}

	public void NächsteNachrichtAusgeben() {
		Nachricht nachricht = server.GibNächsteNachrichtFür(benutzer);

		if (nachricht == null) {
			System.out.println("Keine neue Nachricht.");
		} else {
			nachricht.Ausgeben();
		}
	}

	public void SendeNachricht(String empfänger, String text) {
		Nachricht nachricht = new Nachricht(benutzer, empfänger, text);

		server.LeiteWeiter(nachricht);
	}
}

package prin.ScienceDemon.Chapter3.MailServer;

public class Nachricht {
	private String absender;
	private String empfänger;
	private String text;

	public Nachricht(String absender, String empfänger, String text) {
		this.absender = absender;
		this.empfänger = empfänger;
		this.text = text;
	}

	public String GibAbsender() {
		return absender;
	}

	public String GibEmpfänger() {
		return empfänger;
	}

	public String GibText() {
		return text;
	}

	public void Ausgeben() {
		System.out.println("Von: " + absender);
		System.out.println("An: " + empfänger);
		System.out.println("Text: " + text);
	}
}

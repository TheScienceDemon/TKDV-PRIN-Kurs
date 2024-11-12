package prin.sciencedemon;

import prin.sciencedemon.chapter2.fernseher.Fernseher;

public class Main {

	public static void main(String[] args) {
		Fernseher fernseher = new Fernseher();
		fernseher.GibFernseherZustandAus();

		fernseher.ÄndereFernseherAnZustand(); // a) An / Aus
		fernseher.GibFernseherZustandAus();

		fernseher.ÄndereLautstärke(5); // b) Lautstärke
		fernseher.GibFernseherZustandAus();

		fernseher.ÄndereFernseherStummZustand(); // c) Stummschalten
		fernseher.GibFernseherZustandAus();

		fernseher.ÄndereLautstärke(Fernseher.Lautstärken.HERUNTER); // d) Lautstärke -> "Lauter" / "Leiser"
		fernseher.GibFernseherZustandAus();

		fernseher.WechsleSender(24); // e) Sender auswählen
		fernseher.GibFernseherZustandAus();
	}
}

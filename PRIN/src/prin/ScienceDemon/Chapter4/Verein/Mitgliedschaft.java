package prin.ScienceDemon.Chapter4.Verein;

public class Mitgliedschaft {
    private String name;
    private int monat;
    private int jahr;
    
    public Mitgliedschaft(String name, int monat, int jahr)
    throws IllegalArgumentException {
        if (monat < 1 || monat > 12) {
            String error = "Monat %s ungültig. Muss im Bereich 1 ... 12 liegen.";
            throw new IllegalArgumentException(String.format(error, monat));
        }

        this.name = name;
        this.monat = monat;
        this.jahr = jahr;
    }
    
    public String GibName() {
        return name;
    }
    
    public int GibMonat() {
        return monat;
    }
    
    public int GibJahr() {
        return jahr;
    }
    
    public String toString() {
        return String.format(
            "Name: %s\nBeigetreten im Monat: %s / %s",
            name, monat, jahr);
    }
}

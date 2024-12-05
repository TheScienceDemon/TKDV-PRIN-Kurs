package prin.ScienceDemon.Chapter4.MusikSammlungV1;

import java.util.ArrayList;

public class MusikSammlung {
    private ArrayList<String> dateien;

    public MusikSammlung() {
        dateien = new ArrayList<>();
    }

    public void DateiHinzufügen(String dateiname) {
        dateien.add(dateiname);
    }

    public int GibAnzahlDateien() {
        return dateien.size();
    }

    public void DateiAusgeben(int index) {
        if (index >= 0 && index < dateien.size()) {
            String dateiname = dateien.get(index);
            System.out.println(dateiname);
        }
    }

    public void DateiEntfernen(int index) {
        if (index >= 0 && index < dateien.size()) {
            dateien.remove(index);
        }
    }

}

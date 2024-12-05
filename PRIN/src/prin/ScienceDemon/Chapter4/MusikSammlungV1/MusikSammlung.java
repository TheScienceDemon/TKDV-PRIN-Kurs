package prin.ScienceDemon.Chapter4.MusikSammlungV1;

import prin.ScienceDemon.Extensions;
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
        if (!GültigerIndex(index)) { return; }

        String dateiname = dateien.get(index);
        System.out.println(dateiname);
    }

    public void DateiEntfernen(int index) {
        if (!GültigerIndex(index)) { return; }

        dateien.remove(index);
    }

    public void IndexPrüfen(int index) {
        if (Extensions.IstZwischen(index, 0, dateien.size() - 1)) { return; }
        
        String fehlermeldung = String.format(
            "Index-Grenzverletzung in Array \"dateien\"!\nMaximale Array-Größe: %s\nAngegebener Index: %s",
            dateien.size(),
            index);

        Extensions.PrintToConsole(fehlermeldung);
    }

    public boolean GültigerIndex(int index) {
        if (dateien.isEmpty()) {
            return false;
        }

        return Extensions.IstZwischen(index, 0, dateien.size() - 1);
    }
}

package si.feri.opj.smiljanic.ui; // Mapa, kjer se datoteka nahaja

import java.io.*;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class UpravljalecDatotek {
    private static final String DATOTEKA_PODATKOV = "podatki.txt";

    public static void shraniPodatke() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new GZIPOutputStream(new FileOutputStream(DATOTEKA_PODATKOV)))) {

            // Shranimo vse liste iz Baze v enem koraku
            oos.writeObject(Baza.vsiSportniki);
            oos.writeObject(Baza.vsaPrizorisca);
            oos.writeObject(Baza.vsiDogodki);

            Loger.zapisiDogodek("ZAZNAMEK", "Podatki uspešno serializirani in komprimirani.");
        } catch (IOException e) {
            Loger.zapisiDogodek("NAPAKA", "Napaka pri serializaciji: " + e.getMessage());
        }
    }

    public static void naloziPodatke() {
        File f = new File(DATOTEKA_PODATKOV);
        if (!f.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(
                new GZIPInputStream(new FileInputStream(DATOTEKA_PODATKOV)))) {
            Baza.vsiSportniki = (ArrayList<sport.Sportnik>) ois.readObject();
            Baza.vsaPrizorisca = (ArrayList<infrastruktura.Prizorisce>) ois.readObject();
            Baza.vsiDogodki = (ArrayList<sport.Dogodek>) ois.readObject();

            Loger.zapisiDogodek("ZAZNAMEK", "Podatki uspešno obnovljeni iz datoteke.");
        } catch (Exception e) {
            Loger.zapisiDogodek("NAPAKA", "Napaka pri obnovitvi podatkov: " + e.getMessage());
        }
    }
}
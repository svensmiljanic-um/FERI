package si.feri.opj.smiljanic.ui; // Mapa, kjer se datoteka nahaja

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Loger {
    private static final String LOG_DATOTEKA = "dnevnik_dogodkov.txt";

    public static void zapisiDogodek(String resnost, String opis) {
        try (FileWriter fw = new FileWriter(LOG_DATOTEKA, true)) {
            String cas = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String zapis = String.format("[%s] %s: %s\n", cas, resnost.toUpperCase(), opis);

            fw.write(zapis);
        } catch (IOException e) {
            System.err.println("Napaka pri pisanju v dnevnik: " + e.getMessage());
        }
    }
}
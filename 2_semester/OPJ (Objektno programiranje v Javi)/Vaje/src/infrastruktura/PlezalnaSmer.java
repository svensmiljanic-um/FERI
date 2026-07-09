package infrastruktura; // Mapa, kjer se datoteka nahaja

import java.io.Serializable; // Da bomo lahko shranili v datoteko

public class PlezalnaSmer implements Serializable {
    private String oznaka;
    private String ime;
    private int tezavnost;

    public PlezalnaSmer(String oznaka, String ime, int tezavnost) {
        this.oznaka = oznaka;
        this.ime = ime;
        this.tezavnost = tezavnost;
    }

    public String getOznaka() { return oznaka; }
    public String getIme() { return ime; }
    public int getTezavnost() { return tezavnost; }

    // Razred nima Setter metod, saj se podatki ne bomo spreminjali. Če se morajo, ustvarimo nov objekt.
}
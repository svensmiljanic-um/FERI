package sport; // Mapa, kjer se datoteka nahaja

public class Trening extends Dogodek {
    //Deduje od razreda Dogodek (naziv in seznam športnikov)
    private String imeTrenerja;

    public Trening(String naziv) {
        super(naziv, null); // Trening nima nujno termina ob ustvarjanju
    }
    /*
    Konstruktor, ki se kliče z besedo "new"
    Primer:
        new Trening ("Jutranji tek");

    super(naziv, null) - klice konstruktor nadrazreda ("Dogodek")
    */

    public String getImeTrenerja() {
        return imeTrenerja;
    }
    /*
    Spremenljivka imeTrenerja je privatna, zato rabimo javno metodo, da lahko prebere ime trenerja (GETTER).
    Vrne vrednost, ki je v objektu.
     */

    public void setImeTrenerja(String imeTrenerja) {
        this.imeTrenerja = imeTrenerja;
    }
    /*
    Omogoča, da naknadno nastavimo ali spremenimo ime trenerja. (SETTER)

    this.imeTrenerja = imeTrenerja; - vzame privatno spremenljivko tega objekta in ji priredi vrednost, ki sem jo dobil kot parameter metode
     */

    @Override // Povozimo obstoječo metodo z istim imenom iz nadrazreda
    public String toString() {
        //to String() - metoda, ki določa, kako se bo ta objekt izpisal, če ga poskusimo izpisati

        StringBuilder sb = new StringBuilder("Trening: " + getNaziv());

        if (imeTrenerja != null && !imeTrenerja.isEmpty()) {
            sb.append(" (Trener: ").append(imeTrenerja).append(")");
        } //Preverimo, če je ime trenerja nastavljeno in ni prazno, da ga lahko dodamo v izpis

        // Izpis vseh dodanih športnikov
        if (seznamSportnikov != null && !seznamSportnikov.isEmpty()) {
            sb.append(" | Športniki: ");
            for (Sportnik s : seznamSportnikov) {
                if (s != null) {
                    sb.append(s.getIme()).append(" ").append(s.getPriimek()).append(", ");
                }
                /*
                Znotraj zanke preverimo, ali ta konkreten športnik slučajno ni null.
                Če obstaja, dodamo njegovo ime in priimek v izpis.
                Če je null, ga preskočimo, da ne dobimo napake.
                IZPIS:
                    "Športniki: Janez Novak, Marija Hribar, "
                Vejica se doda na koncu!!!
                 */
            }
            if (sb.toString().endsWith(", ")) {
                sb.setLength(sb.length() - 2);
            }
            /*
            .endWith(", ") - Preverimo, če se to besedilo konča z odvečno vejico in presledkom.
            .setLength() - Odrežemo zadnja dva znaka

            IZPIS:
                "Športniki: Janez Novak, Marija Hribar"
             */
        }
        return sb.toString();
        /*
            .endWith(", ") - Preverimo, če se to besedilo konča z odvečno vejico in presledkom.
            .setLength() - Odrežemo zadnja dva znaka

            IZPIS:
                "Športniki: Janez Novak, Marija Hribar"
             */
    }
}
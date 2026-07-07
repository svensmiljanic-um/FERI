package infrastruktura; // Mapa, kjer se datoteka nahaja

import sport.DodajanjeTekmeException;
import sport.Tekma;
import sport.SportnaPanoga;

import java.io.Serializable;

public abstract class Prizorisce implements Serializable {
    /*
    abstract - ne moremo neposredno ustvariti objekta tipa prizorišče (npr. new Prizorisce(...) bo v Javi vrglo napako).
    Zakaj? Ker je "prizorišče" presplošen pojem.
    Ustvarimo lahko le njegove konkretne podrazrede (npr. new Dvorana(...) ali new Stadion(...)).
    Ta razred obstaja samo zato, da združuje skupno kodo, ki si jo delijo vsa prizorišča.
     */
    protected String ime;
    protected String telefon;
    protected Tekma[] seznamTekem;
    protected SportnaPanoga sportnaPanoga;

    public Prizorisce () {
        this(null, null, 0);
    }

    public Prizorisce (String ime) {
        this (ime, null, 0);
    }

    public Prizorisce (String ime, String telefon, int kapacitetaTekem) {
        if (kapacitetaTekem < 0) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        /*
        Če nekdo poskuša ustvariti prizorišče z negativno kapaciteto, program takoj vrže vgrajeno izjemo IllegalArgumentException in se ustavi.
         */
        this.ime = ime;
        this.telefon = telefon;
        this.seznamTekem = new Tekma[kapacitetaTekem];
    }

    /*
    Če je kapaciteta veljavna (npr. 5), ustvari tabelo tekem točno te velikosti: new Tekma[5]
     */

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getTelefon(){ return telefon; }
    public void setTelefon(String telefon){ this.telefon = telefon; }

    public SportnaPanoga getSportnaPanoga() { return sportnaPanoga; }
    public void setSportnaPanoga(SportnaPanoga sportnaPanoga) { this.sportnaPanoga = sportnaPanoga; }

    public Tekma[] getSeznamTekem() {
        return seznamTekem;
    }

    public void dodajTekmo (Tekma tekma) throws DodajanjeTekmeException {
        //Poskuša dodati novo tekmo v tabelo, pri čemer lahko sproži tvojo lastno izjemo DodajanjeTekmeException, če tekma ni veljavna.
        if (this instanceof Stadion) {
            if (tekma != null && tekma.getTermin() != null && tekma.getTermin().getTermin() != null) {
                if (tekma.getTermin().getTermin().getDayOfMonth() >= 20) {
                    throw new DodajanjeTekmeException();
                }
            }
        }
        /*
        instanceof preveri: "Ali je ta konkretni objekt, na katerem se zdaj izvaja koda, v resnici Stadion?".
        DA - se izvedejo dodatna preverjanja.
        getDayOfMonth() >= 20: Koda preveri datum tekme.
        Če poskušamo na stadion dodati tekmo, ki se odvija 20. dne v mesecu ali kasneje, se sproži napaka DodajanjeTekmeException.
         */

        for (int i = 0; i < seznamTekem.length; i++) {
            if (seznamTekem[i] == null) {
                seznamTekem[i] = tekma;
                break;
            }
        }
        /*
        Če tekma preživi zgornje preverjanje, gre zanka čez tabelo.
        Poišče prvo prazno mesto (null), tam shrani tekmo in z break prekine zanko, da je ne bi dodala večkrat.
         */
    }

    public void odstraniTekme () {
        for (int i = 0; i < seznamTekem.length; i++) {
            seznamTekem[i] = null;
        }
    }
    /*
    Gre čez celotno tabelo in vsa mesta ponovno nastavi na null.
     */

    public double vrniZasedenost(){
        int stTekem = 0;
        for (Tekma t : seznamTekem) {
            if (t != null) {
                stTekem++;
            }
        }
        return (double) stTekem / seznamTekem.length;
    }
    /*
    Najprej prešteje, koliko dejanskih tekem (ki niso null) je v tabeli.
    Nato to število deli s celotno velikostjo tabele (kapaciteto).
    (double) pred deljenjem – začasno spremeni celo število stTekem v decimalno, da rezultat deljenja ne bo zaokrožen na celo število
     */

    public abstract double vrniKapaciteto();

    @Override
    public String toString() {
        return "Prizorisce:" + ime + "," + telefon + "," + sportnaPanoga;
    }
}
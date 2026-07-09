package sport; // Mapa, kjer se datoteka nahaja

import java.io.Serializable; // Objekt pretvorimo v zaporedje bajtov, kar nam omogoča shranjevanje objekta v datoteko ali prenos preko omrežja.
import java.util.ArrayList;

public class Dogodek implements Serializable {
    /*
    Uporabljam vmesnik Serializable - za lažje shranjevanje in prenos objektov, ki vsebujejo datum, kot je Termin v datoteke.
    Če imamo v razredu občutljive podatke (kot so gesla) ali objekte, ki niso serializabilni (npr. povezava na bazo), jih označimo s transient, da jih Java pri postopku preskoči.
     */

    private static final long serialVersionUID = 1L;
    /*
    Če shranimo objekt v datoteko, Java zapiše tudi to številko.
    Če bi kasneje kodo razreda spremenili (npr. dodali nov atribut), bi Java preverila to številko in ugotovila, ali je stara shranjena datoteka še vedno združljiva z novo kodo.
    1L = verzija 1
     */

    protected String naziv;
    protected Termin termin;
    protected ArrayList<Sportnik> seznamSportnikov = new ArrayList<>();
    /*
    protected - dostopajo lahko vsi razredi znotraj istega paketa in vsi podrazredi
    new ArrayList<>() - seznam športnikov se ob ustvarjanju objekta inicializira
     */

    public Dogodek(String naziv, Termin termin) {
        this.naziv = naziv;
        this.termin = termin;
    }

    public void dodajSportnika(Sportnik s) {
        if (s != null) {
            seznamSportnikov.add(s);
        }
    }
    /*
    Metoda, s katero na dogodek dodamo novega športnika.
    Preverimo tudi, če je objekt prazen.
    .add() - doda objekt na konec ArrayList-a
     */

    public ArrayList<Sportnik> getSeznamSportnikov() {
        return seznamSportnikov;
    }

    public String getNaziv () {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }
}
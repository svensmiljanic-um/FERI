package sport; // Mapa, kjer se datoteka nahaja

import java.io.Serializable; // Objekt pretvorimo v zaporedje bajtov, kar nam omogoča shranjevanje objekta v datoteko ali prenos preko omrežja.
import java.time.LocalDate; // Za računanje z datumi

public class Termin implements Serializable {
    /*
    Uporabljam vmesnik Serializable - za lažje shranjevanje in prenos objektov, ki vsebujejo datum, kot je Termin v datoteke.
    Če imamo v razredu občutljive podatke (kot so gesla) ali objekte, ki niso serializabilni (npr. povezava na bazo), jih označimo s transient, da jih Java pri postopku preskoči.
     */
    private LocalDate termin; //tu se shranjuje datum

    public Termin (LocalDate termin){
        this.termin = termin; //konstruktor, ki prejme datum in ga shrani v atribut termin
    }

    /*
    Kot argument sprejme en podatek tipa LocalDate.
    Primer:
        new Termin(LocalDate.of(2026, 6, 15))
     */

    public LocalDate getTermin() {
        return termin; // Vrne ven datum
    }

    /*
    Spremenljivka Termin je privatna, zato rabimo javno metodo, da lahko prebere termin (GETTER).
    Vrne vrednost, ki je v objektu.
     */

    public void setTermin(LocalDate termin) {
        this.termin = termin; // Nastavi nov datum oz. vrednost
    }

    @Override // Povozimo obstoječo metodo z istim imenom iz nadrazreda
    public String toString() {
        return "Termin:" + termin;
    }
}
package sport; // Mapa, kjer se datoteka nahaja

import java.io.Serializable;
import java.time.LocalDate;
import infrastruktura.Prizorisce;

public class Sportnik implements Tekmovanje, Serializable {
    private String ime;
    private String priimek;
    private int stevilkaSportnika;
    private LocalDate datumRojstva;
    private SportnaPanoga sportnaPanoga; //enum

    private Tekma[] seznamLastnihTekem = new Tekma[5]; // največ 5 tekem

    //prazen konstruktor za objekt brez podatkov
    private Sportnik() {
    }

    public Sportnik(String ime, String priimek) {
        this(ime, priimek, 0, null);
    }

    public Sportnik(String ime, String priimek, int stevilkaSportnika, LocalDate datumRojstva) {
        //shrani objekte
        this.ime = ime;
        this.priimek = priimek;
        this.stevilkaSportnika = stevilkaSportnika;
        this.datumRojstva = datumRojstva;
    }

    public String getIme(){
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek(){
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public int getStevilkaSportnika(){
        return stevilkaSportnika;
    }

    public void setStevilkaSportnika(int stevilkaSportnika) {
        this.stevilkaSportnika = stevilkaSportnika;
    }

    public LocalDate getDatumRojstva(){
        return datumRojstva;
    }

    public void setDatumRojstva(LocalDate datumRojstva) {
        this.datumRojstva = datumRojstva;
    }

    public SportnaPanoga getSportnaPanoga() {
        return sportnaPanoga;
    }

    public void setSportnaPanoga(SportnaPanoga sportnaPanoga) {
        this.sportnaPanoga = sportnaPanoga;
    }

    public Tekma[] getSeznamLastnihTekem() {
        return seznamLastnihTekem;
    }

    @Override
    public void preveriVeljavnost(Prizorisce prizorisce) {
        if (prizorisce != null && prizorisce.getSeznamTekem() != null) {
            for (Tekma t : prizorisce.getSeznamTekem()) {
                if (t != null && t.sportnikObstaja(this.priimek)) {
                    dodajLastnoTekmo(t);
                }
            }
        }
    }
    /*
    Ta metoda preveri, na katerih tekmah na določenem prizorišču ta športnik dejansko sodeluje.
    Najprej varnostno preveri, če prizorišče in njegov seznam tekem sploh obstajata.
    Nato gre z zanko čez vse tekme na tem prizorišču.

    if (t != null && t.sportnikObstaja(this.priimek)) {
        dodajLastnoTekmo(t);
    }
    Metoda preveri, ali je športnik s tem priimkom prijavljen nanjo.
    Če je metoda vrnila true (športnik igra na tej tekmi), se pokliče metoda dodajLastnoTekmo(t), ki to tekmo shrani v športnikov osebni seznam.
     */

    private void dodajLastnoTekmo(Tekma tekma) {
        for (int i = 0; i < seznamLastnihTekem.length; i++) {
            if (seznamLastnihTekem[i] == tekma) return; // Tekma je že v seznamu
        }
        for (int i = 0; i < seznamLastnihTekem.length; i++) {
            if (seznamLastnihTekem[i] == null) {
                seznamLastnihTekem[i] = tekma;
                break;
            }
        }
    }
    /*
    Privatna metoda, ki jo kliče sam razred "Sportnik" zaradi: public void preveriVeljavnost(Prizorisce prizorisce).
    Ta metoda doda tekmo v seznam lastnih tekem športnika, če ta tekma še ni v seznamu.
    Najprej gre čez celotno tabelo svojih tekem. Če tekma obstaja se naredi return; - preprečimo podvajanje.

    Če tekma še ni v seznamu, se izvede ta druga zanka.
    Tabela z velikostjo 5 ob ustvarjanju vsebuje null.
    Zanka gre od začetka do konca tabele in išče prvo prazno mesto (if (seznamLastnihTekem[i] == null)).

    Ko najde prazno mesto, na ta indeks i zapiše tekmo in obvezno kliče break;.
    Če ne bi bilo break-a, bi zanka tekla naprej in isto tekmo zapisala na vsa preostala prazna mesta v tabeli do konca.
     */

    @Override
    public String toString(){
        return "Sportnik:" + ime + "," + priimek + "," + stevilkaSportnika + "," + datumRojstva + "," + sportnaPanoga;
    }
}
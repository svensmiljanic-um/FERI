package sport; // Mapa, kjer se datoteka nahaja

import infrastruktura.Prizorisce;
import sport.Sportnik;

public class Tekma extends Dogodek implements Tekmovanje {
    /*
    extends Dogodek - razred "Tekma" deduje vse lastnosti nadrazreda "Dogodek"
    implements Tekmovanje - razred implementira vmesnik (interface) "Tekmovanje", kar pomeni, da mora zagotoviti implementacijo vseh metod, ki jih ta vmesnik zahteva (v tem primeru preveriVeljavnost).
     */

    public Tekma (String naziv, Termin termin) {
        super(naziv, termin);
    }

    public boolean lahkoTekmuje(Sportnik sportnik) {
        if(sportnik.getDatumRojstva() == null) return false;
        if (getTermin() == null || getTermin().getTermin() == null) return false;
        /*
        Preveri, ali manjkajo podatki.
        Če športnik nima datuma rojstva ali če tekma nima določenega termina, vrne false.
         */

        int letoTekme = getTermin().getTermin().getYear(); //dobimo samo leto tekme
        int letoRojstva = sportnik.getDatumRojstva().getYear(); //dobimo samo leto rojstva
        int starost = letoTekme - letoRojstva; //odštejemo letnice med sabo

        return starost >= 14 && starost <= 18; //vrne true, če so med vključno 14 in 18 letom, sicer false
    }

    public void dodajSportnikaNaTekmo(Sportnik sportnik) throws DodajanjeSportnikaException {
        if (!lahkoTekmuje(sportnik)) {
            throw new DodajanjeSportnikaException();
        }
        seznamSportnikov.add(sportnik);
    }
    /*
    Metoda za dodajanje športnika s preverjanjem pogojev
    throws DodajanjeSportnikaException - metoda lahko povzroči napako oz. izjemo
    Primer:
        try {
            tekma.dodajSportnikaNaTekmo(sportnik1);
            tekma.dodajSportnikaNaTekmo(sportnik2);
            tekma2.dodajSportnikaNaTekmo(sportnik2);
        } catch (DodajanjeSportnikaException e) {
            System.out.println("Napaka:" + e.getMessage());
        }
     */

    // Odstranjevanje športnika z uporabo vgrajene metode ArrayList-a
    public void odstraniSportnikaSTekme(Sportnik sportnik){
        seznamSportnikov.remove(sportnik); // Odstrani točno določen objekt
    }

    // Odstranjevanje športnika po njegovi številki
    public boolean odstraniSportnikaSTekme(int stevilkaSportnika){
        for (int i = 0; i < seznamSportnikov.size(); i++) { // Uporabimo .size() namesto .length
            if (seznamSportnikov.get(i).getStevilkaSportnika() == stevilkaSportnika) {
                seznamSportnikov.remove(i); // Odstrani na indeksu i
                return true;
            }
        }
        return false;
    }
    /*
    .remove() - poišče in izbriše ta točen objekt iz seznama
    .get() - prebere športnika na tistem indeksu, preveri številko in če se ujema, izbriše element - vrne true
     */

    public int vrniSteviloSportnikovNaTekmi(){
        return seznamSportnikov.size(); // Vrne število elementov v listi
    }

    public boolean sportnikObstaja(String priimek){
        for (Sportnik s : seznamSportnikov) {
            if (s != null && s.getPriimek().equals(priimek)) return true;
        }
        return false;
    }
    /*
    Z zanko for-each gremo čez vse športnike
    .equals() - primerjamo 2 niza
     */

    @Override
    public void preveriVeljavnost(Prizorisce prizorisce) {
        boolean dodana = false;
        if (prizorisce != null && prizorisce.getSeznamTekem() != null) {
            for (Tekma t : prizorisce.getSeznamTekem()) {
                if (t != null && t.equals(this)) {
                    dodana = true;
                    break;
                }
            }
        }

        if (dodana) {
            System.out.println("Tekma " + this.getNaziv() + " se lahko izvede");
        } else {
            System.out.println("Tekma " + this.getNaziv() + " ni bila dodana na prizorisce.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Tekma: " + getNaziv());

        // Preverjanje praznosti liste
        if (seznamSportnikov != null && !seznamSportnikov.isEmpty()) {
            sb.append(" | Tekma: ");
            for (Sportnik s : seznamSportnikov) {
                if (s != null) {
                    sb.append(s.getIme()).append(" ").append(s.getPriimek()).append(", ");
                }
                /*
                Znotraj zanke preverimo, ali ta konkretna tekma slučajno ni null.
                Če obstaja, dodamo tekmo v izpis.
                Če je null, ga preskočimo, da ne dobimo napake.
                Vejica se doda na koncu!!!
                 */
            }
            if (sb.toString().endsWith(", ")) {
                sb.setLength(sb.length() - 2);
            }
            /*
            .endWith(", ") - Preverimo, če se to besedilo konča z odvečno vejico in presledkom.
            .setLength() - Odrežemo zadnja dva znaka
             */
        }

        return sb.toString();
        /*
        .endWith(", ") - Preverimo, če se to besedilo konča z odvečno vejico in presledkom.
        .setLength() - Odrežemo zadnja dva znaka
         */
    }
}
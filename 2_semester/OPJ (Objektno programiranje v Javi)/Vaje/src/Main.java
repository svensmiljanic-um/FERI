import infrastruktura.*;
import java.time.LocalDate;
import java.util.Arrays;
import sport.*;

public class Main {
    public static void main(String[] args) {
        Termin termin = new Termin(LocalDate.of(2026, 6, 15));
        System.out.println(termin);

        Termin termin2 = new Termin(LocalDate.of(2012, 6, 21));
        System.out.println(termin2);

        // Ustvarjanje sportnika
        //Sportnik sportnik1 = new Sportnik("Janez", "Novak"); Privatni konstruktor
        Sportnik sportnik1 = new Sportnik("Janez", "Novak", 10, LocalDate.of(2011, 3, 21));
        sportnik1.setSportnaPanoga(SportnaPanoga.ODBOJKA);
        System.out.println(sportnik1);

        //Ustvarjanje sportnika 2
        // Sportnik sportnik2 = new Sportnik(); Privatni konstruktor
        Sportnik sportnik2 = new Sportnik("Marija", "Hribar", 66, LocalDate.of(1998, 5, 1));
        System.out.println(sportnik2);


        // Ustvarjanje tekme
        //Tekma tekma1 = new Tekma(); // Ker ni privzetega konstruktorja v razredu Tekma, ne moremo ustvariti objekta brez argumentov.
        Tekma tekma = new Tekma("Rokomet", termin);
        System.out.println(tekma);

        Tekma tekma2 = new Tekma("Kosarka", termin2);
        System.out.println(tekma2);

        Tekma tekma3 = new Tekma("Finale pokala", termin);
        System.out.println(tekma3);

        //Lahko tekmuje
        System.out.println("Lahko tekmuje na tekmi 1:" + tekma.lahkoTekmuje(sportnik1));
        System.out.println("Lahko tekmuje na tekmi 1:" + tekma.lahkoTekmuje(sportnik2));

        System.out.println("Lahko tekmuje na tekmi 2:" + tekma2.lahkoTekmuje(sportnik1));
        System.out.println("Lahko tekmuje na tekmi 2:" + tekma2.lahkoTekmuje(sportnik2));

        // Naloga 2 -------------------------------
        // Dodajanje sportnikov na tekmo
        try {
            tekma.dodajSportnikaNaTekmo(sportnik1);
            tekma.dodajSportnikaNaTekmo(sportnik2);
            tekma2.dodajSportnikaNaTekmo(sportnik2);
        } catch (DodajanjeSportnikaException e) {
            System.out.println("Napaka:" + e.getMessage());
        }

        // Ustvarjanje prizorisc
        Dvorana dvorana = new Dvorana("Dvorana Center", "012345678", 5, true);
        dvorana.setSportnaPanoga(SportnaPanoga.ODBOJKA);
        Stadion stadion = new Stadion("Stadion Arena", "098765432", 3);
        stadion.setSportnaPanoga(SportnaPanoga.ATLETIKA);

        // Dodajanje tekem na prizorisca
        try {
            dvorana.dodajTekmo(tekma);
            dvorana.dodajTekmo(tekma2);
            stadion.dodajTekmo(tekma3);
            stadion.dodajTekmo(tekma2);
        } catch (DodajanjeTekmeException e) {
            System.out.println("Napaka:" + e.getMessage());
        }
        System.out.println("Dvorana");
        System.out.println(dvorana.vrniZasedenost());
        System.out.println("Stadion");
        System.out.println(stadion.vrniZasedenost());

        // Preverjanje veljavnosti tekem in športnikov
        tekma.preveriVeljavnost(dvorana);
        tekma2.preveriVeljavnost(stadion);
        tekma3.preveriVeljavnost(stadion);
        sportnik1.preveriVeljavnost(dvorana);
        sportnik2.preveriVeljavnost(stadion);

        // Preverjanje lastnih tekem športnikov
        System.out.println("Sportnik 1 lastne tekme: ");
        for (Tekma t : sportnik1.getSeznamLastnihTekem()) {
            if (t != null) {
                System.out.println(t);
            }
        }

        System.out.println("Sportnik 2 lastne tekme: ");
        for (Tekma t : sportnik2.getSeznamLastnihTekem()) {
            if (t != null) {
                System.out.println(t);
            }
        }

        //Naloga 8
        PlezalnaSmer[] smeri = new PlezalnaSmer[11];
        for(int i = 0; i < 11; i++) {
            smeri[i] = new PlezalnaSmer("S" + (i+1), "Smer " + (i+1), 6);
        }

        PlezalniCenter center = new PlezalniCenter("Maribor", "041111111", 10, smeri);

        Tekmovalec[] vsiTekmovalci = new Tekmovalec[4];
        Thread[] niti = new Thread[4];

        for (int i = 0; i < 4; i++) {
            vsiTekmovalci[i] = new Tekmovalec("Ime" + (i+1), "Priimek" + (i+1), i+1, center);
            niti[i] = new Thread(vsiTekmovalci[i]);
            niti[i].start();
        }

        // Počakamo, da vsi končajo
        for (Thread t : niti) {
            try { t.join(); } catch (InterruptedException e) {}
        }

        int max = 0;
        for (Tekmovalec t : vsiTekmovalci) {
            if (t.getPreplezaneSmeri() > max) max = t.getPreplezaneSmeri();
        }

        System.out.println("Zmagovalec je preplezal " + max + " smeri.");
        System.out.print("Zmagovalec: ");
        for (Tekmovalec t : vsiTekmovalci) {
            if (t.getPreplezaneSmeri() == max) {
                System.out.print(t.getStevilkaTekmovalca() + " ");
            }
        }
    }
}

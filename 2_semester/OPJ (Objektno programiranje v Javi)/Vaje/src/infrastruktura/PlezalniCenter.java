package infrastruktura; // Mapa, kjer se datoteka nahaja

public class PlezalniCenter extends Dvorana {
    private PlezalnaSmer[] smeri; // Plezalni center mora vsebovati celoten seznam smeri, ki so na voljo na njegovih stenah.
    private int stevecSmeri = 0;

    public PlezalniCenter(String ime, String telefon, int kapacitetaTekem, PlezalnaSmer[] smeri) {
        super(ime, telefon, kapacitetaTekem, true); // true - vsak plezalni center samodejno omogoča večerne tekme
        this.smeri = smeri;
    }

    public PlezalnaSmer pripraviTekmovalnoSmer() {
        /* Ta metoda služi temu, da med tekmovanjem tekmovalcem zaporedoma dodeljuje plezalne smeri, eno po eno.
        Sinhroniziran blok zagotavlja, da samo ena nit dostopa do števca hkrati.

        synchronized (this) - "zaklene" celoten objekt PlezalniCenter, kar pomeni, da samo ena nit lahko izvaja kodo znotraj tega bloka naenkrat.
        To preprečuje, da bi več tekmovalcev hkrati dostopalo do števca in dodeljevalo iste smeri.
        */
        synchronized (this) {
            if (stevecSmeri < smeri.length) {
                PlezalnaSmer izbrana = smeri[stevecSmeri];
                stevecSmeri++;
                return izbrana; // Začasno jo shrani v spremenljivko izbrana, da jo lahko vrne po povečanju števca.
            }
            /*
            smeri.length - koliko smeri imamo skupaj.
            Dokler je števec manjši od tega števila, imamo še vedno na voljo neuporabljene smeri.
             */

            return null; // Smeri je zmanjkalo - ni več na voljo nobene proste plezalne smeri
        }
    }
}
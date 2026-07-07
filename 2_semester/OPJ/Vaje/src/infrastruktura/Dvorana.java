package infrastruktura; // Mapa, kjer se datoteka nahaja

public class Dvorana extends Prizorisce {
    /*
    Razred "Dvorana" deduje od razreda "Prizorisce".
    Podedovane lastnosti: ime, telefon, seznamTekem, kapacitetaTekem
     */

    private boolean vecerneTekme;
    private boolean imaKlimo;

    public Dvorana (String ime, String telefon, int kapacitetaTekem, boolean vecerneTekme) {
        super(ime, telefon, kapacitetaTekem);
        this.vecerneTekme = vecerneTekme;
    }

    @Override
    public double vrniKapaciteto() {
        double baza = seznamTekem.length;
        return vecerneTekme ? baza * 1.2 : baza;
    }
    /*
    ? : - namesto if-stavka
    vecerneTekme enako true?
    DA - poveča kapaciteta za 20%
    NE - vrne samo kapaciteto brez povečanja
     */

    @Override
    public String toString() {
        return super.toString() + "," + vecerneTekme;
    }
}

package infrastruktura; // Mapa, kjer se datoteka nahaja

public class Stadion extends Prizorisce {
    public Stadion(String ime, String telefon, int kapacitetaTekem) {
        super(ime, telefon, kapacitetaTekem);
    }

    @Override
    public double vrniKapaciteto() {
        return (double) seznamTekem.length;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
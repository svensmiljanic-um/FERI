public class BancniRacun extends java.lang.Object {

    private String lastnik;
    private int stanje;
    static int stRacunov;

    public BancniRacun() {
       this("Mafijoza", 20000000);
    }

    public BancniRacun(String lastnik) {
       this(lastnik, 10);
    }

    public BancniRacun(int zacStanje) {
       this("Anonimnez", zacStanje);
    }

    public BancniRacun(String ime, int stanje) {
       lastnik = ime;
       this.stanje = stanje;
       stRacunov++;
    }



    public void dvig(int kolko) {
       stanje -= kolko;
    }

    public void polog(int znesek) {
        stanje += znesek;
    }

    public int vrniStanje() {
       return stanje;
    }

    @Override
    public String toString () {
        return "Sem bancni racun, lastnikx: " + lastnik + ", stanje: "+this.vrniStanje() + " vseh racunov "+ stRacunov;
    }

} 


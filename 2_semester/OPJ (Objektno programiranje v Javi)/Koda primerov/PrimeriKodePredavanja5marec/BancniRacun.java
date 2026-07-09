/**
        nas poslovni razred Bancni Racun
        @author M. Hericko
        @version 1.5

*/
public abstract class BancniRacun extends java.lang.Object {

//    abstract void metoda();


    private String lastnik;
    protected int stanje;
    protected static int stRacunov;    // razredni atribut - ena sama vrednost, skupna za vse objekte-instance 

     
    protected String getLastnik() {
        return lastnik;
    }


    /**
        dostop do stevila doslej kreiranih racunov
        @return stevilo doslej odprtih racunov
    */
    public static int vrniStRacunov() {
    //   System.out.println(stanje);   ne moremo v static dostopat do nestatic znotraj tega razreda
    //       dvig(200);                ne do instancnih podatkov, ne metod
       return stRacunov;
    }

    /**
         najbolj univerzalni konstruktor
         po potrebi obvesti o sumljivih transakcijah DURS
         @param ime komitent lastnik racuna
         @param stanje polog ob odpiranju racuna
    */
    public BancniRacun(String ime, int stanje) {
       lastnik = ime;
       if (stanje >=5000)
          System.out.println("Obvestim FURS, da je "+lastnik + " polozil na racun  " + stanje);
       this.stanje = stanje;
       stRacunov++;
    }

  /**
       odpiranje racuna brez pologa
       poklonimo 10 eur
       @param lastnik komitent
  */
    public BancniRacun(String lastnik) {
       this(lastnik, 10);
    }

  /**
       odpiranje anonimnega racuna  
       @param zacStanje polog ob odpiranju racuna
    */
      public BancniRacun(int zacStanje) {
       this("Anonimnez", zacStanje);
    }


    /**
         dvig denarja z BR brez omejitve
         @param kolko znesek dviga
    */ 
    public void dvig(int kolko) {
       stanje -= kolko;
    }

   /**
        polog sredstev na racun brez kontrole
        @param znesek  sredstva, ki se polagakjo na racun
   */
    public void polog(int znesek) {
        stanje += znesek;
    }

   /**
        izracuna aktualno stanje
        @return aktualno stanje
   */
    public int vrniStanje() {
       return stanje;
    }

    /**
         @return niz z osnovnimi podatki o racunu, tudi aktualno stanje ter stevilo vseh kreiranih racunov
    */
    @Override
    public String toString () {
        return "Sem bancni racun, lastnikx: " + lastnik + ", stanje: "+this.vrniStanje() + " vseh racunov "+             stRacunov;
    }

}  // BancniRacun 


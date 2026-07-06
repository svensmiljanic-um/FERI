package vmesniki;
import java.time.LocalDate;

public class BancniRacun extends Object {

     private String lastnik;
     protected int stanje;
     private LocalDate datumOdprtja;
     static int stVsehRacunov;
     private int stRacuna;

     static {
        stVsehRacunov = 100000;
     }

//     public BancniRacun() {}

     public BancniRacun(String lastnik) {
       this(lastnik, 0);
     } 

     public BancniRacun(int stanje) {
        this("Anonimnez",stanje);
     }

     private void obvestiFURS() {
           System.out.println(" Sumljiva transkacija");
     }
 
     public BancniRacun(String lastnik, int stanje) {

          this.lastnik = lastnik;
          this.stanje = stanje;
       
          if (stanje > 10000)
             obvestiFURS(); 

          datumOdprtja = LocalDate.now(); 

          stRacuna = ++stVsehRacunov;     
      }


     public void dvig(final int koliko) {
 
        stanje -=koliko;
        if (koliko>=10000)
           obvestiFURS();
     }    

     public void polog(int znesek) {
         stanje += znesek;
     }

     public int vrniStanje() {
         return stanje;
     }
     
     public static int vrniSteviloVseh() {
           return stVsehRacunov;
     }

     @Override
     public String toString() {

          return "Sem "+ getClass() + this.lastnik + " ima na racunu st. "+this.stRacuna + ": " + this.vrniStanje();
     }     

}
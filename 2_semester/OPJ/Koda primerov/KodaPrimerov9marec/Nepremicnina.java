import si.mhi.bancni.*;

public class Nepremicnina implements INalozba {

   private String naziv;
   private int nabavnaCena;
   private int trznaCena;
   

   public Nepremicnina(String katera, int nabavnaCena) {
        naziv = katera;
        this.nabavnaCena = nabavnaCena;
        trznaCena = 2 * nabavnaCena;
   }

   public String vrniTveganje(){ return "Visoko tveganje";}
   public double vrniDonostnost(){ return trznaCena*100/nabavnaCena;}

   public String vrniNaslov() {return "Vila v Kamnici";}

}
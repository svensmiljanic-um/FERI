package vmesniki;
import java.io.*;

public class Nepremicnina implements INalozba, INagajiv, Serializable, IPrazen {

     private String ime;
     private double nabavna;
     private double aktualna;
    
    public Nepremicnina(String ime, double nabavna) {
           this.ime = ime;
           this. nabavna = nabavna;
           aktualna = 2* nabavna;
       }

    public double vrniDonosnost() {
         return 100 * (aktualna-nabavna)/nabavna;
    }

   public void izpisiLokacijo() {
          System.out.println(" sem " + ime);
    }
   
   @Override
   public NivoTveganja vrniTveganje() {
	 return NivoTveganja.SREDNJE;
}

@Override
public double vrniTrenutnoVrednost() {
	return aktualna;
}

@Override
public void hecajMe() {
	System.out.println("zgeckaj me");
}
   
} 
package vmesniki;
import java.time.LocalDate;

public class VarcevalniRacun extends BancniRacun implements INalozba {

     private LocalDate datumPoteka;
     private boolean vezavaPotekla;
     private int obrestnaMera; 
     private ObdobjeVezave casVezave;

    
    

     public VarcevalniRacun(String lastnik, int stanje,ObdobjeVezave obdobje) {
          super(lastnik, stanje);
        
           casVezave = obdobje; 
           vezavaPotekla = false;

          LocalDate danes = LocalDate.now();

          datumPoteka = danes;
          switch (obdobje) {
               case MESECNA:  datumPoteka = danes.plusMonths(1);
                              obrestnaMera = 1;
			      break;
               case TROMESECNA:
                             datumPoteka=danes.plusMonths(3);
                             obrestnaMera = 2;
				break;
               case LETNA:   datumPoteka=danes.plusYears(1);
                             obrestnaMera = 3;
                             break;
          }
         
    
     
      }

    
     public void dvig() {
         if (vezavaPotekla) {
           pripisObresti();
           int celotenZnesek;
           this.dvig(celotenZnesek=vrniStanje());  // dvig celotnega zneska
           System.out.println("Izplacam:" + celotenZnesek);
         }
         else
            System.out.println("Oprosti, prides lahko sele " + datumPoteka);
     } 

     @Override
     public void dvig(int koliko) {
          System.out.println("Zal delni dvigi niso dovoljeni, ali zelis prekiniti varcevanje?");   
     }    


     private void pripisObresti() {
         int obresti = vrniStanje()*obrestnaMera/100;
         this.polog(obresti);
     }

     public void potece() {
         vezavaPotekla = true;
         System.out.println("  vezava potekla ");
     }

	@Override
	public NivoTveganja vrniTveganje() {
		return NivoTveganja.NIZKO;
	}


	 public double vrniDonosnost() {
         return obrestnaMera;
     }


	@Override
	public double vrniTrenutnoVrednost() {
		return vrniStanje();
	}

} 

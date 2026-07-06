public class TransakcijskiRacun extends BancniRacun  {

    private int dovoljeniMinus;

    public TransakcijskiRacun(String ime, int zac, int dovoljeniMinus){
 
     super(ime, zac);
     this.dovoljeniMinus = dovoljeniMinus;  
  

    }


    public void postaviMinus(int noviMinus) {
       dovoljeniMinus = noviMinus;
    }

     @Override
     public void dvig(int mujcek) {
         if (mujcek > (vrniStanje()-dovoljeniMinus))
            System.out.println("Sorchi + na voljo le " + (vrniStanje()-dovoljeniMinus) + "zelis pa " + mujcek);
         else
            stanje = stanje - mujcek;
     }
 

} 


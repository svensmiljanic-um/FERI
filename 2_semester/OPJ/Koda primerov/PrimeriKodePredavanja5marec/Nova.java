import java.io.*;

class Nova {


     public static void main(String[] args) {


/*
         TransakcijskiRacun x = new TransakcijskiRacun("Marjan",10000,-500);
          x.postaviMinus(-500);
          x.dvig(20000);
          x.dvig(10499);
          x.polog(111);
          PrintStream izhod = System.out;
          izhod.println(x.toString());         





      VarcevalniRacun letni = new VarcevalniRacun("Miha Letni ",50000,ObdobjeVezave.LETNA);
 
      VarcevalniRacun zaTeslo = new VarcevalniRacun("Janez Mesec",70000,ObdobjeVezave.MESECNA);    

      VarcevalniRacun pol = new VarcevalniRacun("Fonza Polletnik",10000,ObdobjeVezave.POLLETNA);

       

      letni.dvig(10000);
      pol.dvig();
      letni.dvig();

 
 

      System.out.println(letni);
      System.out.println(pol);
      System.out.println(zaTeslo);

     BancniRacun.stRacunov = 10000;
     TransakcijskiRacun.stRacunov = 20000;
     VarcevalniRacun.stRacunov = 30000;   

      System.out.println(VarcevalniRacun.vrniStRacunov() ==BancniRacun.vrniStRacunov()); 	
      System.out.println(TransakcijskiRacun.vrniStRacunov() ==BancniRacun.vrniStRacunov());
      System.out.println(VarcevalniRacun.vrniStRacunov() ==TransakcijskiRacun.vrniStRacunov());
*/

         Object xx = null;
         BancniRacun karNeki = null;

         if (args.length ==0)
            karNeki = new TransakcijskiRacun("Marjan",10000,-1000);
         else
            karNeki = new VarcevalniRacun("Metka Lepa",10000,ObdobjeVezave.LETNA);
         karNeki.toString();
         karNeki.dvig(1000);
         System.out.println(karNeki);
         
  
         VarcevalniRacun vr;
         if (karNeki instanceof VarcevalniRacun) {
            vr = (VarcevalniRacun)karNeki;
            vr.dvig();
         } 

     }



}
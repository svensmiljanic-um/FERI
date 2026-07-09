class Nova {


     public static void main(String[] args) {

   /*       TransakcijskiRacun x = new TransakcijskiRacun("Marjan",10000,-500);
          x.postaviMinus(-500);
          x.dvig(20000);
          x.dvig(10499);
          x.polog(111);
          System.out.println(x.vrniStanje());         
*/


      VarcevalniRacun letni = new VarcevalniRacun("Letni",50000,ObdobjeVezave.LETNA);
 
      VarcevalniRacun zaTeslo = new VarcevalniRacun("mesecni",70000,ObdobjeVezave.MESECNA);    

      VarcevalniRacun pol = new VarcevalniRacun("polletni",10000,ObdobjeVezave.POLLETNA);

      letni.dvig(10000);
      pol.dvig();
      letni.dvig();

     }



}
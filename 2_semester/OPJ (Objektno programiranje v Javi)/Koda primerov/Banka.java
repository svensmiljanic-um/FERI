import java.awt.Button;

public class Banka {


    public static void main(String[] args) {

      

        System.out.println(" main Banke");
   
 //       System.out.println(BancniRacun.vrniStRacunov());
       
        System.out.println(" pred uporabo Bancnega racuna");
       
  
        BancniRacun moj;
       
       System.out.println(" po deklaraciji spremenljivke moj, ki predstavlja BancniRacun");
      
        moj = new BancniRacun("Marjan",1000);

        moj.dvig(500);
        moj.dvig(300);
        moj.polog(645);

 //    Frame okno = new Frame(); okno.add(new Button("Gumbek")); //sami nimamo reference za gumb, jo pa ima okno

 //       BancniRacun don = new BancniRacun();

        BancniRacun crniFond = new BancniRacun(10000);     
        BancniRacun prazen = new BancniRacun("Revez");
        prazen.polog(5);

        BancniRacun metkin = new BancniRacun("Metka",1000);

     //   metkin = moj;        
        metkin.polog(2000);


        BancniRacun neka = moj;

        neka.dvig(100);

     // DO PRIVATE nimamo dostopa   moj.stanje = 1000000;        

        System.out.println(BancniRacun.vrniStRacunov());
        System.out.println(moj.toString());
        System.out.println(metkin.vrniStanje());
   //     System.out.println(don);
        System.out.println(crniFond);       
        System.out.println(prazen);

       System.out.println(BancniRacun.vrniStRacunov());
 

       System.out.println(moj.getClass());
       moj.hashCode();

       Object nekaj;

       nekaj = moj;

    //   nekaj = new Button(" Knof GUI");    
    //  nekaj.dvig(200);   uporabljam lahko le to, kar je definirano v java.lang.Object
      

       System.out.println(nekaj.toString());
       System.out.println(nekaj.getClass());
       System.out.println(nekaj.hashCode());
      
        


    }


}
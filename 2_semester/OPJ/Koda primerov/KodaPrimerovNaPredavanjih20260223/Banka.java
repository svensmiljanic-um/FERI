public class Banka {


    public static void main(String[] args) {


        System.out.println(" main Banke");
  
        BancniRacun moj;
        moj = new BancniRacun("Marjan",1000);

        moj.dvig(500);
        moj.dvig(300);
        moj.polog(645);

  System.out.println(moj);

        new BancniRacun();
      new BancniRacun();     
 new BancniRacun(); 
     new BancniRacun();

        BancniRacun metkin = new BancniRacun("Metka",1000);

     //   metkin = moj;
        metkin.polog(2000);


        BancniRacun neka = moj;

        neka.dvig(100);

     // NE GRE DO PRIVATE   moj.stanje = 1000000;        

        BancniRacun.stRacunov = -1111;
        System.out.println(moj);
        System.out.println(metkin);

    }


}
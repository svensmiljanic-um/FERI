import si.mhi.bancni.*;

class Posrednik {

    public static void main(String[] args) {

        INalozba x;
        
        Nepremicnina hiska = new Nepremicnina("Vila",400000);

        System.out.println(hiska.vrniNaslov());
        
        if (args.length==0)
           x = hiska;
        else        
           x = new VarcevalniRacun("Marjan",10000, ObdobjeVezave.LETNA);

   //     x.vrniNaslov();


        System.out.println(x.vrniDonostnost());
        System.out.println(x.vrniTveganje());


    } 


}
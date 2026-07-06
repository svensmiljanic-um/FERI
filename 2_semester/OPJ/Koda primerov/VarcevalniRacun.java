import java.time.LocalDate;


public class VarcevalniRacun extends BancniRacun {

    private ObdobjeVezave doba;
    private boolean vezavaPotekla;
    private LocalDate datumVezave;
    private LocalDate datumPoteka;

    public VarcevalniRacun(String ime, int polog, ObdobjeVezave doba ) {
        super(ime, polog);
        this.doba = doba;
        datumVezave = LocalDate.now();
        vezavaPotekla = true; 

        switch (doba) {
              case MESECNA:
                      datumPoteka=datumVezave.plusDays(31);
                      System.out.println(datumPoteka);
                      break;
              case ObdobjeVezave.POLLETNA:
                      System.out.println(datumPoteka=datumVezave.plusMonths(6));
          
                 break;
              case LETNA:
                      System.out.println(datumPoteka=LocalDate.now().plusMonths(1));
              
        }
        

    }

   
    public void dvig() {
       if (vezavaPotekla) {
          pripisiObresti();
          System.out.println(" Hvala za sodelovanje , izplacilo: " + vrniStanje());
          super.dvig(vrniStanje()); // super za uporabo metode iz nadrazreda, ki smo jo v tem razredu spodaj predefinirali
       }  else
            System.out.println(" Ni se "+datumPoteka);     
    }

    @Override
    public void dvig(int koliko) {
        System.out.println(" Pardon, delni dvigi niso dovoljeni - zelis prekiniti vezavo?");
    }


    private void pripisiObresti() {
          
    }

}
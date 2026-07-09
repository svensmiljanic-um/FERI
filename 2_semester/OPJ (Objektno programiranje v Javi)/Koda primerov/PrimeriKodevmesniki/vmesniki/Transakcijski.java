package vmesniki;
public class Transakcijski extends BancniRacun {

    private int dovoljeniMinus;

    public Transakcijski(String ime, int polog, int minus) {
          
      super(ime,polog);
      dovoljeniMinus = minus;
 
    }

    @Override
    public void dvig(int znesek) {
        if ((vrniStanje()-znesek)> dovoljeniMinus)
           super.dvig(znesek);
        else
          System.out.println(" Prevec hoces ");
    }

    public void podvojiMinus() {
          dovoljeniMinus = 2 * dovoljeniMinus;
    }

}
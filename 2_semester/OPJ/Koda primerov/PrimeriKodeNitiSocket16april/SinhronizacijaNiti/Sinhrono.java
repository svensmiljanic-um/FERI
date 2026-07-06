package SinhronizacijaNiti;

class Proizvajalec extends Thread {
	

  private Skupna skupna;
  private int stevilka;

  public Proizvajalec (Skupna s) {
    skupna = s;  
  }

  public void run () {
    for (int i=0; i<10; i++)  {
      skupna.put(i);
      System.out.println("Proizvajalec st. "+stevilka+ " vstavil " +i);
      try {
        sleep ((int)Math.random()*100);
      } catch (InterruptedException e) {}   
    }  
  }
}

class Porabnik extends Thread {

  private Skupna skupna;
 
  public Porabnik (Skupna s) {
    skupna = s;
  }

  public void run () {
    int vrednost;
    for (int i=0; i<10; i++)  {
      vrednost = skupna.get();
      System.out.println("Porabnik je pridobil " + vrednost);
    }
  }
}

public class Sinhrono {

  public static void main (String[] args) {

    Skupna deljena = new Skupna();
    new Proizvajalec (deljena).start();
    new Porabnik (deljena).start();
  }
}
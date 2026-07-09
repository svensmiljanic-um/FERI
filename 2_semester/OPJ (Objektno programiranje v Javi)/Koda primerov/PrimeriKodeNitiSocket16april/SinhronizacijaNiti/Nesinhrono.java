package SinhronizacijaNiti;

class Proizvajalec1 extends Thread {

  private Skupna1 skupna;

  public Proizvajalec1 (Skupna1 s) {
    skupna = s;
  }

  public void run () {
    for (int i=0; i<10; i++)  {
      skupna.put(i);
     System.out.println("Proizvajalec vstavil " +i);
      try {
          sleep ((int)Math.random()*100);    
    	   } 
    	   catch (InterruptedException e) {}   
    }  
  }
  
}

class Porabnik1 extends Thread {

  private Skupna1 skupna;

  public Porabnik1 (Skupna1 s) {
    skupna = s;
  }

  public void run () {
    for (int i=0; i<10; i++)  {
          System.out.println("Porabnik je pridobil " +skupna.get());
    }
  }
}


public class Nesinhrono {
	public static void main(String[] args) {
		 	Skupna1 deljena = new Skupna1();
		    new Proizvajalec1 (deljena).start();
		    new Porabnik1 (deljena).start();	
	}
	
}

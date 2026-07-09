package SinhronizacijaNiti;

public class Skupna {
  private int vsebina;
  private boolean available = false;

  public synchronized int get() {
   while (available == false) {
      try {
        wait();
      } catch (InterruptedException e){} 
    }
    available = false;
    System.out.println("get "+vsebina);
    notify();
    return vsebina;
  }

  public synchronized void put (int vrednost) {
    while (available == true) {
      try {
          wait();
      } catch (InterruptedException e){} 
    }
    
    vsebina = vrednost;
    available=true;
    System.out.println("put "+vrednost);
   notify();
  }
}
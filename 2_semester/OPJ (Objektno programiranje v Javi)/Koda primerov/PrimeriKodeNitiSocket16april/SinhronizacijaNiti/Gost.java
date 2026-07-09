package SinhronizacijaNiti;

public class Gost extends Thread {

	MizicaObOknu miza;
	
	public Gost(MizicaObOknu miza) {
       this.miza = miza;
	}
	
	@Override
	public void run() {
	
		String jed;
		
		do  {
			jed = miza.getKroznik();
		    System.out.println("Pojedel:" + jed);
		    try {
				sleep((int)Math.random()*100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (!jed.equals("(Sladica)")); 
	}
}

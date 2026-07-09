package SinhronizacijaNiti;

public class Natakar extends Thread {

	String[] vecerja = {"(Hladna predjed)", "(Topla predjed)", "(Glavna jed)","(Sladica)", };
	MizicaObOknu mizica;
	
	
	Natakar(MizicaObOknu miza) {
		mizica = miza;
	}
	
	@Override
	public void run() {
		
		for (int i =0; i<vecerja.length; i++) {
			mizica.setKroznik(vecerja[i]);
			try {
				sleep((int)Math.random()*10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
}

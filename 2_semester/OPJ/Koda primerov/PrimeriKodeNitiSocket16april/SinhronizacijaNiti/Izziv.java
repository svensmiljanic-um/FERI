package SinhronizacijaNiti;

public class Izziv {

	
	
	public static void main(String[] args) {
		
		Stevec x = new Stevec();
		
		Thread prva = new Thread() {
			public void run() {
				for (int i=0;i<1000; i++)
					x.povecaj();
			};
		};
		
		Thread druga = new Thread() {
			public void run() {
				for (int i=0;i<1000; i++)
					x.povecaj();
			};
		};
		
		
		prva.start();
		druga.start();
		
		try {
			prva.join();
			druga.join();
	
			System.out.println(" ko obe zakljucita je vrednost " + x.getVrednost());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}

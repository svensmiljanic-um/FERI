package zabava;

public class Sodelavca {
	
	public static void main(String[] args) {
		
		Stevec stevec = new Stevec();
		
	Thread prva = new Thread(new Runnable() {
			
			@Override
			public void run() {
			   for (int i = 0; i<10000; i++)	
		         stevec.povecaj();		
			}
		});
		
	Thread druga = new Thread(new Runnable() {
		
		@Override
		public void run() {
		   for (int i = 0; i<10000; i++)	
	         stevec.povecaj();		
		}
	});
	
	prva.start();
	druga.start();
	
	try {
		prva.join();
		druga.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	System.out.println(" Na koncu " + stevec.vrednost);
	
	
		
	}

}

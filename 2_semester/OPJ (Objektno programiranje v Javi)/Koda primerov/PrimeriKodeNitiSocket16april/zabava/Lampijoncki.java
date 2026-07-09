package zabava;

public class Lampijoncki {

	public static void main(String[] args) {
		
		
		Student janez = new Student("Janez", 10, 1000);
		Student metka = new Student("Metka", 3, 3000);
		Abstinent marjan = new Abstinent("Marjan", "Cocta");
		new Thread(marjan).start();
		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//		          for (int i=0; i<100000000; i++) {
//		        	  System.out.println("Anonimni ga šele pije: " + i + "flašo");
//		        	if (i%100==0)
//		        	  Thread.currentThread().yield();
//		  			
//		          }
//		          }
//		}).start();
//		

		Thread natakar = new Thread() {
		
			@Override
			public void run() {
                 while (true)	{
                	 System.out.println("Natakar zbere narocila");
                	 try {
                        Thread.currentThread().sleep(3000);
					  } catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					  }  //catch
			     }  // while
                 
		   } // run
			
		};
	
	   natakar.setDaemon(true);	
       natakar.start();
		
		
		janez.start();
		metka.start();
		
//		try {
//			janez.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		janez.start();   // restart ni mozen

	
	}
	
}

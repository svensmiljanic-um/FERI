package zabava;

public class Abstinent implements Runnable {

	String kajPije;
	String ime;

	
	
	public Abstinent(String kajPije, String ime) {
		this.kajPije = kajPije;
		this.ime = ime;
	}



	@Override
	public void run() {
		

	     for (int i=1; i<= 5; i++) {
	    	 
	    	 System.out.println(ime + " pijucka "+ i + ". " + kajPije);
	    	 try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}
	    	
	     }	
   	 System.out.println(ime + " - ga nesejo domov");
   		
	
		
	}
	
	
	
	
}

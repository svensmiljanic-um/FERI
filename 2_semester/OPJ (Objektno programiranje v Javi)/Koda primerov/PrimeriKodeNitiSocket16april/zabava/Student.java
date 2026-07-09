package zabava;

public class Student extends Thread {
	
	private String ime;
	private int max;
	private int casPitja;
	
	
	public Student(String ime, int max, int casPitja) {
		this.ime = ime;
		this.max = max;
		this.casPitja = casPitja;
	}


	@Override
	public void run() {

	     for (int i=1; i<= max; i++) {
	    	 
	    	 System.out.println(ime + " pijucka "+ i + ". pivce");
	    	 try {
				Thread.currentThread().sleep(casPitja);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}
	    	
	     }	
   	 System.out.println(ime + " gre domov");
   		
	
	}
	

}

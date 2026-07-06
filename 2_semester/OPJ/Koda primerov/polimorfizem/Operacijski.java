package polimorfizem;

public class Operacijski {
	
	int sestej() {
		return 7777777;
	}
	
	
	int sestej(int st) {
		return st;
	}

	int sestej(float sts) {
		return 99999;
	}

	int sestej (int prvi, int drugi, int tretji, int... dodatni) {
		int sum =0; 
		for (int i=0; i<dodatni.length; i++)
		  sum = sum + dodatni[i];
		return sum + prvi + drugi + tretji;
		
	}
	
	int sestej(int p, float d) {
		return p+(int)d;
	}
	
	int sestej(float p, int d) {
		return (int)p+d;
	}
	

	
	public static void main(String[] args) {
		
		Operacijski o = new Operacijski();
		
		System.out.println(o.sestej(1,1,1,2,2,2,2,2,2,3,3));
		
		System.out.println(o.sestej());
		System.out.println(o.sestej(2));
		System.out.println(o.sestej((float)2.5));
		System.out.println(o.sestej(2,(float)3));
		System.out.println(o.sestej((float)4,3));
		
		
	}
	
}



package ioTokovi;

public class Kode {
	
	
	public static void main(String[] args) {
		
		System.out.println(100);
		System.out.println(0144);
		System.out.println(0x64);
		System.out.println(0b01100100);
		System.out.println((char)100);
			
		for (short koda=32; koda<=255; koda++) {
			System.out.print(koda+":" + (char)koda + " ");
			if (koda%10 == 0)
				System.out.println();
		}
		
		
	}

}

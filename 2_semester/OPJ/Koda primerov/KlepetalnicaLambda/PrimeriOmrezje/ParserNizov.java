package PrimeriOmrezje;

import java.util.StringTokenizer;

public class ParserNizov {

	public static void main(String[] args) {
		
		String janez = " Janez nima a-jev, a res";
		
		StringTokenizer st = new StringTokenizer(janez,"az");
		
		while (st.hasMoreTokens())
			System.out.println(st.nextToken());

		
		
		
	}
	
}

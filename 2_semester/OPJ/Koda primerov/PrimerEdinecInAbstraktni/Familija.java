
public class Familija {

	
	public static void main(String[] args) {
		
		Tasca prva = Tasca.vrniTasco();
		Tasca druga = Tasca.vrniTasco();
		Tasca tretja = Tasca.vrniTasco();

		System.out.println(prva==druga);
		System.out.println(tretja==druga);
			
		prva.sprejmeSopek();
		druga.sprejmeSopek();
		tretja.sprejmeSopek();
		
		
	}
}

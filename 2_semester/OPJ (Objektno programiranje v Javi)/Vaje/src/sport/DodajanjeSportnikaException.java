package sport;

public class DodajanjeSportnikaException extends Exception {
    public DodajanjeSportnikaException() {
        super("DodajanjeSportnikaException");
    }
    /*
    V main.java zapišemo:
        System.out.println("Napaka:" + e.getMessage());
     */
}

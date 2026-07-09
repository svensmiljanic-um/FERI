package vmesniki;

public interface INalozba  {

    public abstract double vrniDonosnost();
    NivoTveganja vrniTveganje();
    double vrniTrenutnoVrednost();
 
    
    //   default void prodaj() {System.out.println(" nima smisla prodajat");}
    
}
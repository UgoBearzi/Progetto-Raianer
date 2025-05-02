import java.util.concurrent.Semaphore;

public class Pista {
    Semaphore s_aereoInPista;

    public Pista(){
        this.s_aereoInPista = new Semaphore(1);
    }




}

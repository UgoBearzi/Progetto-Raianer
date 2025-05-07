import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Pista {
    Semaphore s_aereoInPista;
    ArrayList<Aereo> aereoInPista;

    public Pista(){
        this.s_aereoInPista = new Semaphore(1);
        this.aereoInPista = new ArrayList<Aereo>();
    }

    public ArrayList<Aereo> getAereoInPista() {
        return aereoInPista;
    }
    public void setAereoInPista(ArrayList<Aereo> aereoInPista) {
        this.aereoInPista = aereoInPista;
    }

    public void entraInPista(Aereo aereo){
        try{
            s_aereoInPista.acquire();
            if(getAereoInPista().size() < 1){
                getAereoInPista().add(aereo);
            }
            

        } catch (InterruptedException exc) { 
            System.out.println(exc); 
        }
    }

    public Aereo liberaPistaAtterrato(){
        Aereo aereoCheEsce = null;
        try{
            s_aereoInPista.acquire();
            if(getAereoInPista().size() > 0){
                aereoCheEsce = getAereoInPista().get(getAereoInPista().size()-1);
                getAereoInPista().remove(getAereoInPista().size()-1);
            }

        } catch (InterruptedException exc) { 
            System.out.println(exc); 
        }

        return aereoCheEsce;
    }

    public void liberaPistaDecollo(){
        if(getAereoInPista().size() > 0){
            getAereoInPista().remove(getAereoInPista().size()-1);
        }
        s_aereoInPista.release();

    }




}

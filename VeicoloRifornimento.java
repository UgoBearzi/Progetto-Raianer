import java.util.concurrent.Semaphore;

public class VeicoloRifornimento {
    public VeicoloRifornimento(){

    }

    public void fillPlane(Semaphore s_veicoloSincro, Aereo aereo){
        try{
            s_veicoloSincro.acquire();

            aereo.setSerbatoioPieno(true);

            s_veicoloSincro.release();
        } catch (InterruptedException exc) { 
            System.out.println(exc); 
        } 
    }
}

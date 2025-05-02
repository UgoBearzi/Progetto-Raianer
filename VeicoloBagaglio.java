import java.util.concurrent.Semaphore;

public class VeicoloBagaglio {
    public VeicoloBagaglio(){

    }

    public void carica(Semaphore s_veicoloSincro, Aereo aereo, int bagagli){
        try{

            s_veicoloSincro.acquire();

            if(aereo.getPesoBagagli() >= aereo.getMaxPesoBagagli()){
                aereo.setPesoBagagli(aereo.getMaxPesoBagagli());
            }else{
                aereo.setPesoBagagli(aereo.getPesoBagagli() + bagagli);
            }

            s_veicoloSincro.release();

        } catch (InterruptedException exc) { 
            System.out.println(exc); 
        } 
    }

    public void scarica(Semaphore s_veicoloSincro, Aereo aereo){
        try{

            s_veicoloSincro.acquire();

            aereo.setPesoBagagli(0);

            s_veicoloSincro.release();

        } catch (InterruptedException exc) { 
            System.out.println(exc); 
        } 
    }
}

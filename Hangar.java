import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Hangar {
    ArrayList<Aereo> aereiInHangar;
    Semaphore m_entraAereo;
    Semaphore m_esciAereo;
    Semaphore s_aereiMassimi;

    public Hangar(){
        this.aereiInHangar = new ArrayList<Aereo>();
        this.m_entraAereo = new Semaphore(1);
        this.m_esciAereo = new Semaphore(1);
        this.s_aereiMassimi = new Semaphore(5);
    }
    public Hangar(ArrayList<Aereo> aerei){
        this.aereiInHangar = aerei;
        this.m_entraAereo = new Semaphore(1);
        this.m_esciAereo = new Semaphore(1);
        this.s_aereiMassimi = new Semaphore(5);
    }

    public ArrayList<Aereo> getAereiInHangar() {
        return aereiInHangar;
    }

    public void setAereiInHangar(ArrayList<Aereo> aereiInHangar) {
        this.aereiInHangar = aereiInHangar;
    }

    public void entraHangar(Aereo aereo){
        try{
            m_entraAereo.acquire();

            s_aereiMassimi.acquire();
            if(getAereiInHangar().size() < 3){
                getAereiInHangar().add(aereo);
            }

            m_entraAereo.release();
        } catch (InterruptedException exc) { 
            System.out.println(exc); 
        }
    }

    public Aereo esciHangar(){
        Aereo aereoCheEsce = null;
        try{
            m_esciAereo.acquire();

            if(getAereiInHangar().size() > 0){
                aereoCheEsce = getAereiInHangar().get(getAereiInHangar().size()-1);
                getAereiInHangar().remove(getAereiInHangar().size() -1);
            }
            s_aereiMassimi.release();

            m_esciAereo.release();
        } catch (InterruptedException exc) { 
            System.out.println(exc); 
        }
        return aereoCheEsce;
    }


}

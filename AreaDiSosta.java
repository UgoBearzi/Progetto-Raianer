import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class AreaDiSosta {
    Semaphore s_aereiInSosta;
    Semaphore m_entraInSosta;
    Semaphore m_esciDaSosta;
    Semaphore m_veicoloSincro;
    ArrayList<Aereo> aereiInSosta;

    VeicoloBagaglio veicoloBagaglio;
    VeicoloRifornimento veicoloRifornimento;

    public AreaDiSosta(VeicoloBagaglio veicoloBagaglio, VeicoloRifornimento veicoloRifornimento){
        this.s_aereiInSosta = new Semaphore(3);
        this.m_entraInSosta = new Semaphore(1);
        this.m_esciDaSosta = new Semaphore(1);
        this.m_veicoloSincro = new Semaphore(1);
        this.aereiInSosta = new ArrayList<Aereo>();

        this.veicoloBagaglio = veicoloBagaglio;
        this.veicoloRifornimento = veicoloRifornimento;
    }

    public ArrayList<Aereo> getAereiInSosta() {
        return aereiInSosta;
    }

    public void setAereiInSosta(ArrayList<Aereo> aereiInSosta) {
        this.aereiInSosta = aereiInSosta;
    }

    public VeicoloBagaglio getVeicoloBagaglio() {
        return veicoloBagaglio;
    }

    public void setVeicoloBagaglio(VeicoloBagaglio veicoloBagaglio) {
        this.veicoloBagaglio = veicoloBagaglio;
    }

    public VeicoloRifornimento getVeicoloRifornimento() {
        return veicoloRifornimento;
    }

    public void setVeicoloRifornimento(VeicoloRifornimento veicoloRifornimento) {
        this.veicoloRifornimento = veicoloRifornimento;
    }

    public void entraAreaSosta(Aereo aereo){
        try{
            m_entraInSosta.acquire();

            s_aereiInSosta.acquire();
            if(getAereiInSosta().size() < 3){
                getAereiInSosta().add(aereo);
            }

            m_entraInSosta.release();
        } catch (InterruptedException exc) { 
            System.out.println(exc); 
        }
    }

    public void rifornisciAerei(){
        try{
            m_veicoloSincro.acquire();
        
            for(int i = 0; i < getAereiInSosta().size(); i++){
                if (getAereiInSosta().get(i).getSerbatoioPieno() == false) {
                    getVeicoloRifornimento().fillPlane(getAereiInSosta().get(i));
                }
            }

            m_veicoloSincro.release();
        }catch (InterruptedException exc) { 
            System.out.println(exc); 
        } 
    }

    public void caricaAerei(int bagagli){
        try{
            m_veicoloSincro.acquire();
        
            for(int i = 0; i < getAereiInSosta().size(); i++){
                if (getAereiInSosta().get(i).getPesoBagagli() < getAereiInSosta().get(i).getMaxPesoBagagli()) {
                    getVeicoloBagaglio().carica(getAereiInSosta().get(i), bagagli);;
                }
            }

            m_veicoloSincro.release();
        }catch (InterruptedException exc) { 
            System.out.println(exc); 
        } 
    }

    public void scaricaAerei(){
        try{
            m_veicoloSincro.acquire();
        
            for(int i = 0; i < getAereiInSosta().size(); i++){
                if (getAereiInSosta().get(i).getPesoBagagli() < getAereiInSosta().get(i).getMaxPesoBagagli()) {
                    getVeicoloBagaglio().scarica(getAereiInSosta().get(i));
                }
            }

            m_veicoloSincro.release();
        }catch (InterruptedException exc) { 
            System.out.println(exc); 
        } 
    }
    
    //da ricordare: andataERitorno per capire se va nell'hangar o parte.

    public Aereo esciAreaSosta(Aereo aereo){
        try{
            m_esciDaSosta.acquire();

            if(getAereiInSosta().size() > 0){
                getAereiInSosta().remove(aereo);
            }
            s_aereiInSosta.release();

            m_esciDaSosta.release();
        } catch (InterruptedException exc) { 
            System.out.println(exc); 
        }
        return aereo;
    }
}

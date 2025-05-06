public class VeicoloBagaglio {
    public VeicoloBagaglio(){

    }

    public void carica(Aereo aereo, int bagagli){
        

        if(aereo.getPesoBagagli() >= aereo.getMaxPesoBagagli()){
            aereo.setPesoBagagli(aereo.getMaxPesoBagagli());
        }else{
            aereo.setPesoBagagli(aereo.getPesoBagagli() + bagagli);
        }

    }

    public void scarica(Aereo aereo){
        aereo.setPesoBagagli(0);

    }
}

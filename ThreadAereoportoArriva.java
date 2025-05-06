public class ThreadAereoportoArriva {
    Aereo aereo;
    int pesoBagagli;
    int pesoPasseggeri;

    public ThreadAereoportoArriva(Aereo aereo, int pesoBagagli, int pesoPasseggeri){
        this.aereo = aereo;
        this.pesoBagagli = pesoBagagli;
        this.pesoPasseggeri = pesoPasseggeri;
    }

    public void run(){
        Aereo aereoCheEArrivato = aereo;
        System.out.println(aereoCheEArrivato.toStringCodiceVolo() + " sta attendendo di atterrare");
        
        Main.pista.entraInPista(aereoCheEArrivato);
        System.out.println(aereoCheEArrivato.toStringCodiceVolo() + " è atterrato");
        
        aereoCheEArrivato = Main.pista.liberaPistaAtterrato();
        Main.areaDiSosta.entraAreaSosta(aereoCheEArrivato);
        
        if(aereoCheEArrivato.getAndataERitorno()){
            aereoCheEArrivato = Main.areaDiSosta.rifornisciAereo(aereoCheEArrivato);
            System.out.println(aereoCheEArrivato.toStringCodiceVolo() + " è stato rifornito");

            aereoCheEArrivato = Main.areaDiSosta.caricaAereo(aereoCheEArrivato, pesoBagagli);
            System.out.println(aereoCheEArrivato.toStringCodiceVolo() + " è stato caricato di quantita bagagli pari a: "+ pesoBagagli);
            
            aereoCheEArrivato.caricaPasseggieri(pesoPasseggeri);
            System.out.println(aereoCheEArrivato.toStringCodiceVolo() + " è stato caricato di quantita passeggeri pari a: "+ pesoPasseggeri);

            if (aereoCheEArrivato.prontoAlDecollo()) {
                System.out.println(aereoCheEArrivato.toStringCodiceVolo() + " è pronto al decollo");
                Main.pista.entraInPista(aereoCheEArrivato);
                System.out.println(aereoCheEArrivato.toStringCodiceVolo() + " è entrato in pista");
                Main.pista.liberaPistaDecollo();
            }
        }else{
            aereoCheEArrivato = Main.areaDiSosta.scaricaAereo(aereoCheEArrivato);
            Main.hangar.entraHangar(aereoCheEArrivato);
        }
        
        
    } 
}

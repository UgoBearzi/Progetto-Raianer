import java.io.*;
public class ThreadAereoportoParte extends Thread{    
    int pesoBagagli;
    int pesoPasseggeri;

    public ThreadAereoportoParte(int pesoBagagli, int pesoPasseggeri){
        this.pesoBagagli = pesoBagagli;
        this.pesoPasseggeri = pesoPasseggeri;
    }

    public void run(){
        Aereo aereoCheDevePartire = Main.hangar.esciHangar();
        System.out.println(aereoCheDevePartire.toStringCodiceVolo() + " è uscito dall'hangar");

        Main.areaDiSosta.entraAreaSosta(aereoCheDevePartire);
        System.out.println(aereoCheDevePartire.toStringCodiceVolo() + " è entrato nell'Area di sosta");
        do{
            aereoCheDevePartire = Main.areaDiSosta.rifornisciAereo(aereoCheDevePartire);
            System.out.println(aereoCheDevePartire.toStringCodiceVolo() + " è stato rifornito");

            aereoCheDevePartire = Main.areaDiSosta.caricaAereo(aereoCheDevePartire, pesoBagagli);
            
            System.out.println(aereoCheDevePartire.toStringCodiceVolo() + " è stato caricato di bagagli fino a: "+ 
            (aereoCheDevePartire.getPesoBagagli()) + " con bagagli rimasti in aereoporto: " + 
            (Math.max(0,((aereoCheDevePartire.getPesoBagagli() - aereoCheDevePartire.getMaxPesoBagagli()) + pesoBagagli))));
            
            aereoCheDevePartire.caricaPasseggieri(pesoPasseggeri);

            System.out.println(aereoCheDevePartire.toStringCodiceVolo() + " è stato caricato di bagagli fino a: "+ 
            (aereoCheDevePartire.getPasseggieri()) + " con passeggeri rimasti in aereoporto: " + 
            (Math.max(0,((aereoCheDevePartire.getPasseggieri() - aereoCheDevePartire.getMaxPasseggeri()) + pesoPasseggeri))));
        }while(!aereoCheDevePartire.prontoAlDecollo());
        

        if (aereoCheDevePartire.prontoAlDecollo()) {
            System.out.println(aereoCheDevePartire.toStringCodiceVolo() + " è pronto al decollo");
            Main.pista.entraInPista(aereoCheDevePartire);
            System.out.println(aereoCheDevePartire.toStringCodiceVolo() + " è decollato");
            Main.pista.liberaPistaDecollo();
        }
    } 
}
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

        aereoCheDevePartire = Main.areaDiSosta.rifornisciAereo(aereoCheDevePartire);
        System.out.println(aereoCheDevePartire.toStringCodiceVolo() + " è stato rifornito");

        aereoCheDevePartire = Main.areaDiSosta.caricaAereo(aereoCheDevePartire, pesoBagagli);
        System.out.println(aereoCheDevePartire.toStringCodiceVolo() + " è stato caricato di quantita bagagli pari a: "+ pesoBagagli);
        
        aereoCheDevePartire.caricaPasseggieri(pesoPasseggeri);
        System.out.println(aereoCheDevePartire.toStringCodiceVolo() + " è stato caricato di quantita passeggeri pari a: "+ pesoPasseggeri);

        if (aereoCheDevePartire.prontoAlDecollo()) {
            System.out.println(aereoCheDevePartire.toStringCodiceVolo() + " è pronto al decollo");
            Main.pista.entraInPista(aereoCheDevePartire);
            System.out.println(aereoCheDevePartire.toStringCodiceVolo() + " è entrato in pista");
            Main.pista.liberaPistaDecollo();
        }
    } 
}
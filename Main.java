import java.util.concurrent.Semaphore;

public class Main {
    public static AreaDiSosta areaDiSosta = new AreaDiSosta(new VeicoloBagaglio(), new VeicoloRifornimento());
    public static Pista pista = new Pista();
    public static Hangar hangar = new Hangar();
    
    public static void main(String[] args) {
        riempiHangar();
        
        Aereo aereo6 = new Aereo(6,"A.inc",30,0,250,true,false);
        Aereo aereo7 = new Aereo(7,"A.inc",30,0,250,false,false);
        Aereo aereo8 = new Aereo(8,"A.inc",30,0,250,true,false);
        

        ThreadAereoportoParte threadParte1 = new ThreadAereoportoParte(30, 10);
        ThreadAereoportoParte threadParte2 = new ThreadAereoportoParte(15, 15);
        ThreadAereoportoParte threadParte3 = new ThreadAereoportoParte(50, 5);
        ThreadAereoportoParte threadParte4 = new ThreadAereoportoParte(100, 20);
        ThreadAereoportoParte threadParte5 = new ThreadAereoportoParte(95, 16);

        ThreadAereoportoArriva threadArriva1 = new ThreadAereoportoArriva(aereo6, 60, 25);
        ThreadAereoportoArriva threadArriva2 = new ThreadAereoportoArriva(aereo7, 40, 8);
        ThreadAereoportoArriva threadArriva3 = new ThreadAereoportoArriva(aereo8, 90, 9);

        threadParte1.start();
        threadParte2.start();
        threadParte3.start();
        threadParte4.start();
        threadParte5.start();

        threadArriva1.start();
        threadArriva2.start();
        threadArriva3.start();

        try {
            threadParte1.join();
            threadParte2.join();
            threadParte3.join();
            threadParte4.join();
            threadParte5.join();

            threadArriva1.join();
            threadArriva2.join();
            threadArriva3.join();
        } catch (InterruptedException e) {
            
        }
        
        
    }

    public static void riempiHangar(){
        Aereo aereo1 = new Aereo(1,"WeBreathAir.inc",20,0,200,false,false);
        hangar.getAereiInHangar().add(aereo1);

        Aereo aereo2 = new Aereo(2,"The safest™",15,0,200,false,false);
        hangar.getAereiInHangar().add(aereo2);

        Aereo aereo3 = new Aereo(3,"SmallPlanes™",2,0,50,false,false);
        hangar.getAereiInHangar().add(aereo3);

        Aereo aereo4 = new Aereo(4,"We put people in the luggage trunk™",30,0,50,false,false);
        hangar.getAereiInHangar().add(aereo4);
        
        Aereo aereo5 = new Aereo(5,"TM™",15,0,200,false,false);
        hangar.getAereiInHangar().add(aereo5);
    }



    // pronto al decollo = true + andata e ritoeno = true riparte in volo
}

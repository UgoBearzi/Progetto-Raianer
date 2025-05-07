IDEE PROGETTUALI
Classe Aereo
Contiene le funzioni specifiche di un aereo, che non sono applicabili ai veicoli di rifornimento o ai veicoli bagagli.

public void caricaPasseggeri(int passeggeriNuovi): l'aereo può ospitare passeggeri.

public void scaricaPasseggeri(): rimuove tutti i passeggeri dall’aereo.

public boolean prontoAlDecollo(): controlla che l’aereo sia pronto a decollare (es. serbatoio pieno, passeggeri presenti, bagagli caricati).

Classe AreaDiSosta
Gestisce l'accesso all'area di sosta e le operazioni comuni per tutti gli aerei.

public void entraAreaSosta(Aereo aereo): un aereo entra nell'area di sosta (con sincronizzazione per evitare concorrenza).

public Aereo esciAreaSosta(Aereo aereo): un aereo esce dall'area di sosta.

public Aereo rifornisciAereo(Aereo aereo): rifornisce un aereo con l’aiuto di un VeicoloRifornimento.

public Aereo caricaAereo(Aereo aereo, int bagagli): carica bagagli su un aereo con un VeicoloBagaglio.

public Aereo scaricaAereo(Aereo aereo): scarica tutti i bagagli presenti nell’aereo tramite un VeicoloBagaglio.

Classe Hangar
Contiene gli aerei non utilizzati.

public void entraHangar(Aereo aereo): l’aereo viene parcheggiato nell’hangar.

public Aereo esciHangar(): estrae un aereo dall’hangar per la partenza.

Gli aerei sono gestiti tramite una struttura come ArrayList, eventualmente sincronizzata.

Classe Pista
Controlla l’accesso esclusivo alla pista tramite un semaforo.

public void entraInPista(Aereo aereo): l’aereo accede alla pista (un solo aereo per volta).

public Aereo liberaPistaAtterrato(): rimuove dalla pista un aereo appena atterrato.

public void liberaPistaDecollo(): libera la pista dopo il decollo di un aereo.

Thread ThreadAeroportoArriva
Simula l’arrivo di un aereo all’aeroporto.

Gestisce tutte le fasi dopo l’atterraggio: ingresso in pista, area di sosta, rifornimento, carico bagagli e passeggeri.

Se l’aereo ha andataERitorno = true, verrà ricaricato e ripartirà.

Altrimenti, viene spostato nell’hangar.

Rende la simulazione realistica e concorrente con altri arrivi.

Thread ThreadAeroportoParte
Simula la partenza di un aereo presente nell’hangar.

Estrae un aereo dall’hangar, lo sposta nell’area di sosta, lo rifornisce e lo carica.

Verifica con un ciclo do-while che l’aereo sia pronto al decollo.

Ogni thread è indipendente e rappresenta una partenza autonoma.

Classe VeicoloBagaglio
Gestisce il caricamento e lo scaricamento bagagli.

public void carica(Aereo aereo, int bagagli): carica bagagli sull’aereo, rispettando il peso massimo.

public void scarica(Aereo aereo): scarica tutti i bagagli dall’aereo.

Classe VeicoloRifornimento
Gestisce il rifornimento di carburante.

public void fillPlane(Aereo aereo): riempie il serbatoio dell’aereo (usato prima del decollo o nei voli A/R).

Classe Main
Il cuore della simulazione.

Contiene le istanze condivise: Pista, AreaDiSosta, Hangar.

In main() si inizializzano gli aerei e si avviano i thread di arrivo e partenza.

Il metodo riempiHangar() popola inizialmente l’hangar con aerei pronti a partire.


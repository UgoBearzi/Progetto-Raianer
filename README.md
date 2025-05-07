# Progetto-Raianer

IDEE PROGETTUALI

Aereo: abbiamo deciso di occuparci di queste funzioni dentro l’aereo dato che solo esso può compirle.
•	public void s/caricaPasseggeri(int passeggeriNuovi) può ospitare delle persone al suo interno a differenza da quelli per il rifornimento e a quelli per i bagagli.
•	public void prontoAlDecollo()questa funzione la abbiamo messa più specificatamente in Aereo, perché deve controllare cose diverse dagli altri tipi di veicoli per poter partire
________________________________________
AreaDiSosta: abbiamo creato queste funzioni in AreaDiSosta in modo che esse possano essere utilizzate da tutti i tipi di aerei
•	public void entraAreaSosta(Aereo aereo) ogni aereo ha a disposizione 1 veicolo per area di sosta in modo che non abbiano problemi di concorrenza, e viene usata per entrare dell’area di sosta.
•	public Aereo esciAreaSosta(Aereo aereo) ogni aereo ha a disposizione 1 veicolo per area di sosta in modo che non abbiano problemi di concorrenza, e viene usata per uscire dell’area di sosta.
•	public Aereo rifornisciAereo(Aereo aereo)questa funzione viene usata per rifornire l’aereo ci serve un veicolo da rifornimento, e in input troviamo l’aereo che vogliamo rifornire.
•	public Aereo caricaAereo(Aereo aereo, int bagagli) questa funzione invece viene usata per caricare l’aereo, ci serve un veicolo per i bagagli, e in input troviamo l’aereo che vogliamo caricare dei bagagli messi in input.
•	public Aereo scaricaAereo(Aereo aereo) questa funzione la usiamo per scaricare l’aereo, ci serve un veicolo per i bagagli, e a differenza di scarica, togliamo tutti i bagagli di base senza averne una quantità in input.
________________________________________
Hangar: contiene tutti i tipi di aerei che non stanno venendo utilizzati
public void entra/esciHangar(Aereo aereo)la funzione, li fa entrare/uscire ne/dall’hangar e grazie ad un ArrayList riusciamo a gestire lo spazio facilmente.
________________________________________
Pista
Abbiamo deciso di creare queste funzioni nella classe Pista per simulare l’accesso concorrente alla pista da parte di un solo aereo alla volta, grazie a un semaforo:
•	public void entraInPista(Aereo aereo) → questa funzione serve per far entrare un aereo nella pista. Grazie al semaforo si garantisce che un solo aereo possa essere presente sulla pista per volta.
•	public Aereo liberaPistaAtterrato() → serve a rimuovere dalla pista l’aereo appena atterrato, restituendolo così per le operazioni successive. Anche questa funzione acquisisce il semaforo per garantire la mutua esclusione.
•	public void liberaPistaDecollo() → libera la pista dopo il decollo di un aereo, rimuovendolo dalla lista e rilasciando il semaforo per consentire il passaggio ad altri aerei.
________________________________________
ThreadAereoportoArriva
Abbiamo implementato questo thread per simulare l'arrivo di un aereo in aeroporto:
•	Si occupa di gestire tutte le fasi successive all'atterraggio: ingresso in pista, passaggio all’area di sosta, eventuale rifornimento, carico bagagli e passeggeri.
•	Se l’aereo ha andataERitorno = true, verrà caricato e ripartirà, altrimenti verrà parcheggiato nell’hangar.
•	Serve a simulare il comportamento asincrono di più aerei che arrivano simultaneamente.
________________________________________
ThreadAereoportoParte
Abbiamo creato questo thread per simulare la partenza di un aereo che si trova nell’hangar:
•	Estrae un aereo dall’hangar, lo sposta nell’area di sosta, lo rifornisce e lo carica, poi lo fa decollare.
•	Utilizza un ciclo do-while per verificare che l’aereo sia pronto al decollo (carico completo e serbatoio pieno).
•	Anche qui ogni thread simula un processo indipendente di partenza, per rendere la simulazione realistica e concorrente.
________________________________________
VeicoloBagaglio
Abbiamo deciso che questo veicolo si occupa esclusivamente della gestione dei bagagli:
•	public void carica(Aereo aereo, int bagagli) → serve per caricare un certo numero di bagagli in un aereo, tenendo conto del peso massimo che l’aereo può sostenere.
•	public void scarica(Aereo aereo) → rimuove tutti i bagagli presenti a bordo dell’aereo. È utilizzata quando un aereo arriva e deve essere svuotato.
________________________________________
VeicoloRifornimento
Questa classe rappresenta un veicolo che si occupa esclusivamente di rifornire l’aereo:
•	public void fillPlane(Aereo aereo) → imposta il serbatoio dell’aereo come pieno. È utilizzato prima della partenza o nel ciclo di ripartenza per voli di andata e ritorno.
________________________________________
Main
Il Main rappresenta il cuore della simulazione:
•	Contiene le istanze condivise: Pista, AreaDiSosta e Hangar.
•	Nel metodo main() vengono inizializzati gli aerei e avviati i thread di partenza e arrivo, simulando un’intera giornata operativa in un aeroporto.
•	riempiHangar() serve a popolare inizialmente l’hangar con alcuni aerei pronti a partire, rendendo la simulazione realistica.


Prova C – 22 Giugno 2011 –  Gestione missioni all'estero

L'Università di Bergamo vi chiede di scrivere un programma che gestisce le missioni all'estero del suo personale.
Si vogliono memorizzare i dati relativi alle missioni e alle persone che vi partecipano.

Le missioni sono di due tipi: individuali e collettive.
Di tutte le missioni si memorizza:
il luogo di destinazione, la data di inizio, la data di fine, se si userà l'ae-reo, se si usa l'auto
(con distinzione se auto propria o a noleggio), e se si usa il taxi. Una missione può essere anche all'estero o in Italia.

Delle missioni individuali si memorizza il partecipante, mentre quelle collettive tengono traccia di più partecipanti (>1).
Quelle collettive hanno anche indicato se i partecipanti sono tutti dipendenti oppure no.
Se si cerca di creare una missione collettiva con un solo partecipante bisogna lanciare l'eccezione.

Ogni missione, memorizza anche le voci di spesa (in ordine crescente di importo) con descrizione, importo e valuta.

Vengono anche gestite le valute estere (in una classe GestoreValute ad esempio).
Ogni valuta ha un sigla di tre lettere e un tasso di cambio rispetto all'euro.
Ad esempio, una valuta potrebbe essere “USD” con cambio 1.45, EUR con cambio 1 e così via.
Per le missioni in Italia (o se non indicata) la valuta è “EUR”. C'è una lista di tutte le valute memorizzate nel sistema.
Non ci possono essere due valute con la stessa sigla.

Le operazioni che il sistema di gestione deve permettere sono:

1.	Inserimento missione

2.	Lettura delle missioni da file

3.	Inserimento di una voce di costo in una missione.

4.	Stampa missione a video con i dati della missione (anche le voci di spesa - in ordine).

5.	Aggiunta di una valuta. Modifica del tasso di cambio di una valuta (date le tre cifre). Ricerca di una valuta (data la sigla).
Stampa delle valute memorizzate.
Esempio: setTassoCambio(“USD”,1.45);

6.	Liquidazione missione: un missione viene liquidata sommando tutte le voci di spesa e facendo le opportune conversioni in EUR con tassi di cambio. Se la missione è individuale e all'estero viene aggiunta la diaria di 20 euro al giorno [purtroppo non è così :)]. Se invece è collettiva, l'importo viene diviso per il numero di partecipanti. La procedura calcola la somma finale.

All'incirca ogni funzionalità richiede la scrittura di un metodo a cui passare i parametri opportuni. Metti le funzionalità maggiori in una classe “GestoreMissioni”.  Non è necessario fare alcun input con l'utente. Scrivi però un main in cui testi tutti i metodi sopra descritti più eventuali altri per assicurarti che funzionino. Nel main non chiedere nulla all'utente ma mostra solo i risultati dei passi. Crea anche due file d'esempio e prova caricarli.

Istruzioni pratiche: usa il desktop come workspace di eclipse e crea un progetto con il tuo cognome.nome: in questo modo ti troverai già sul desktop una cartella che contiene tutto quello che serve per la valutazione. Crea un file readme.txt (in cui spieghi la tua applicazione) con eclipse nel default package.
Anche il file delle missioni mettilo nella root del progetto, per riferirti ad esso basterà che usi il suo nome (senza path).

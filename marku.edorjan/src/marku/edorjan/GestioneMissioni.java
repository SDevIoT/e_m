/**
 * L'Università di Bergamo vi chiede di scrivere un programma che gestisce
le missioni all'estero del suo personale.
Si vogliono memorizzare i dati relativi alle missioni e alle persone che
vi partecipano.

Le missioni sono di due tipi: individuali e collettive. 
Di tutte le missioni si memorizza: 
	il luogo di destinazione,
	la data di inizio,
	la data di fine, 
	se si userà l'aereo, 
	se si usa l'auto (con distinzione se auto propria o a noleggio),
	e se si usa il taxi. 
	Una missione può essere anche all'estero o in Italia.

Delle missioni individuali si memorizza il partecipante,
mentre quelle collettive tengono traccia di più partecipanti (>1).
Quelle collettive hanno anche indicato se i partecipanti sono tutti dipendenti
oppure no.
Se si cerca di creare una missione collettiva con un solo partecipante
bisogna lanciare l'eccezione.

Ogni missione, memorizza anche le voci di spesa (in ordine crescente di importo)
	con descrizione,
	importo 
	e valuta.

Vengono anche gestite le valute estere
(in una classe GestoreValute ad esempio).
Ogni valuta ha un sigla di tre lettere e un tasso di cambio rispetto all'euro.
Ad esempio, una valuta potrebbe essere “USD” con cambio 1.45,
EUR con cambio 1 e così via. 

Per le missioni in Italia (o se non indicata) la valuta è “EUR”.
C'è una lista di tutte le valute memorizzate nel sistema.
Non ci possono essere due valute con la stessa sigla.

Le operazioni che il sistema di gestione deve permettere sono:

1.	Inserimento missione

2.	Lettura delle missioni da file

3.	Inserimento di una voce di costo in una missione.

4.	Stampa missione a video con i dati della missione (anche le voci di spesa - in ordine).

5.	Aggiunta di una valuta. Modifica del tasso di cambio di una valuta (date le tre cifre). Ricerca di una valuta (data la sigla). Stampa delle valute memorizzate.
Esempio: setTassoCambio(“USD”,1.45);

6.	Liquidazione missione: un missione viene liquidata sommando tutte le voci di spesa e facendo le opportune conversioni in EUR con tassi di cambio. Se la missione è individuale e all'estero viene aggiunta la diaria di 20 euro al giorno [purtroppo non è così :)]. Se invece è collettiva, l'importo viene diviso per il numero di partecipanti. La procedura calcola la somma finale.

All'incirca ogni funzionalità richiede la scrittura di un metodo a cui passare i parametri opportuni. Metti le funzionalità maggiori in una classe “GestoreMissioni”.  Non è necessario fare alcun input con l'utente. Scrivi però un main in cui testi tutti i metodi sopra descritti più eventuali altri per assicurarti che funzionino. Nel main non chiedere nulla all'utente ma mostra solo i risultati dei passi. Crea anche due file d'esempio e prova caricarli.

Istruzioni pratiche: usa il desktop come workspace di eclipse e crea un progetto con il tuo cognome.nome: in questo modo ti troverai già sul desktop una cartella che contiene tutto quello che serve per la valutazione. Crea un file readme.txt (in cui spieghi la tua applicazione) con eclipse nel default package.
Anche il file delle missioni mettilo nella root del progetto, per riferirti ad esso basterà che usi il suo nome (senza path).

 */
package marku.edorjan;

/**
 * @author Edorjan Marku
 *
 */

import prog.io.*;

public class GestioneMissioni {
	static ConsoleInputManager in = new ConsoleInputManager();
	static ConsoleOutputManager out = new ConsoleOutputManager();
	static final boolean VERBOSE = false; // 0 = No scambio con operatore, i valori vengono autogenerati. 1 = Interfaccia operatore
	/**
	 * 
	 */
	public GestioneMissioni() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * 
	 * Programma main per il test dell'applicazione.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		int indiceOp = 0;

		
		System.out.println("-----------[ INIZIO ]-------------");
		System.out.println();
		System.out.println();
		System.out.println("Le operazioni che il sistema è in grado di gestire sono:");

		
		do{
			System.out.println();
			System.out.println("\t1.\tInserimento missione.");
			System.out.println("\t2.\tLettura delle missioni da file");
			System.out.println("\t3.\tInserimento di una voce di costo in una missione.");
			System.out.println("\t4.\tStampa missione a video con i dati della missione (anche le voci di spesa - in ordine)");
			System.out.println("\t5.\tAggiunta di una valuta. Modifica del tasso di cambio di una valuta (date le tre cifre). Ricerca di una valuta (data la sigla). Stampa delle valute memorizzate.");
			System.out.println("\t6.\tLiquidazione missione");
			System.out.println();
			System.out.println("\t0.	Inserire 0 per terminare il programma");
			System.out.println();
			//System.out.println("Selezionare il numero indice l'operazione desiderata");
			
			if (VERBOSE) indiceOp = in.readInt("Selezionare il numero indice l'operazione desiderata: ");
			else indiceOp = 1;
			
			switch(indiceOp){
			case 0:
				System.out.println("Hai scelto " + indiceOp );
				break;
			case 1:
				System.out.println("Hai scelto " + indiceOp );
				InserisciMissione();
				break;
			case 2:
				System.out.println("Hai scelto " + indiceOp );
				LeggiMissioniFile();
				break;
			case 3:
				System.out.println("Hai scelto " + indiceOp );
				InserisciVoceCosto();
				break;
			case 4:
				System.out.println("Hai scelto " + indiceOp );
				StampaMissione();
				break;
			case 5:
				System.out.println("Hai scelto " + indiceOp );
				AggiungiValuta();
				break;
			case 6:
				System.out.println("Hai scelto " + indiceOp );
				LiquidaMissione();
				break;
			default:
				System.out.println("Scelta errata " + indiceOp );	
			}
			out.println("\r\n\r\n\r\n\r\n");
			if (!VERBOSE) indiceOp = 0;

		}while(indiceOp != 0);
		
		
		System.out.println("-----------[ END ]-------------");
	}
	
	/**
	 * @author Edorjan
	 * @throws Exception 
	 *
	 */
	private static void InserisciMissione() throws Exception {
		System.out.println("--------- Hai scelto InserisciMissione -----------");
		
		TipoTrasferta tt = TipoTrasferta.ITALIA;
		TipoMissione tm = TipoMissione.INDIVIDUALE;
		TipoMezzo tz = TipoMezzo.NESSUNO;
		String luogoDestinazione = "";
		String dataInizio = "";
		String dataFine = "";
		
		char c;
		
		if (VERBOSE) c = in.readChar("inserici I per missione in italia oppure E per missione all'estero: ");
		else c = 'E';
		
		if (c == 'I'){
			tt = TipoTrasferta.ITALIA;
		}
		else if (c == 'E'){
			tt = TipoTrasferta.ESTERO;
		}
		else{
			throw new IntroductionException("Introduzione tipo trasferta non valida");
		}
		
		int nPartecipanti;
		if (VERBOSE) nPartecipanti = in.readInt("inserici il numero di partecipanti alla missione: ");
		else nPartecipanti = 7;
		
		if (nPartecipanti > 1){
			tm = TipoMissione.GRUPPO;
		}
		else if (nPartecipanti == 1){
			tm = TipoMissione.INDIVIDUALE;
		}
		else{
			throw new IntroductionException("Introduzione tipo missione non valida");
		}
		
		if (VERBOSE) c = in.readChar("inserici il mezzo utilizzato per svolgere la missione\r\n0=Nessuno  T=Taxi  I=Auto propria  N=Noleggio  A=Aereo : ");
		else c = 'T';
		
		switch(c){
		case '0':
			tz = TipoMezzo.NESSUNO;
			break;
		case 'T':
			tz = TipoMezzo.TAXI;
			break;
		case 'I':
			tz = TipoMezzo.AUTO_PROPRIA;
			break;
		case 'N':
			tz = TipoMezzo.AUTO_NOLEGGIO;
			break;
		case 'A':
			tz = TipoMezzo.AEREO;
			break;
		default:
			throw new IntroductionException("Introduzione tipo missione non valida");	
		}
		
		if (VERBOSE){
			dataInizio = in.readLine("Inserici la data di partenza in formato dd/mm/aaaa: ");
			dataFine = in.readLine("Inserici la data di fine missione in formato dd/mm/aaaa: ");
			//TO_DO: Inserire controllo data valida
			luogoDestinazione = in.readLine("Inserici luogo missione: ");
		}
		else{
			dataInizio = "03/05/2017";
			dataFine = "9/07/2017";
			luogoDestinazione = "Madrid";
		}
		out.println("*******************************************************");
		out.println(tt.toString());
		out.println(tm.toString());
		out.println(tz.toString());
		out.println("Lougo destinazione: " + luogoDestinazione);
		out.println("Data inizio: " + dataInizio);
		out.println("Data fine: " + dataFine);
		out.println("*******************************************************");
		
		VoceSpesa vs = new VoceSpesa("Pranzo", 15.0f, new Valuta("EUR",10.0));
		
		ListaOrdinata<VoceSpesa> spese = new ListaOrdinata<>();
		
		spese.inserisci(new VoceSpesa("Pranzo", 15.0f, new Valuta("EUR",1.0)));
		spese.inserisci(new VoceSpesa("Cena", 35.0f, new Valuta("EUR",1.0)));
		spese.inserisci(new VoceSpesa("Albergo", 75.0f, new Valuta("EUR",1.0)));
		spese.inserisci(new VoceSpesa("Lavanderia", 5.0f, new Valuta("EUR",1.0)));
		spese.inserisci(new VoceSpesa("Portaborse", 65.0f, new Valuta("EUR",1.0)));
		spese.print();
		
		Missione m = new Missione(tt,  tm, tz,luogoDestinazione, dataInizio, dataFine);
		
	}
	private static void LeggiMissioniFile() {
		// TODO Auto-generated method stub
		
	}
	private static void InserisciVoceCosto() {
		// TODO Auto-generated method stub
		
	}
	private static void StampaMissione() {
		// TODO Auto-generated method stub
		
	}
	private static void AggiungiValuta() {
		// TODO Auto-generated method stub
		
	}
	private static void LiquidaMissione() {
		// TODO Auto-generated method stub
		
	}
		
}


/**
 * @author Casa
 * Tipo di trasferta da considerare
 */
enum TipoTrasferta {
    ITALIA(false), ESTERO(true);
    private boolean missionEstero;
    
    private TipoTrasferta(boolean missionEstero) {
      this.setMissionEstero(missionEstero);
    }

	public boolean isMissionEstero() {
		return missionEstero;
	}
	public boolean isMissionItalia() {
		return !(missionEstero);
	}
	public void setMissionEstero(boolean missionEstero) {
		this.missionEstero = missionEstero;
	}
	public String toString(){
		switch(this) {
		  case ITALIA: return "Trasferta: Italia";
		  case ESTERO: return "Trasferta: Estero";
		  default: throw new IllegalArgumentException();
		  }
	}
}
/**
 * @author Edorjan
 * Tipo di missione (individuale o in gruppo)
 */
enum TipoMissione {
    INDIVIDUALE(false), GRUPPO(true);
    private boolean tipoMissione;
    
    private TipoMissione(boolean tipoMissione) {
      this.setMissioneGruppo(tipoMissione);
    }

	public boolean isMissioneGruppo() {
		return tipoMissione;
	}
	public boolean isMissioneIndividuale() {
		return !(tipoMissione);
	}
	public void setMissioneGruppo(boolean tipoMissione) {
		this.tipoMissione = tipoMissione;
	}
	public String toString(){
		switch(this) {
		  case INDIVIDUALE: return "Missione: Individuale";
		  case GRUPPO: return "Missione: Gruppo";
		  default: throw new IllegalArgumentException();
		  }
	}
}
/**
 * @author Edorjan
 *
 */
enum TipoMezzo{
	NESSUNO,
    TAXI,
    AEREO,
    AUTO_PROPRIA,
    AUTO_NOLEGGIO;
	public String toString(){
		switch(this) {
		  case NESSUNO: return "Tipo mezzo: Nessuno";
		  case TAXI: return "Tipo mezzo: Taxi";
		  case AEREO: return "Tipo mezzo: Aereo";
		  case AUTO_PROPRIA: return "Tipo mezzo: Auto propria";
		  case AUTO_NOLEGGIO: return "Tipo mezzo: Auto a noleggio";
		  default: throw new IllegalArgumentException();
		  }
	}
	
}


/**
 * @author Casa
 *
 */
class Missione {

	TipoTrasferta tt;
	TipoMissione tm;
	TipoMezzo tz;
	String luogoDestinazione = "";
	String dataInizio = "";
	String dataFine = "";
	
	boolean  missionEstero;
	
	/**
	 * 
	 */
	public Missione() {
		tt = null;
		tm = null;
		tz = null;
		luogoDestinazione = null;
		dataInizio = null;
		dataFine = null;
	}
	public Missione(TipoTrasferta tt, TipoMissione tm, TipoMezzo tz,String luogoDestinazione, String dataInizio, String dataFine) {
		this.tt = tt;
		this.tm = tm;
		this.tz = tz;
		this.luogoDestinazione = luogoDestinazione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}
	
}

class MissioneCollettiva extends Missione {

	int numPartecipanti = 0;
	String[] partecipanti;
	boolean esterni = false;
//Quelle collettive hanno anche indicato se i partecipanti sono tutti dipendenti oppure no.
	
	public MissioneCollettiva() {
		// TODO Auto-generated constructor stub
	}

}
class MissioneIndividuale extends Missione {

	String partecipante = "";
	public MissioneIndividuale() {
		// TODO Auto-generated constructor stub
	}

}

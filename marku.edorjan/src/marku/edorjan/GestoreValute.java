package marku.edorjan;

import java.util.EmptyStackException;

public class GestoreValute {

	public GestoreValute() {
		// TODO Auto-generated constructor stub
	}

}

class Valuta {

/*Ogni valuta ha un sigla di tre lettere e un tasso di cambio rispetto all'euro.
	Ad esempio, una valuta potrebbe essere “USD” con cambio 1.45,
	EUR con cambio 1 e così via. */
	
	String sigla;	// = "EUR";
	double cambio;	// = 1.0;
	
	public Valuta() {
		sigla = "EUR";
		cambio = 1.0;
	}
	public Valuta(String s, double c) throws Exception {
		if (s.length() != 3){
			throw new Exception("Sigla valuta non conforme");
		}
		else{
			sigla = s;
			cambio = c;
		}
	}
	public String toString(){
		return sigla;
	}
}


class ListaValute {
	private NodoValuta cima;
	
	/**
	 * 
	 */
	public ListaValute() {
		cima = null;
	}

	private static class NodoValuta {
		Object dato;
		NodoValuta pros;
	}

	/**
	 * @param o
	 * @return posizione
	 */
	public int trova(Valuta o){
		NodoValuta p = cima;
		int posizione = 1;
		while (p!=null && p.dato != o.sigla){
			p=p.pros;
			posizione++;
		}
		if (p==null || p.dato == o.sigla)
			return 0;
		else
			return posizione;
	}
	
	public void push(Valuta o){
		NodoValuta v = new NodoValuta();
		v.dato = o;
		v.pros = cima;
		cima = v;		
	}
	
	public Object pop(){
		if (cima == null){
			throw new EmptyStackException();
		}
		else{
			Object risultato = cima.dato;
			cima = cima.pros;
			return risultato;
		}	
	}
	
}
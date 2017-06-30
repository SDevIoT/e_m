/**
 * 
 */
package marku.edorjan;

/**
 * @author Edorjan
 *
 */
public class VoceSpesa implements Comparable<VoceSpesa>{

	String descrizione;
	float importo;
	Valuta valuta;
	/**
	 * 
	 */
	public VoceSpesa() {
		this.descrizione="";
		this.importo = (float) 0.0;
		this.valuta = null;
	}
	public VoceSpesa(String descrizione, float importo,	Valuta valuta) {
		this.descrizione=descrizione;
		this.importo = importo;
		this.valuta = valuta;
	}

	public int compareTo(VoceSpesa vs) {
		if (this.importo < vs.importo)
			return -1;
		else if (this.importo > vs.importo)
			return 1;
		else
			return 0;
	}
	public String toString() {
		return this.descrizione + ": " + this.importo + " " + this.valuta.toString();
	}
}
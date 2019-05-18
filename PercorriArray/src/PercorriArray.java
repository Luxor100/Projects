/**
 * Percorre l'array tramite un percorso dato dai valori dell'array stesso.
 * Parte dall'elemento 0 e si sposta al valore di quell elemento fino a -1
 * @author Mazzotta
 *
 */
public class PercorriArray {

	/**
	 * array della classe
	 */
	private int[] array;
	
	/**
	 * associa il valore all'array
	 * @param array
	 */
	public PercorriArray(int[] array) {	this.array = array; }
	
	/**
	 * Percorre l'array tramite un percorso dato dai valori dell'array stesso.
	 * Parte dall'elemento in posizione 0 e si sposta al valore di quell elemento fino ad 
	 * incontrare -1
	 * @return la stringa formata dai valori incontrati tramite il percorso
	 */
	public String percorri() {
		return percorri(0, "0, ");
	}
	
	/**
	 * Pattern della ricorsione, usato come appoggio
	 * @param indice tiene conto dell'indice per scorrere l'array
	 * @param stringa da restituire, contiene i valori delle posizioni del percorso
	 * @return stringa da restituire, contiene i valori delle posizioni del percorso
	 */
	private String percorri(int indice, String stringa) {
		if (indice == -1) return stringa.substring(0, stringa.length()-2);
		int n = array[indice];
		stringa+= n+", ";
		return percorri(n, stringa);
	}
}

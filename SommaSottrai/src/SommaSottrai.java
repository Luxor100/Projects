import java.util.List;

/**
 * Costruita con una lista di interi, restituisce la somma dei valori
 * della lista in posizione dispari da cui vengono sottratti i valori
 * in posizione pari
 * @author Mazzotta
 *
 */
public class SommaSottrai {
	
	/**
	 * lista di interi
	 */
	private List<Integer> lista;
	
	/**
	 * costruttore che associa la lista
	 * @param lista di interi
	 */
	public SommaSottrai(List<Integer> lista) { this.lista = lista; }
	
	/**
	 * Restituisce la somma dei valori della lista in
	 * posizione dispari da cui vengono sottratti
	 * i valori in posizione pari
	 * @return int, dispari - pari
	 */
	public int sommaSottrai() {
		return sommaSottrai(0, 0);
	}
	
	/**
	 * Pattern per la ricorsione, di appoggio
	 * @param indice per scorrere la lista
	 * @param risultato int per il return
	 * @return int, dispari - pari
	 */
	private int sommaSottrai(int indice, int risultato) {
		if (indice >= lista.size()) return risultato;
		int numero = lista.get(indice);
		risultato+= indice % 2 == 1 ? -numero : numero;
		return sommaSottrai(++indice, risultato);
	}
}

/**
 * Classe astratta Binario, costruito a partire dal binario successivo
 * @author Mazzotta
 *
 */
public abstract class Binario {

	/**
	 * Campo che definisce il prossimo binario da percorrere
	 */
	private Binario nextBinario;
	
	/**
	 * Costruttore della classe, definisco il prossimo binario da percorrere
	 */
	public Binario(Binario nextBinario) {	this.nextBinario = nextBinario; }
	/**
	 * Metodo che ritorna il campo nextBinario
	 * @return il successivo binario da percorrere
	 */
	public Binario getSuccessivo() { return nextBinario; }
	/**
	 * Metodo che effettua eventuali operazioni dato un Treno e restituisce il nextBinario
	 * @param treno sul quale effettuare le operazioni
	 * @throws GiaChiuse Errore se le porte sono già chiuse
	 * @throws GiaAperte Errore se le porte sono già aperte
	 */
	
	/**
	 * Setter del binario
	 * @param binario per il nuovo valore di nextBinario
	 */
	public void setSuccessivo(Binario binario) { nextBinario = binario; }
	
	/**
	 * Metodo che percorre il binario, definito in tutte le sottoclassi
	 * @param treno Treno che percorre
	 * @return binario successivo
	 * @throws GiaAperte
	 * @throws GiaChiuse
	 */
	public abstract Binario percorri(Treno treno) throws GiaAperte, GiaChiuse;
}

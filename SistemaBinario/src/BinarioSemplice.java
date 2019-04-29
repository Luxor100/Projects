/**
 * Estende Binario, ridefinisce percorri
 * @author Mazzotta
 *
 */
public class BinarioSemplice extends Binario {

	/**
	 * Chiama il costruttore di Binario
	 * @param nextBinario
	 */
	public BinarioSemplice(Binario nextBinario) {
		super(nextBinario);
	}

	/**
	 * percorre e ritorna il binario successivo
	 */
	@Override
	public Binario percorri(Treno treno) {	return getSuccessivo();	}
	
}

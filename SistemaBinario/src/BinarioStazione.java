/**
 * Estende Binario, ridefinisce percorri
 * @author Mazzotta
 *
 */
public class BinarioStazione extends Binario {
	/**
	 * Chiama il costruttore di Binario
	 * @param nextBinario
	 */
	public BinarioStazione(Binario nextBinario) {
		super(nextBinario);
	}

	/**
	 * Fa arrivare il treno in stazione e restituisce il prossimo binario da percorrere
	 */
	@Override
	public Binario percorri(Treno treno) throws GiaAperte, GiaChiuse {
		treno.entraInStazione();
		return getSuccessivo();
	}
	
	
}

/**
 * Estende Binario, ridefinisce percorri e implementa scambia
 * @author Mazzotta
 *
 */
public class BinarioScambio extends Binario {
	/**
	 * Altro binario
	 */
	private Binario nextBinario2;
	
	/**
	 * Costruttore con due Binari che possono essere scambiati
	 * @param nextBinario nextBinario predefinito
	 * @param nextBinario2 Binario scambiabile
	 */
	public BinarioScambio(Binario nextBinario, Binario nextBinario2) {
		super(nextBinario);
		this.nextBinario2 = nextBinario2;
	}
	
	/**
	 * scambia i binari
	 */
	public void scambia() {
		Binario tmp = getSuccessivo();
		setSuccessivo(nextBinario2);
		nextBinario2 = tmp;
	}
	
	/**
	 * ritorna il binario successivo
	 */
	@Override
	public Binario percorri(Treno treno) throws GiaAperte, GiaChiuse { return getSuccessivo(); }

}

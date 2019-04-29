/**
 * Estende la classe Binario, ridefinisce percorri e aggiunge un campo semaforo
 * @author Mazzotta
 *
 */
public class BinarioSemaforo extends Binario {

	/**
	 * durata in millisecondi del semaforo
	 */
	private long durataMillisecondi;
	/**
	 * true = verde, false = rosso
	 */
	private boolean semaforo;
	
	public BinarioSemaforo(Binario nextBinario, long durataMillisecondi) {
		super(nextBinario);
		this.durataMillisecondi = durataMillisecondi;
	}
	/**
	 * ritorna lo stato di semaforo
	 */
	public boolean rosso() {
		long stato = System.currentTimeMillis()/durataMillisecondi;
		if (stato%2 == 0) semaforo = true;
		else semaforo = false;
		return semaforo;
	}
	/**
	 * Se TAV o verde allora passa al successivo, altrimenti resta fermo
	 */
	@Override
	public Binario percorri(Treno treno) {
		if (treno.getClass().equals(TAV.class) || rosso()) return getSuccessivo();
		return this;
	}
}

/**
 * Estende la classe Treno, modifica il metodo entraInStazione
 * @author Mazzotta
 *
 */
public class TAV extends Treno {

	public TAV(double velocita) { super(velocita); }
	
	/**
	 * Quando entra in stazione oltre a fermarsi, chiude anche le porte
	 */
	@Override
	public void entraInStazione() throws GiaAperte, GiaChiuse {
		frena();
		setPorte(false);
	}
}

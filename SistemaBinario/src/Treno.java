/**
 * Classe per la costruzione di un oggetto Treno che espone una velocita e le porte(chiuse/aperte)
 * @author Mazzotta
 *
 */
public class Treno {
	/**
	 * Velocita del treno
	 */
	private double velocita;
	/**
	 * stato delle porte, aperte/chiuse
	 */
	private boolean porte;

	/**
	 * Costruttore per il treno con un parametro
	 * @param velocità definisce la velocita del treno
	 */
	public Treno(double velocità) { this.velocita = velocità; }
	/**
	 * frena il treno
	 */
	public void frena() { velocita = 0; }
	
	/**
	 * frena il treno appena entra in stazione
	 * @throws GiaChiuse Errore in caso siano già chiuse
	 * @throws GiaAperte Errore in caso siano già aperte
	 */
	public void entraInStazione() throws GiaAperte, GiaChiuse { frena(); }
	
	/**
	 * setter per aprire/chiudere le porte
	 * @param b true = aperte
	 */
	public void setPorte(boolean b) throws GiaAperte, GiaChiuse { 
		if (porte && b) throw new GiaAperte();
		if (! porte && !b) throw new GiaChiuse();
		porte = b; 
	}
	
	public static void main(String[] args) throws GiaAperte, GiaChiuse {
		Treno t = new Interregionale(50);
		Binario b = new BinarioSemplice(
		new BinarioScambio(
		new BinarioSemaforo(
		new BinarioSemplice(null), 30000),
		new BinarioStazione(null)));
		while(b != null)
		{
		// prossimo binario
		b = b.percorri(t);
		}
	}
}

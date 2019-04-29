/**
 * Errore in caso le porte siano gia chiuse e si cerca di chiuderle
 * @author Mazzotta
 *
 */
public class GiaChiuse extends Exception {
	
	public GiaChiuse() { System.out.println("Le porte sono già chiuse"); }
}

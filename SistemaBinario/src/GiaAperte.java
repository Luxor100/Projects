
/**
 * Errore in caso le porte siano gia aperte e si cerca di aprirle
 * @author Mazzotta
 *
 */
public class GiaAperte extends Exception {

	public GiaAperte() { System.out.println("Le porte sono già aperte"); }
}

package scartaParentesi;

/**
 * Contiene metodo che ricorsivamente gestisce una stringa e scrive il contenuto solo fuori dalle parentesi
 * @author Mazzotta
 *
 */
public class ScartaParentesi {

	/**
	 * Restituisce una stringa che contiene solo il testo fuori dalle parentesi
	 * @param stringa in input da gestire
	 * @return String che contiene il testo di stringa fuori dalle parentesi
	 */
	public String scartaParentesi(String stringa) {
		return scartaParentesi(stringa, 0, 0, "");
	}
	
	/**
	 * Pattern per la ricorsione, metodo private che gestisce scartaParentesi(String)
	 * @param stringa stringa da gestire
	 * @param n indice della stringa
	 * @param contaParentesi conta il numero di parentesi aperte
	 * @param stringaFinale String da restituire
	 * @return String con il contenuto di stringa fuori dalle parentesi
	 */
	private String scartaParentesi(String stringa, int n, int contaParentesi, String stringaFinale) {
		if (n == stringa.length()) return stringaFinale;
		if (stringa.charAt(n) == '(')	return scartaParentesi(stringa, ++n, ++contaParentesi, stringaFinale);
		if (stringa.charAt(n) == ')')	return scartaParentesi(stringa, ++n, --contaParentesi, stringaFinale);
		if (contaParentesi == 0)	return scartaParentesi(stringa, ++n, contaParentesi, stringaFinale+= stringa.charAt(n-1));
		return scartaParentesi(stringa, ++n, contaParentesi, stringaFinale);
	}
}

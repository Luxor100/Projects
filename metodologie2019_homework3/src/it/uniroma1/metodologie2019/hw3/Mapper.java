package it.uniroma1.metodologie2019.hw3;

/**
 * Fornisce una mappatura tra due diverse versioni di WorldNet
 * @author Mazzotta
 *
 */
public class Mapper {

	/**
	 * Presi in input due WordNet, restituisce un oggetto di tipo WordNetMapping che fornisce le mappature
	 * @param sourceNet WordNet sorgente
	 * @param targetNet WordNet destinazione
	 * @return oggetto di tipo WordNetMapping che fornisce le mappature
	 */
	public static WordNetMapping map(WordNet sourceNet, WordNet targetNet) {
		return new WordNetMapping(sourceNet, targetNet);
	}
}

package it.uniroma1.metodologie2019.hw3;

/**
 * Rappresenta la coppia di Synset sorgente e destinazione, con associato lo score della coppia
 * @author Mazzotta
 *
 */
public class SynsetPairing {

	/**
	 * Synset sorgente
	 */
	private Synset sourceSynset;
	/**
	 * Synset destinazione
	 */
	private Synset targetSynset;
	/**
	 * Score di confidenza della coppia
	 */
	private double score;
	
	/**
	 * Costruttore della classe SynsetPairing
	 * @param sourceSynset Synset sorgente
	 * @param targetSynset Synset destinazione
	 * @param score di confidenza della coppia
	 */
	public SynsetPairing(Synset sourceSynset, Synset targetSynset, double score) {
		this.sourceSynset = sourceSynset;
		this.targetSynset = targetSynset;
		this.score = score;
	}
	
	/**
	 * Restituisce il Synset sorgente
	 * @return Synset sorgente
	 */
	public Synset getSource() { return sourceSynset; }
	
	/**
	 * Restituisce il Synset destinazione
	 * @return Synset destinazione
	 */
	public Synset getTarget() { return targetSynset; }
	
	/**
	 * Restituisce lo score
	 * @return score
	 */
	public double getScore() { return score; }
}

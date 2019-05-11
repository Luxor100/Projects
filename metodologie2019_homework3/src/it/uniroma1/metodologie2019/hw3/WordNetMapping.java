package it.uniroma1.metodologie2019.hw3;

import java.util.Optional;

/**
 * Crea la mappatura tra due versioni di WordNet
 * @author Mazzotta
 *
 */
public class WordNetMapping {
	
	/**
	 * Score massimo
	 */
	private static final double MAX = 1.0;
	/**
	 * WordNet sorgente
	 */
	private WordNet sourceNet;
	/**
	 * WordNet destinazione
	 */
	private WordNet targetNet;
	
	/**
	 * Costruttore che associa WordNet sorgente e WordNet destinazione ai loro rispettivi campi
	 * @param sourceNet WordNet sorgente
	 * @param targetNet WordNet destinazione
	 */
	public WordNetMapping(WordNet sourceNet, WordNet targetNet) {
		this.sourceNet = sourceNet;
		this.targetNet = targetNet;
	}
	
	/**
	 * Dato un Synset nella versione sorgente, restituisce un Optional contenente un SynsetPairing 
	 * con Synset sorgente e il miglior Synset nella versione di destinazione
	 * @param sourceSynset Synset nella versione sorgente
	 * @return Optional SynsetPairing contenente il Synset sorgente e il Synset accoppiatogli
	 */
	public Optional<SynsetPairing> getMapping(Synset sourceSynset) {
		if (sourceNet.getSynsetFromID(sourceSynset.getID()) == null) return Optional.ofNullable(null);
		Synset synsetIfFound = targetNet.getSynsetFromID(sourceSynset.getID());
		if (synsetIfFound != null && sourceSynset.getGloss().equals(synsetIfFound.getGloss()) 
						&& sourceSynset.getExamples().equals(synsetIfFound.getExamples()) 
						&& sourceSynset.getWordList().equals(synsetIfFound.getWordList())) 
						return Optional.of(new SynsetPairing(sourceSynset, synsetIfFound, MAX));
		Optional<Synset> synsetIfEqual =	
			targetNet.stream()
			.parallel()
			.filter(s -> sourceSynset.getGloss().equals(s.getGloss()) && sourceSynset.getExamples().equals(s.getExamples()) 
						&& sourceSynset.getWordList().equals(s.getWordList()))
			.findAny();
		if (synsetIfEqual.isPresent()) return Optional.of(new SynsetPairing(sourceSynset, synsetIfEqual.get(), MAX));
		// sfida
		double maxValue = 0.0;
		Synset synsetBestScore = null;
		for (Synset targetSynset : targetNet) {
			double score = getScore(sourceSynset, targetSynset);
			if (score > maxValue) {
				maxValue = score;
				synsetBestScore = targetSynset;
			}
		}
		if (maxValue >= 0.66) return Optional.of(new SynsetPairing(sourceSynset, synsetBestScore, maxValue));
			
		return Optional.ofNullable(null);
	}
	
	/**
	 * Restituisce un double rappresentante lo score tra due Synset
	 * @param sourceSynset Synset sorgente
	 * @param targetSynset Synset destinazione
	 * @return double rappresentante lo score tra i due Synset
	 */
	private static double getScore(Synset sourceSynset, Synset targetSynset) {
		if (! sourceSynset.getPOS().equals(targetSynset.getPOS())) return 0.0;
		double score = 0.0;
		double wordContenute = 0.0;
		int maxContenute = 0;
		final int minLength = 3;
		for (String word : sourceSynset.getWordList())
			if (targetSynset.contains(word)) wordContenute++;
		if (wordContenute > 0) score += wordContenute/sourceSynset.getwordInSyn() * 0.33;
		wordContenute = 0.0;
		String[] arraySourceGloss = sourceSynset.getGloss().split(" ");
		for (int k = 0; k < arraySourceGloss.length; k++)
			if (arraySourceGloss[k].length() >= minLength) {
				maxContenute++;
				if (targetSynset.getGloss().contains(arraySourceGloss[k]))
					wordContenute++;
			}
		if (wordContenute > 0) score += wordContenute/maxContenute * 0.33;
		wordContenute = 0.0;
		maxContenute = 0;
		String esempiTarget = "";
		String esempiSource = "";
		for (String examples : targetSynset.getExamples())
			esempiTarget += examples+" ";
		for (String examples : sourceSynset.getExamples())
			esempiSource += examples+" ";
		String[] arrayExamplesSource = esempiSource.split(" ");
		for (int c = 0; c < arrayExamplesSource.length; c++)
			if (arrayExamplesSource[c].length() >= minLength) {
				maxContenute++;
				if (esempiTarget.contains(arrayExamplesSource[c]))
						wordContenute++;
			}
		if (wordContenute > 0) score += wordContenute/maxContenute * 0.33;
		return score;
	}
}

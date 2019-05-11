package it.uniroma1.metodologie2019.hw3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Classe incentrata sul concetto di Synset ovvero l'insieme
 * di sinonimi utilizzati per esprimere un concetto.
 * Fornisce informazioni come: offset, parte del discorso
 * sinonimi, glossa ed esempi
 * @author Mazzotta
 *
 */
public class WordNet implements Iterable<Synset> {

	/**
	 * Parte del path per caricare i file
	 */
	public static final String CARTELLA_INIZIALE = ".";
	/**
	 * Parte del path per caricare i file
	 */
	public static final String WORDNET_RELEASES = "wordnet-releases";
	/**
	 * Parte del path per caricare i file
	 */
	public static final String RELEASES = "releases";
	/**
	 * Parte del path per caricare i file
	 */
	public static final String DICT = "dict";
	/**
	 * Parte del path per caricare i file
	 */
	public static final String WORDNET = "Wordnet-";
	/**
	 * Parte del path per caricare i file
	 */
	public static final Path PATHFILE = Paths.get(CARTELLA_INIZIALE, WORDNET_RELEASES, RELEASES);
	
	/**
	 * Contiene le versioni di WordNet nel caso le medesime versioni siano gia' state create
	 */
	private static HashMap<String, WordNet> versioneInMemoriaEsistente = new HashMap<>();
	/**
	 * Versione del WordNet
	 */
	private String versione;
	/**
	 * HashMap contentenente come chiave l'ID del Synset e il Synset stesso come valore associato
	 */
	private HashMap<String, Synset> mappaRelazioni = new HashMap<>();
	/**
	 *  Lista dei Synset presenti nella versione caricata
	 */
	private List<Synset> listaSynset = new ArrayList<>();
	
	/**
	 * Costruttore di WordNet, load in memoria dei file data. in mappaRelazioni
	 * @param versione di WordNet da caricare
	 */
	public WordNet(String versione) {
		this.versione = versione;
		Path path = PATHFILE.resolve(WORDNET+versione).resolve(DICT);
		String[] arrayTipi = new String[] { "noun", "verb", "adj", "adv" };
		for (int i = 0; i < arrayTipi.length; i++) {
			try {
				Files.lines(path.resolve("data."+arrayTipi[i]))
					.filter(s -> ! s.startsWith(" "))
					.map(s -> s.split(" "))
					.map(array -> new Synset(array))
					.forEach(synset -> mappaRelazioni.put(synset.getID(), synset));
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		listaSynset = mappaRelazioni.values().stream()
			.collect(Collectors.toList());
		
		versioneInMemoriaEsistente.put(versione, this);
	}
	
	/**
	 * Data in input una versione, restituisce la corrispondente istanza di WordNet, se la versione non e' disponibile restituisce null
	 * @param versione di WordNet da caricare in memoria
	 * @return WordNet se la versione esiste e non e' stato fatto nessun altra chiamata di getIstance della stessa versione in precedenza, altrimenti la prima chiamata di getIstance, se la versione non esiste restituisce null 
	 */
	public static WordNet getInstance(String versione) {
		if (versioneInMemoriaEsistente.containsKey(versione)) 
			if (Files.exists(PATHFILE.resolve(WORDNET+versione))) return versioneInMemoriaEsistente.get(versione);
		if (Files.exists(PATHFILE.resolve(WORDNET+versione))) return new WordNet(versione);
		return null;
	}
	
	/**
	 * Restituisce la lista di Synset che contengono il lemma
	 * @param lemma che deve essere contenuto all'interno del Synset
	 * @return lista contenente i Synset che contengono il lemma
	 */
	public List<Synset> getSynsets(String lemma) {
		return this.stream()
				.filter(synset -> synset.getWordList().contains(lemma.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	/**
	 * Restituisce la lista di Synset che contengono il lemma e che hanno lo stesso tipo di POS dato in input
	 * @param lemma che deve essere contenuto all'interno del Synset
	 * @param tipo di POS
	 * @return lista contenente i Synset che contengono il lemma e hanno lo stesso POS dato in input
	 */
	public List<Synset> getSynsets(String lemma, POS tipo) {
		return getSynsets(lemma.toLowerCase()).stream()
				.filter(synset -> synset.getPOS().getTipo() == tipo.getTipo())
				.collect(Collectors.toList());
	}
	/**
	 * Restituisce il Synset corrispondente all'ID dato in input
	 * @param ID del Synset che si vuole restituire
	 * @return Synset con l'ID in input
	 */
	public Synset getSynsetFromID(String ID) { return mappaRelazioni.get(ID); }
	
	/**
	 * 	Restituisce uno stream di Synset
	 * @return stream di Synset
	 */
	public Stream<Synset> stream() { return listaSynset.stream(); }
	
	/**
	 * Restituisce la versione della WordNet
	 * @return versione della WordNet
	 */
	public String getVersion() { return versione; }
	
	/**
	 * Restituisce una collezione di Synset correlati al Synset dato in input secondo la relazione
	 * @param synset Synset da cui poi restituire i correlati
	 * @param stringa che definisce la relazione
	 * @return una collezione di Synset correlati dalla relazione e dal Synset dati in input
	 */
	public List<Synset> getRelatedSynsets(Synset synset, String stringa) {
		return synset.getSynsetsPuntati().stream()
				.filter(synsetPuntati -> synsetPuntati.startsWith(stringa))
				.map(synsetPuntati -> ! Character.isDigit(synsetPuntati.charAt(1)) ? synsetPuntati.substring(2, synsetPuntati.length()) : synsetPuntati.substring(1, synsetPuntati.length()))
				.map(mappaRelazioni::get)
				.collect(Collectors.toList());
	}
	
	/**
	 * Restituisce una collezione di Synset correlati al Synset dato in input secondo la relazione
	 * @param synset Synset da cui poi restituire i correlati
	 * @param enumerazione che definisce la relazione
	 * @return una collezione di Synset correlati dalla relazione e dal Synset dati in input
	 */
	public List<Synset> getRelatedSynsets(Synset synset, WordNetRelation enumerazione) { return getRelatedSynsets(synset, enumerazione.getRelazione()); }

	/**
	 * Implementazione dell'interfaccia Iterable Synset con classe anonima
	 */
	@Override
	public Iterator<Synset> iterator() {
		return new Iterator<Synset>() {
			
			/**
			 * Variabile locale per l'indice
			 */
			int indice = 0;
			
			/**
			 * true se contiene un altro elemento, false altrimenti
			 */
			@Override
			public boolean hasNext() {
				return listaSynset.size() > indice;
			}
			
			/**
			 * Restituisce il seguente Synset della lista fino a che ne contiene
			 */
			@Override
			public Synset next() {
				while(hasNext()) 
					return listaSynset.get(indice++);
				return null;
			}
		};
	}
}

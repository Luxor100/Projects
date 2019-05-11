package it.uniroma1.metodologie2019.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe che rappresenta un Synset, un insieme di sinonimi che sono utilizzati per esprimere un concetto
 * @author Mazzotta
 *
 */
public class Synset {

	/**
	 * offset, formato da 8 cifre
	 */
	private String offset;
	/**
	 * Numero del file in cui e' presente il Synset, formato da 2 cifre
	 */
	private int fileNum;
	/**
	 * Tipo della parte del discorso, 1 char
	 */
	private POS pos;
	/**
	 * Numero di parole nel Synset
	 */
	private int wordInSyn;
	/**
	 * Lista delle parole nel Synset, tutte in lowerCase
	 */
	private List<String> wordList = new ArrayList<>();
	/**
	 * Numero di puntatori ad altre parole
	 */
	private int countPuntatori;
	/**
	 * Lista dei Synset puntati all'interno del Synset, del formato relazione+ID es. "@82738495n"
	 */
	private List<String> synsetPuntati = new ArrayList<>();
	/**
	 * Glossa appartenente al Synset
	 */
	private String glossa = "";
	/**
	 * Lista degli esempi all'interno del Synset
	 */
	private List<String> esempi = new ArrayList<>();
	/**
	 * ID univoco del Synset, formato da offset+pos
	 */
	private String ID;
	/**
	 * Contatore utile al costruttore per scorrere l'array
	 */
	private int indice = 0;
	/**
	 * Array su cui itera il costruttore, dato da String.split(" ") dalla linea del file letto in memoria
	 */
	private Object[] array;
	
	/**
	 * Costruttore della classe Synset, itera su un array dato in input
	 * @param arrayFromSplit dato da String.split(" ") dalla linea del file letto in memoria
	 */
	public Synset(Object[] arrayFromSplit) {
		this.array = Arrays.copyOf(arrayFromSplit, arrayFromSplit.length);
		offset = (String)array[indice++];
		fileNum = Integer.parseInt((String) array[indice++]);
		setPOS();
		wordInSyn = Integer.parseInt((String) array[indice++], 16);
		setWordList();
		countPuntatori = Integer.parseInt((String) array[indice++]);
		setSinonimi();
		setGlossa();
		setEsempi();
		ID = ""+offset+pos.getTipo();
	}
	
	/**
	 * Restituisce l'insieme dei sinonimi del Synset
	 * @return Insieme List dei sinonimi del Synset
	 */
	public List<String> getSynonyms() { return wordList; }
	
	/**
	 * Restituisce true se il Synset contiene quella parola, false altrimenti
	 * @param parola da cercare nel Synset
	 * @return true se il Synset contiene la parola
	 */
	public boolean contains(String parola) { return wordList.contains(parola); }
	
	/**
	 * Restituisce la glossa del Synset
	 * @return glossa del Synset
	 */
	public String getGloss() {	return glossa; }
	
	/**
	 * Restituisce l'insieme degli esempi del Synset
	 * @return l'insieme degli esempi del Synset
	 */
	public List<String> getExamples() { return esempi; }
	
	/**
	 * Restituisce l'offset(8 interi decimali) del Synset
	 * @return offset del Synset
	 */
	public String getOffset() { return offset; }
	
	/**
	 * Restituisce l'ID del Synset
	 * @return ID del Synset
	 */
	public String getID() { return ID; }
	
	/**
	 * Restituisce il campo POS del Synset
	 * @return pos del Synset
	 */
	public POS getPOS() { return pos; }
	
	/**
	 * Restituisce il campo synsetPuntati del Synset
	 * @return synsetPuntati del synset
	 */
	public List<String> getSynsetsPuntati() { return synsetPuntati; }
	
	/**
	 * Getter del campo wordList, restituisce il campo wordList
	 * @return campo wordList
	 */
	public List<String> getWordList() { return wordList; }
	
	/**
	 * Restituisce il numero di parole nel Synset, campo wordInSyn
	 * @return numero di parole nel Synset, wordInSyn
	 */
	public int getwordInSyn() { return wordInSyn; }
	
	/**
	 * Dato un valore char, restituisce il POS corrispondente
	 */
	private void setPOS() { 
		switch (((String)array[indice++]).charAt(0)) {
			case 'n': pos = POS.NOUN; break;
			case 'v': pos = POS.VERB; break;
			case 'a': pos = POS.ADJECTIVE; break;
			case 's': pos = POS.ADJECTIVE; break;
			case 'r': pos = POS.ADVERB; break;
		}
	}
	
	/**
	 * Controlla il numero di parole presenti nel Synset
	 * tramite wordInSyn e aggiunge n parole tutte in lowerCase
	 * nella lista wordList
	 */
	private void setWordList() {
		for (int j = 0; j < wordInSyn; j++) {
			wordList.add(((String)array[indice]).toLowerCase());
			indice+= 2;
		}
	}
	
	/**
	 * Controlla il numero di puntatori presenti nel Synset
	 * tremite countPuntatori e aggiunge n puntatori
	 * nella lista synsetPuntati
	 */
	private void setSinonimi() {
		for (int i = 0; i < countPuntatori; i++) {
			synsetPuntati.add(""+array[indice++]+array[indice++]+array[indice++]);
			indice++;
		}
	}
	
	/**
	 * Set della glossa del Synset
	 */
	private void setGlossa() {
		outerLoop:
			for (--indice; indice < array.length; indice++)
				if (((String)array[indice]).equals("|")) {
					for (++indice; indice < array.length; indice++) {
						String s = (String)array[indice];
						if (s.endsWith(";") || s.endsWith(":")) { // ":" per la sfida
							if (indice+1 < array.length && ((String)array[indice+1]).startsWith("\"")) {
								glossa+= s;
								break outerLoop;
							}
						}
						glossa+= s+" ";
					}
				};
			glossa = glossa.substring(0, glossa.length()-1);
	}
	
	/**
	 * Set degli esempi del Synset
	 */
	private void setEsempi() {
		String stringaEsempi = "";
		for (++indice; indice < array.length; indice++)	{
			 stringaEsempi += " "+array[indice];
			 if (stringaEsempi.endsWith(";")) {
				esempi.add(stringaEsempi.substring(1, stringaEsempi.length()-1).replace("\"", ""));
				stringaEsempi = "";
			 }
		}
		if (! stringaEsempi.equals("")) esempi.add(stringaEsempi.substring(1, stringaEsempi.length()).replace("\"", ""));
		
	}
}

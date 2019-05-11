package it.uniroma1.metodologie2019.hw3;

/**
 * Enum che contiene i tipi dei synset: noun, verb, adjective, adjective satellite, adverb
 * @author Mazzotta
 *
 */
public enum POS {
	
	NOUN('n'),
	VERB('v'),
	ADJECTIVE('a'),
	ADVERB('r');
	
	/**
	 * carattere associato da WordNet alla parte del discorso
	 */
	private char tipo;
	
	/**
	 * Costruttore della classe che associa l'input al campo tipo
	 * @param tipo char che fa parte dei carattere prestabiliti da WordNet per rappresentare una parte del discorso
	 */
	POS(char tipo) { this.tipo = tipo; }
	
	/**
	 * getter della variabile tipo
	 * @return il tipo dell'enum
	 */
	public char getTipo() { return tipo; }
}

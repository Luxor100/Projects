package it.uniroma1.metodologie2019.hw3;

/**
 * Enum che contiene le informazioni sui tipi di relazioni del Synset, espandibile tramite l'interfaccia WordNetRelation
 * @author Mazzotta
 *
 */
public enum Relazioni implements WordNetRelation {

	ANTONYM("!"),
	HYPERNYM("@"),
	ISTANCE_HYPERNYM("@i"),
	HYPONYM("~"),
	INSTANCE_HYPONYM("~i"),
	MEMBER_HOLONYM("#m"),
	SUBSTANCE_HOLONYM("#s"),
	PART_HOLONYM("#p"),
	MEMBER_MEMORYN("%m"),
	SUBSTANCE_MERONYM("%s"),
	PART_MERONYM("%p"),
	ATTRIBUTE("="),
	DERIVATIONALLY_RELATED_FORM("+"),
	DOMAIN_OF_SYNSET_TOPIC(";c"),
	MEMBER_OF_THIS_DOMAIN_TOPIC("-c"),
	DOMAIN_OF_SYNSET_REGION(";r"),
	MEMBER_OF_THIS_DOMAIN_REGION("-r"),
	DOMAIN_OF_SYNSET_USAGE(";u"),
	MEMBER_OF_THIS_DOMAIN_USAGE("-u"),
	ENTAILMENT("*"),
	CAUSE(">"),
	SEE_ALSO("^"),
	VERB_GROUP("$"),
	SIMILAR_TO("&"),
	PARTICIPLE_OF_VERB("<"),
	PERTAINYM("\\");
	
	/**
	 * Simbolo associato alla relazione
	 */
	private String simbolo;
	
	/**
	 * Costruttore della classe che associa l'input al tipo
	 * @param simbolo associato alla relazione 
	 */
	Relazioni(String simbolo) { this.simbolo = simbolo; }
	
	/**
	 * Ritorna il simbolo associato alla relazione
	 */
	@Override
	public String getRelazione() { return simbolo; }
}

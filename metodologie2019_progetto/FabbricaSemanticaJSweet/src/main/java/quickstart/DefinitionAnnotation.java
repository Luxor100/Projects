package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 *  Classe che definisce la costruzione del task definitionAnnotation.
 * Data una parola e un suo iperonimo (ovvero, una sua generalizzazione, ad es. veicolo come iperonimo di macchina), 
 * l’utente deve fornire una definizione nella sua lingua.
 * 
 * @author Mazzotta
 *
 *
 */
public class DefinitionAnnotation extends HTMLPageAnnotation {
	/**
	 * Link per il pulsante submit
	 */
	public static final String SERVLET_URL = "definitionAnnotation.jsp";
	/**
	 * Descrizione del task della pagina
	 */
	public static final String S_TASK = "Data la parola e un suo iperonimo "
									+ "(ovvero, una sua generalizzazione, ad es. veicolo come iperonimo di macchina), "
									+ "fornire una definizione.";
	
	/**
	 * Parola presa dal back-end come esempio
	 */
	private HTMLLabelElement word;
	/**
	 * Iperonimo preso dal back-end come esempio
	 */
	private HTMLLabelElement hypernym;
	/**
	 * Input dell'utente
	 */
	private HTMLInputElement respons;
	/**
	 * Div della pagina
	 */
	private HTMLDivElement pageDiv;
	
	public DefinitionAnnotation() {
		super();
		
		setServlet(SERVLET_URL);
		
		setTask(S_TASK);
		
		word = createWord();
		
		hypernym = createDescription();
		
		respons = createInputText("respons", false);
		respons.placeholder = "Scrivi la definizione qui...";
	
		setPage();
		
		pageDiv = createDiv();
		$(pageDiv).append(word, hypernym, respons);
		$(getForm()).append(pageDiv, getDivButtons());
		$("body").append(getForm());
	}
	
	@Override
	public void setPage() {
		$.getJSON(REST_URL, "task=DEFINITION_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sHypernym = json.$get("hypernym");
			$(word).text(sWord);
			$(hypernym).text(sHypernym);
			return null;
		});
	}
	
	public static void main(String[] args) {
		new DefinitionAnnotation();
	}
}

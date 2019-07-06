package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
/**
 * Classe che definisce la costruzione del task traslationAnnotation.
 * Data una parola e una sua definizione in inglese, l’utente deve fornire una traduzione nella sua lingua madre.
 * 
 * @author Mazzotta
 * 
 */
public class TranslationAnnotation extends HTMLPageAnnotation {

	/**
	 * Link per il pulsante submit
	 */
	public static final String SERVLET_URL = "translationAnnotation.jsp";
	/**
	 * Descrizione del task della pagina
	 */
	public static final String S_TASK = "Data la parola e una sua definizione in inglese, fornire una traduzione.";
	
	/**
	 * Parola presa dal back-end come esempio
	 */
	private HTMLLabelElement word;
	/**
	 * Descrizione presa dal back-end come esempio
	 */
	private HTMLLabelElement description;
	/**
	 * Input dell'utente
	 */
	private HTMLInputElement response;
	/**
	 * Div della pagina
	 */
	private HTMLDivElement divPage;
	
	public TranslationAnnotation() {
		super();
		
		setServlet(SERVLET_URL);
		
		setTask(S_TASK);
		
		word = createWord();
		
		description = createDescription();
		
		response = createInputText("respons", false);
		response.placeholder = "Scrivi la traduzione qui...";
		
		setPage();
		
		divPage = createDiv();
		$(divPage).append(word, description, response);
		
		$(getForm()).append(divPage);
		$(getForm()).append(getDivButtons());
		$("body").append(getForm());
	}
	
	@Override
	public void setPage() {
		$.getJSON(REST_URL, "task=TRANSLATION_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sDescription = json.$get("description");
			$(word).text(sWord);
			$(description).text(sDescription);
			return null;
		});
	}
	
	public static void main(String[] args) {
		new TranslationAnnotation();
	}
}

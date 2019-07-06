package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
/**
 * Classe che definisce la costruzione del task wordAnnotation.
 * Data una definizione in inglese, l’utente deve provare a indovinare la parola definita.
 * 
 * @author Mazzotta
 * 
 */
public class WordAnnotation extends HTMLPageAnnotation{

	/**
	 * Link per il tasto submit
	 */
	public static final String SERVLET_URL = "wordAnnotation.jsp";
	/**
	 * Descrizione del task della pagina
	 */
	public static final String S_TASK = "Data la definizione in inglese, provare ad indovinare la parola definita.";
	
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
	
	public WordAnnotation() {
		super();
		
		setServlet(SERVLET_URL);
		
		setTask(S_TASK);
		
		description = createDescription();
		
		response = createInputText("respons", false);
		response.placeholder = "Indovina la parola qui...";
		
		setPage();
		
		divPage = createDiv();
		$(divPage).append(description, response);
		$(getForm()).append(divPage);
		$(getForm()).append(getDivButtons());
		
		$("body").append(getForm());
	}
	
	@Override
	public void setPage() {
		$.getJSON(REST_URL, "task=WORD_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sDescription = json.$get("description");
			$(description).text(sDescription);
			return null;
		});
	}
	
	public static void main(String[] args) {
		new WordAnnotation();
	}
}

package quickstart;

import static def.jquery.Globals.$;
import java.util.ArrayList;
import java.util.List;

import def.dom.HTMLDivElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
/**
 * Classe che definisce la costruzione del task senseAnnotation.
 * Data una parola e una frase in cui la parola appare, l’utente deve selezionare il senso appropriato.
 * 
 * @author Mazzotta
 *
 */
public class SenseAnnotation extends HTMLPageAnnotation {
	/**
	 * Link per il pulsante submit
	 */
	public static final String SERVLET_URL = "senseAnnotation.jsp";
	/**
	 * Descrizione del task della pagina
	 */
	public static final String S_TASK = "Data la parola e una frase in cui la parola appare, selezionare il senso appropriato.";
	
	/**
	 * Parola presa dal back-end come esempio
	 */
	private HTMLLabelElement word;
	/**
	 * Descrizione presa dal back-end come esempio
	 */
	private HTMLLabelElement description;
	/**
	 * Div per le checkbox della pagina
	 */
	private HTMLDivElement checkboxDiv;
	/**
	 * Div della pagina
	 */
	private HTMLDivElement pageDiv;
	/**
	 * Lista contenente i label per le checkbox
	 */
	private List<HTMLLabelElement> listaLabel = new ArrayList<>();
	
	public SenseAnnotation() {
		super();
		
		setServlet(SERVLET_URL);
		
		setTask(S_TASK);
		
		word = createWord();
		
		description = createDescription();
		
		checkboxDiv = createDiv();
		
		setPage();
		
		pageDiv = createDiv();
		$(pageDiv).append(word, description);
		
		$(getForm()).append(pageDiv);
		$(getForm()).append(checkboxDiv);
		$(getForm()).append(getDivButtons());
		$("body").append(getForm());
	}
	
	@Override
	public void setPage() {
		$.getJSON(REST_URL, "task=SENSE_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sDescription = json.$get("description");
			String[] sSenses = json.$get("senses");
				
			//n label quanti n senses
			for (int k = 0; k < sSenses.length; k++) {
				HTMLLabelElement labelSenses = createLabel("");
				labelSenses.className = "form-check-label";
				$(labelSenses).text(sSenses[k]);
				listaLabel.add(labelSenses);
			}
			
			int j = 1;
			
			$(word).text(sWord);
			$(description).text(sDescription);
			
			//n checkbox quanti n label
			for (HTMLLabelElement label : listaLabel) {
				$(checkboxDiv).append(label, createInputCheckbox(""+j++));
				$(checkboxDiv).append(createDiv());
			}
			return null;
		});
	}
	
	public static void main(String[] args) {
		new SenseAnnotation();
	}
}

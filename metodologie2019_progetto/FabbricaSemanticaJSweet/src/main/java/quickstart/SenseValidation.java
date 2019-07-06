package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
/**
 * Classe che definisce la costruzione del task senseValidation.
 * Data una parola e una frase in cui appare, l’utente deve verificare se il senso fornito dal sistema è appropriato.
 * 
 * @author Mazzotta
 * 
 */
public class SenseValidation extends HTMLPageAnnotation{

	/**
	 * Link per il pulsante submit
	 */
	public static final String SERVLET_URL = "senseValidation.jsp";
	/**
	 * Descrizione del task della pagina
	 */
	public static final String S_TASK = "Data la parola e una frase in cui appare, "
								+ "verificare se il senso fornito dal sistema è appropriato.";
	
	/**
	 * Parola presa dal back-end come esempio
	 */
	private HTMLLabelElement word;
	/**
	 * Esempio preso dal back-end come esempio
	 */
	private HTMLLabelElement example;
	/**
	 * Senso preso dal back-end come esempio
	 */
	private HTMLLabelElement sense;
	/**
	 * Div della pagina
	 */
	private HTMLDivElement pageDiv;
	/**
	 * Div dei pulsanti radio
	 */
	private HTMLDivElement radioDiv;
	/**
	 * Label per il pulsante radio no
	 */
	private HTMLLabelElement noLabel;
	/**
	 * Label per il pulsante radio si
	 */
	private HTMLLabelElement yesLabel;
	/**
	 * Pulsante radio si
	 */
	private HTMLInputElement radioButtonYes;
	/**
	 * Pulsante radio no
	 */
	private HTMLInputElement radioButtonNo;
	
	public SenseValidation() {
		super();
		
		setServlet(SERVLET_URL);
		
		setTask(S_TASK);
		
		word = createWord();
		
		example = createDescription();
		
		sense = createLabel("");
		
		setPage();
		
		pageDiv = createDiv();
		
		radioButtonYes = createInputRadio("optradio", "radioButtonYes");
		
		radioButtonNo = createInputRadio("optradio", "radioButtonNo");
		radioButtonNo.style.position = "relative";
		radioButtonNo.style.left = "10px";
		
		yesLabel = createLabel("Si");
		
		noLabel = createLabel("No");
		noLabel.style.position = "relative";
		noLabel.style.left = "10px";
		
		radioDiv = createDiv();
		radioDiv.className = "form-check-inline";
		$(radioDiv).append(yesLabel, radioButtonYes, noLabel, radioButtonNo);
		
		$(pageDiv).append(word, example, sense);
		$(getForm()).append(pageDiv, radioDiv, createDiv(), getDivButtons());
		
		
		getNext().onclick = (e -> {
			if (radioButtonYes.checked) radioButtonYes.name = "si";
			else radioButtonNo.name = "no";
			return e;
		});
		
		$("body").append(getForm());
	}
	
	@Override
	public void setPage() {
		$.getJSON(REST_URL, "task=SENSE_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sExample = json.$get("example");
			String sSense = json.$get("sense");
			$(word).text(sWord);
			$(example).text(sExample);
			$(sense).text(sSense);
			return null;
		});
	}
	
	public static void main(String[] args) {
		new SenseValidation();
	}
}

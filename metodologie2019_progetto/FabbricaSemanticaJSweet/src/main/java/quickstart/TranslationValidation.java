package quickstart;

import static def.jquery.Globals.$;

import java.util.ArrayList;
import java.util.List;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
/**
 * Classe che definisce la costruzione del task traslationValidation.
 * Data una parola e una sua definizione in inglese, l’utente deve scegliere la miglior traduzione tra quelle fornite o specificare <nessuna>.
 * 
 * @author Mazzotta
 * 
 */
public class TranslationValidation extends HTMLPageAnnotation {
	
	/**
	 * Link per il pulsante submit
	 */
	public static final String SERVLET_URL = "translationValidation.jsp";
	/**
	 * Descrizione del task della pagina
	 */
	public static final String S_TASK = "Data la parola e una sua definizione in inglese, "
							+ "scegliere la miglior traduzione tra quelle fornite o specificare <nessuna>.";
	
	/**
	 * Parola presa dal back-end come esempio
	 */
	private HTMLLabelElement word;
	/**
	 * Descrizione presa dal back-end come esempio
	 */
	private HTMLLabelElement description;
	/**
	 * Div della pagina
	 */
	private HTMLDivElement divPage;
	/**
	 * Div dei Label per le checkbox
	 */
	private HTMLDivElement divLabelCheckbox;
	/**
	 * Label per nessunaCheckbox
	 */
	private HTMLLabelElement nessuna;
	/**
	 * Checkbox per l'opzione nessuna
	 */
	private HTMLInputElement nessunaCheckbox;
	/**
	 * Lista contenente i label per le checkbox
	 */
	private List<HTMLLabelElement> listaLabel = new ArrayList<>();
	
	public TranslationValidation() {
		
		setServlet(SERVLET_URL);
		
		setTask(S_TASK);
		
		word = createWord();
		
		description = createDescription();
		
		divPage = createDiv();
		divLabelCheckbox = createDiv();
		
		setPage();
		
		$(divPage).append(word, description);
		
		$(getForm()).append(divPage, divLabelCheckbox, getDivButtons());
		$("body").append(getForm());
	}
	
	@Override
	public void setPage() {
		$.getJSON(REST_URL, "task=TRANSLATION_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sDescription = json.$get("description");
			String[] sTranslations = json.$get("translations");
			$(word).text(sWord);
			$(description).text(sDescription);
			//n label quanti n traslations
			for (int k = 0; k < sTranslations.length; k++) {
				HTMLLabelElement labelTranslations = createLabel("");
				labelTranslations.className = "form-check-label";
				$(labelTranslations).text(sTranslations[k]);
				listaLabel.add(labelTranslations);
			}
			//n checkbox quanti n label
			int j = 0;
			for (HTMLLabelElement label : listaLabel) {
				$(divLabelCheckbox).append(label, createInputCheckbox(""+j++));
				$(divLabelCheckbox).append(createDiv());
			}
			
			nessuna = createLabel("Nessuna");
			nessuna.className = "form-check-label";
			nessunaCheckbox = createInputCheckbox("nessuna");
			$(divLabelCheckbox).append(nessuna, nessunaCheckbox, createDiv());
			
			return null;
		});
	}
	
	public static void main(String[] args) {
		new TranslationValidation();
	}
}

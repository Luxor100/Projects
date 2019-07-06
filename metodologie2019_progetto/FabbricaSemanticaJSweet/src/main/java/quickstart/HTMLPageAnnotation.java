package quickstart;

import static def.jquery.Globals.$;
import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
/**
 * Classe che definisce la costruzione delle pagine di annotazione/validazione.
 * Aggiunge ad ognuna di esse i pulsanti next e skip
 * 
 * @author Mazzotta
 * 
 */
public abstract class HTMLPageAnnotation extends HTMLPage{
	/**
	 * Link utilizzato dalle pagine nel metodo setPage()
	 */
	public static final String REST_URL = "nextExample.jsp";
	
	/**
	 * Pulsante next, fa submit e porta al prossimo task
	 */
	private HTMLInputElement next;
	/**
	 * Pulsante skip, porta al prossimo task
	 */
	private HTMLInputElement skip;
	/**
	 * Label per la descrizione dei task di ciascuna pagina
	 */
	private HTMLLabelElement task;
	/**
	 * Div per task
	 */
	private HTMLDivElement divTask;
	/**
	 * Div per pulsante next e skip
	 */
	private HTMLDivElement divButtons;
	
	public HTMLPageAnnotation() {
		super();
		
		next = createInputSubmit("next", "next");
		skip = createInputSubmit("skip", "skip");
		skip.style.cssFloat = "right";
		skip.onclick = e -> {
			setRandomServlet();
			return e;
		};
		task = createLabel("");
		task.setAttribute("style", "font-weight:550");
		divTask = createDiv();
		$(divTask).append(task);
		$(getForm()).append(divTask);
		divButtons = createDiv();
		divButtons.className = "form-group";
		$(divButtons).append(next, skip);
	}
	
	/**
	 * Metodo che definisce la costruzione degli esempi della pagina
	 */
	public abstract void setPage();
	
	/**
	 * Setta il text del label task
	 * @param s String per il text del label task
	 */
	public void setTask(String s) { $(task).text(s); };
	
	/**
	 * Getter di next
	 * @return next
	 */
	public HTMLInputElement getNext() { return next; }
	
	/**
	 * Getter di DivButtons
	 * @return DivButtons
	 */
	public HTMLDivElement getDivButtons() { return divButtons; }
}

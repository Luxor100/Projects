package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

import static jsweet.util.Lang.function;

import java.util.ArrayList;
import java.util.List;

import static def.dom.Globals.setInterval;


/**
 * Classe che definisce la costruzione del task senseValidation.
 * Date delle parole, l'utente deve tradurne il piu' possibile in un minuto
 * @author Mazzotta
 *
 */
public class MyAnnotation extends HTMLPageAnnotation {

	/**
	 * Link per il pulsante submit
	 */
	public static final String SERVLET_URL = "myAnnotation.jsp";
	/**
	 * Descrizione del task della pagina
	 */
	public static final String S_TASK = "Time Attack! Traduci quante piu' parole in un minuto!";
	
	/**
	 * Input dell'utente
	 */
	private HTMLInputElement response;
	/**
	 * Label del timer
	 */
	private HTMLLabelElement countdown;
	/**
	 * bottone invia per l'input dell'utente
	 */
	private HTMLInputElement button;
	/**
	 * Div contente response e button
	 */
	private HTMLDivElement divResponse;
	/**
	 * Label per le risposte dell'utente
	 */
	private HTMLLabelElement[] labels = { createWord(), createWord(), createWord(), createWord(), createWord(),
										createWord(), createWord(), createWord(), createWord(), createWord()};
	/**
	 * Div contenente le parole da tradurre
	 */
	private HTMLDivElement divLabel1;
	/**
	 * Risposte dell'utente
	 */
	private List<HTMLInputElement> responses = new ArrayList<>();
	
	/**
	 * int per il timer
	 */
	private int time = 60;
	/**
	 * true se time = 0;
	 */
	private boolean done = false;
	/**
	 * int per la creazione dei label dopo l'input dell'utente
	 */
	private int n = 0;
	
	public MyAnnotation() {
		super();
		
		setServlet(SERVLET_URL);
		
		setTask(S_TASK);
		
		countdown = createLabel("60");
		countdown.style.fontSize = "70px";
		countdown.style.position = "relative";
		countdown.style.left = "600px";
		
		setInterval(function(this::countDown), 1000);
		
		response = createInputText("response", false);
		
		button = createInputSubmit("button", "Invia");
		button.onclick = (e -> {
			if (done) { e.preventDefault();
						return e; }
			else { responses.add(createHiddenInputText("input"+(n++), response.value));
					response.value = "";
					e.preventDefault(); 
					return e;
			}
		});
		
		setPage();
		
		setLabels();
		
		divResponse = createDiv();
		$(divResponse).append(response, button);
		
		$(getForm()).append(countdown);
		$(getForm()).append(divLabel1);
		$(getForm()).append(divResponse);
		$(getForm()).append(getDivButtons());
		
		getNext().onclick = (e -> {
			for (HTMLInputElement input : responses)
				$(getForm()).append(input);
			return e;
		});
		
		
		
		$("body").append(getForm());
	}
	
	@Override
	public void setPage() {
		$.getJSON(REST_URL, "task=MY_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String[] sWords = json.$get("words");
			for (int k = 0; k < 10; k++)
				$(labels[k]).text(sWords[k]);
			return null;
		});
	}
	
	/**
	 * Metodo per il countdown del timer, arrivato a 0 cambia in tempo scaduto
	 */
	private void countDown() {
		countdown.innerHTML = time+"";
		time--;
		if (time <= 0) {
			countdown.innerHTML = "Tempo Scaduto";
			countdown.style.color = "red";
			countdown.style.fontSize = "50px";
			countdown.style.left = "420px";
			done = true;
		}
	}

	/**
	 * Metodo che insieme a setPage() setta gli esempi per la pagina
	 */
	private void setLabels() {
		divLabel1 = createDiv();
		divLabel1.className = "form-check-inline";
		for (int k = 0; k < 10; k++) {
			labels[k].style.marginLeft = "75px";
			$(divLabel1).append(labels[k]);
		}
	}
	
	public static void main(String[] args) {
		new MyAnnotation();
	}
}

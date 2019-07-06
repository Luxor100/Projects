package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLOptionElement;
import def.dom.HTMLSelectElement;
import jsweet.util.StringTypes;

/**
 *  Classe astratta che crea il form per tutte le pagine html.
 *  Aggiunge il div in cima alle pagine con titolo e sfondo.
 * 
 * @author Mazzotta
 *
 */
public abstract class HTMLPage {

	/**
	 * Pagine html per il pulsante skip
	 */
	public static final String[] arrayIndirizzi = new String[] { "translationAnnotation.html", "wordAnnotation.html", "definitionAnnotation.html",
																"senseAnnotation.html", "translationValidation.html", "senseValidation.html",
																"myAnnotation.html"};
	/**
	 * Regex per la verifica delle email
	 */
	public static final String REGEX_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\""
										+ "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\"
										+ "x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])"
										+ "?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|"
										+ "1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a"
										+ "\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

	
	/**
	 * form delle pagine html
	 */
	private HTMLFormElement form;
	/**
	 * div contenente titolo, sfondo e logout
	 */
	private HTMLDivElement divTopBar;
	/**
	 * titolo con link alla home
	 */
	private HTMLAnchorElement anchorFabbricaSemantica;
	/**
	 * link alla pagina di logout
	 */
	private HTMLAnchorElement logout;
	
	public HTMLPage() {
		
		form = createForm();
		
		divTopBar = createDiv();
		divTopBar.style.backgroundColor = "#00C196";
		divTopBar.style.height = "50px";
		
		anchorFabbricaSemantica = createAnchor("FabbricaSemantica", "home.html");
		
		anchorFabbricaSemantica.setAttribute("style", "font-weight:bold");
		$(anchorFabbricaSemantica).css("color", "#000000");
		anchorFabbricaSemantica.style.fontSize = "35px";
		anchorFabbricaSemantica.style.position = "relative";
		anchorFabbricaSemantica.style.top = "7px";
		anchorFabbricaSemantica.style.borderBottomColor = "none";
		
		logout = createAnchor("Logout", "logout.jsp");
		logout.style.cssFloat = "right";
		logout.style.fontSize = "22px";
		logout.style.position = "relative";
		logout.style.top = "7px";
		
		anchorFabbricaSemantica.appendChild(logout);
		
		$(divTopBar).append(anchorFabbricaSemantica);
		$(form).append(divTopBar);
		$(form).css("margin", "0% 1.5%");
	}
	
	/**
	 * Crea un form
	 * @return HTMLFormElement form
	 */
	public HTMLFormElement createForm() {
		HTMLFormElement form = document.createElement(StringTypes.form);
		form.method = "POST";
		return form;
	}
	
	/**
	 * Setter del campo action di un form
	 * @param s link per il pulsante submit
	 */
	public void setServlet(String s) { form.action = s; }
	
	/**
	 * Crea un label
	 * @param s text del label
	 * @return HTMLLabelElement label
	 */
	public HTMLLabelElement createLabel(String s) {
		HTMLLabelElement label = document.createElement(StringTypes.label);
		label.className =  "form-control-plaintext";
		$(label).text(s);
		return label;
	}
	
	/**
	 * Crea un div
	 * @return div
	 */
	public HTMLDivElement createDiv() {
		HTMLDivElement div = document.createElement(StringTypes.div);
		div.className = "form-group";
		return div;
	}
	
	/**
	 * Crea un input di testo
	 * @param name nome dell'oggetto
	 * @param b required
	 * @return HTMLInputElement text
	 */
	public HTMLInputElement createInputText(String name, boolean b) {
		HTMLInputElement text = document.createElement(StringTypes.input);
		text.name = name;
		text.type = "text";
		text.style.backgroundColor = "white";
		text.style.color = "black";
		text.style.height = "22px";
		text.style.width = "300px";
		text.required = b;
		return text;
	}
	
	/**
	 * Crea un input per il submit
	 * @param id del submit
	 * @param value testo del pulsante
	 * @return HTMLInputElement submit
	 */
	public HTMLInputElement createInputSubmit(String id, String value) {
		HTMLInputElement submit = document.createElement(StringTypes.input);
		submit.type = "submit";
		submit.id = id;
		submit.className =  "btn btn-primary";
		submit.value = value;
		submit.style.backgroundColor = "#00C196";
		submit.style.borderColor = "black";
		submit.style.color = "black";
		return submit;
	}
	
	/**
	 * Crea una checkbox
	 * @param name nome della checkbox
	 * @return HTMLInputElement checkbox
	 */
	public HTMLInputElement createInputCheckbox(String name) {
		HTMLInputElement checkbox = document.createElement(StringTypes.input);
		checkbox.type = "checkbox";
		checkbox.name = name;
		return checkbox;
	}
	
	/**
	 * Crea un link anchor
	 * @param text testo del link
	 * @param link link
	 * @return HTMLAnchorElement anchor
	 */
	public HTMLAnchorElement createAnchor(String text, String link) {
		HTMLAnchorElement anchor = document.createElement(StringTypes.a);
		anchor.text = text;
		anchor.href = link;
		return anchor;
	}
	
	/**
	 * Crea un'immagine con un link
	 * @param src immagine
	 * @param height altezza
	 * @param width larghezza
	 * @return HTMLInputElement image
	 */
	public HTMLInputElement createInputImg(String src, String height, String width) {
		HTMLInputElement img = document.createElement(StringTypes.input);
		img.type = "image";
		img.src = src;
		img.style.height = height;
		img.style.width = width;
		return img;
	}
	
	/**
	 * Crea un pulsante radio
	 * @param name nome del pulsante
	 * @param id id del pulsante
	 * @return HTMLInputElement radio
	 */
	public HTMLInputElement createInputRadio(String name, String id) {
		HTMLInputElement radio = document.createElement(StringTypes.input);
		radio.type = "radio";
		radio.name = name;
		radio.id = id;
		return radio;
	}
	
	/**
	 * Crea un input di testo nascosto
	 * @param name nome dell'oggetto
	 * @return HTMLInputElement password
	 */
	public HTMLInputElement createInputPassword(String name) {
		HTMLInputElement password = document.createElement(StringTypes.input);
		password.type = "password";
		password.name = name;
		password.style.backgroundColor = "white";
		password.style.color = "black";
		password.style.height = "22px";
		password.style.width = "300px";
		password.required = true;
		return password;
	}
	
	/**
	 * Setta come servlet uno degli elementi di arrayIndirizzi
	 */
	public void setRandomServlet() {
		int n = (int) (Math.random()*(arrayIndirizzi.length));
		setServlet(arrayIndirizzi[n]);
	}
	
	/**
	 * Crea un label per le parole d'esempio
	 * @return HTMLLabelElement word
	 */
	public HTMLLabelElement createWord() {
		HTMLLabelElement word = createLabel("");
		word.setAttribute("style", "font-weight:900");
		return word;
	}
	
	/**
	 * Crea un label per le descrizioni d'esempio
	 * @return HTMLLabelElement description
	 */
	public HTMLLabelElement createDescription() {
		HTMLLabelElement description = createLabel("");
		description.setAttribute("style", "font-weight:100");
		description.setAttribute("style", "font-style: italic");
		return description;
	}
	
	/**
	 * Crea un testo nascosto (aiuto per il submit)
	 * @param name nome dell'oggetto
	 * @param value valore
	 * @return HTMLInputElement input
	 */
	public HTMLInputElement createHiddenInputText(String name, String value) {
		HTMLInputElement input = createInputText(name, false);
		input.value = value;
		input.hidden = true;
		return input;
	}
	
	/**
	 * Crea una select
	 * @return HTMLSelectElement select
	 */
	public HTMLSelectElement createSelect() { 
		HTMLSelectElement select = document.createElement(StringTypes.select);
		return select;
	}
	
	/**
	 * Crea un opzione per una select
	 * @param text testo dell'opzione
	 * @return HTMLOptionElement option
	 */
	public HTMLOptionElement createOption(String text) {
		HTMLOptionElement option = document.createElement(StringTypes.option);
		option.text = text;
		return option;
	}
	
	/**
	 * Getter di form
	 * @return form
	 */
	public HTMLFormElement getForm() { return form; }
}

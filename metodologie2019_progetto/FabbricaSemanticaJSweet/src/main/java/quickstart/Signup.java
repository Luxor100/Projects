package quickstart;

import static def.jquery.Globals.$;
import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLOptionElement;
import def.dom.HTMLSelectElement;

/**
 * permette all’utente di registrarsi. La pagina di registrazione prevede: email, pass, confermapass,
 * madrelingua, altre lingue.
 * 
 * @author Mazzotta
 *
 */

public class Signup extends HTMLPage {
	/**
	 * Link per il pulsante submit
	 */
	public static final String SERVLET_URL = "signup.jsp";
	
	/**
	 * label per emailText
	 */
	private HTMLLabelElement emailLabel;
	/**
	 * label per password
	 */
	private HTMLLabelElement passwordLabel;
	/**
	 * label per passwordConferma
	 */
	private HTMLLabelElement confermaPasswordLabel;
	/**
	 * Input per l'inserimento della mail
	 */
	private HTMLInputElement emailText;
	
	/**
	 *  Input per l'inserimento della password
	 */
	private HTMLInputElement password;
	/**
	 * Input per la conferma della password
	 */
	private HTMLInputElement passwordConferma;
	/**
	 * Div contenente l'email
	 */
	private HTMLDivElement divEmail;
	/**
	 * Div contenente le password
	 */
	private HTMLDivElement divPass;
	
	/**
	 * Label per checkbox e select delle lingue
	 */
	private HTMLLabelElement labelMadreLingua, labelAltreLingue;
	/**
	 * Div contenente le checkbox
	 */
	private HTMLDivElement divCheckbox;
	/**
	 * checkbox per l'inglese
	 */
	private HTMLInputElement checkbox1;
	/**
	 * checkbox per l'italiano
	 */
	private HTMLInputElement checkbox2;
	/**
	 * label checkbox1
	 */
	private HTMLLabelElement labelCheckboxIng;
	/**
	 * label checkbox2
	 */
	private HTMLLabelElement labelCheckboxIta;
	
	/**
	 * Div contenente le select
	 */
	private HTMLDivElement divSelect;
	/**
	 * Select per scegliere il livello della lingua
	 */
	private HTMLSelectElement select, select2;
	/**
	 * label per le select
	 */
	private HTMLLabelElement labelSelectIng, labelSelectIta;
	/**
	 * Opzioni delle select
	 */
	private HTMLOptionElement notSelected, notSelected2, A1, A2, B1, B2, C1, C2, A12, A22, B12, B22, C12, C22;
	
	/**
	 * Pulsante submit per inviare il form
	 */
	private HTMLInputElement signup;
	/**
	 * boolean per evitare lo spam del messaggio d'errore
	 */
	private boolean blockSpam = false;
	
	/**
	 * Div contenente signup
	 */
	private HTMLDivElement divSubmit;
	/**
	 * Link alla pagina di login
	 */
	private HTMLAnchorElement login;
	
	public Signup() {
		super();

		setServlet(SERVLET_URL);
		
		divEmail = createDiv();
		emailLabel = createLabel("Email:");
		emailText = createInputText("emailUtente", true);
		emailText.pattern = REGEX_EMAIL;
		$(divEmail).append(emailLabel, emailText);		
				
		password = createInputPassword("passUtente");
				
		passwordConferma = createInputPassword("confermaPassUtente");

		divPass = createDiv();
		passwordLabel = createLabel("Password:");
		confermaPasswordLabel = createLabel("Conferma Password:");
		$(divPass).append(passwordLabel, password, confermaPasswordLabel, passwordConferma);
				
		labelMadreLingua = createLabel("Seleziona la/e tua/e lingua madre:");
		labelMadreLingua.setAttribute("style", "font-weight:500");
		
		divCheckbox = createDiv();
		divCheckbox.className = "form-check-inline";
		
		checkbox1 = createInputCheckbox("Inglese");
		checkbox1.required = true;
		checkbox1.className = "form-check-input";
		
		labelCheckboxIng = createLabel("Inglese");
		labelCheckboxIng.className = "form-check-label";
		
		labelCheckboxIta = createLabel("Italiano");
		labelCheckboxIta.className = "form-check-label";
		
		checkbox2 = createInputCheckbox("Italiano");
		checkbox2.className = "form-check-input";
		checkbox2.required = true;
		
		$(divCheckbox).append(labelCheckboxIng, checkbox1, labelCheckboxIta, checkbox2);
		
		labelAltreLingue = createLabel("Seleziona altre lingue parlate: (opzionale)");
		labelAltreLingue.setAttribute("style", "font-weight:500");
		divSelect = createDiv();
		select = createSelect();
		notSelected = createOption("");
		A1 = createOption("A1");
		A2 = createOption("A2");
		B1 = createOption("B1");
		B2 = createOption("B2");
		C1 = createOption("C1");
		C2 = createOption("C2");
		select.add(notSelected);
		select.add(A1);
		select.add(A2);
		select.add(B1);
		select.add(B2);
		select.add(C1);
		select.add(C2);
		notSelected2 = createOption("");
		A12 = createOption("A1");
		A22 = createOption("A2");
		B12 = createOption("B1");
		B22 = createOption("B2");
		C12 = createOption("C1");
		C22 = createOption("C2");
		select2 = createSelect();
		select2.add(notSelected2);
		select2.add(A12);
		select2.add(A22);
		select2.add(B12);
		select2.add(B22);
		select2.add(C12);
		select2.add(C22);
		labelSelectIng = createLabel("Inglese");
		labelSelectIng.className = "form-check-label";
		labelSelectIta = createLabel("Italiano");
		labelSelectIta.className = "select-inline";
		labelSelectIta.style.marginLeft = "10px";
		
		
		select.onchange = (e -> {
			select.name = "Inglese=";
			return e;
		});
		
		
		select2.onchange = (e -> {
			select2.name = "Italiano=";
			return e;
		});
		
		
		
		$(divSelect).append(labelSelectIng, select, labelSelectIta, select2);
		
		signup = createInputSubmit("signupUtente", "Signup");
		//check almeno una madrelingua, check password uguali + messaggio errore
		signup.onclick = e -> { 
			if (checkbox1.checked || checkbox2.checked) { 
				checkbox1.required = false; checkbox2.required = false;
			}
			if (password.value != passwordConferma.value) {
				if (!blockSpam) {
					HTMLLabelElement error = createLabel("Le due password non corrispondono");
					error.style.color = "red";
					$(divPass).append(error);
					blockSpam = true;
				}
				e.preventDefault(); 
			}
			return e; 
		};
		
		divSubmit = createDiv();
		$(divSubmit).append(signup);
		
		login = createAnchor("Ho gia' un account", "http://localhost:8080/fabbricasemantica/login.html");
				
		$(getForm()).append(divEmail);
		$(getForm()).append(divPass);
		$(getForm()).append(labelMadreLingua);
		$(getForm()).append(divCheckbox, createDiv());
		$(getForm()).append(labelAltreLingue, divSelect);
		$(getForm()).append(divSubmit);
		$(getForm()).append(login);				
		$("body").append(getForm());
	}


	public static void main(String[] args) {
		new Signup();
	}
}

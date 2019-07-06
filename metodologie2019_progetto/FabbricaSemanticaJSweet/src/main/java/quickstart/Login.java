package quickstart;

import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;

/**
 * Classe che definisce la costruzione della pagina di login.
 * Permette all’utente di autenticarsi al sistema.
 * 
 * @author Mazzotta
 * 
 */
public class Login extends HTMLPage{

	/**
	 * Link per il pulsante submit
	 */
	public static final String SERVLET_URL = "login.jsp";
	
	/**
	 * Div dell'email
	 */
	private HTMLDivElement divEmail;
	/**
	 * Div della password
	 */
	private HTMLDivElement divPassword;
	/**
	 * Div della pagina
	 */
	private HTMLDivElement divLogin;
	/**
	 * Label per l'email
	 */
	private HTMLLabelElement labelEmail;
	/**
	 * Label per la password
	 */
	private HTMLLabelElement labelPassword;
	/**
	 * Input dell'utente per l'email
	 */
	private HTMLInputElement emailUtente;
	/**
	 * Input dell'utente per la password
	 */
	private HTMLInputElement passwordUtente;
	/**
	 * Pulsante login per il submit
	 */
	private HTMLInputElement login;
	/**
	 * Link diretto per la pagina di registrazione
	 */
	private HTMLAnchorElement registrati;
	
	public Login() {
		super();
		
		setServlet(SERVLET_URL);
		
		divEmail = createDiv();
		labelEmail = createLabel("Email:");
		emailUtente = createInputText("emailUtente", true);
		emailUtente.pattern = REGEX_EMAIL;
		$(divEmail).append(labelEmail, emailUtente);
		
		divPassword = createDiv();
		labelPassword = createLabel("Password:");
		passwordUtente = createInputText("passwordUtente", true);
		$(divPassword).append(labelPassword, passwordUtente);
		
		login = createInputSubmit("Login", "Login");
		registrati = createAnchor("Se non hai ancora un account, registrati qui", "http://localhost:8080/fabbricasemantica/signup.html");
		
		divLogin = createDiv();
		$(divLogin).append(login);
		
		$(getForm()).append(divEmail, divPassword, divLogin, registrati);
		$("body").append(getForm());
	}
	
	public static void main(String[] args) {
		new Login();
	}
}

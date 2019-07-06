/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che definisce la costruzione della pagina di login.
     * Permette all’utente di autenticarsi al sistema.
     * 
     * @author Mazzotta
     * 
     * @class
     * @extends quickstart.HTMLPage
     */
    export class Login extends quickstart.HTMLPage {
        /**
         * Link per il pulsante submit
         */
        public static SERVLET_URL : string = "login.jsp";

        /**
         * Div dell'email
         */
        /*private*/ divEmail : HTMLDivElement;

        /**
         * Div della password
         */
        /*private*/ divPassword : HTMLDivElement;

        /**
         * Div della pagina
         */
        /*private*/ divLogin : HTMLDivElement;

        /**
         * Label per l'email
         */
        /*private*/ labelEmail : HTMLLabelElement;

        /**
         * Label per la password
         */
        /*private*/ labelPassword : HTMLLabelElement;

        /**
         * Input dell'utente per l'email
         */
        /*private*/ emailUtente : HTMLInputElement;

        /**
         * Input dell'utente per la password
         */
        /*private*/ passwordUtente : HTMLInputElement;

        /**
         * Pulsante login per il submit
         */
        /*private*/ login : HTMLInputElement;

        /**
         * Link diretto per la pagina di registrazione
         */
        /*private*/ registrati : HTMLAnchorElement;

        public constructor() {
            super();
            if(this.divEmail===undefined) this.divEmail = null;
            if(this.divPassword===undefined) this.divPassword = null;
            if(this.divLogin===undefined) this.divLogin = null;
            if(this.labelEmail===undefined) this.labelEmail = null;
            if(this.labelPassword===undefined) this.labelPassword = null;
            if(this.emailUtente===undefined) this.emailUtente = null;
            if(this.passwordUtente===undefined) this.passwordUtente = null;
            if(this.login===undefined) this.login = null;
            if(this.registrati===undefined) this.registrati = null;
            this.setServlet(Login.SERVLET_URL);
            this.divEmail = this.createDiv();
            this.labelEmail = this.createLabel("Email:");
            this.emailUtente = this.createInputText("emailUtente", true);
            this.emailUtente.pattern = quickstart.HTMLPage.REGEX_EMAIL;
            $(this.divEmail).append(this.labelEmail, this.emailUtente);
            this.divPassword = this.createDiv();
            this.labelPassword = this.createLabel("Password:");
            this.passwordUtente = this.createInputText("passwordUtente", true);
            $(this.divPassword).append(this.labelPassword, this.passwordUtente);
            this.login = this.createInputSubmit("Login", "Login");
            this.registrati = this.createAnchor("Se non hai ancora un account, registrati qui", "http://localhost:8080/fabbricasemantica/signup.html");
            this.divLogin = this.createDiv();
            $(this.divLogin).append(this.login);
            $(this.getForm()).append(this.divEmail, this.divPassword, this.divLogin, this.registrati);
            $("body").append(this.getForm());
        }

        public static main(args : string[]) {
            new Login();
        }
    }
    Login["__class"] = "quickstart.Login";

}


quickstart.Login.main(null);

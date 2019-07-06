/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che definisce la costruzione della pagina di login.
     * Permette all�utente di autenticarsi al sistema.
     *
     * @author Mazzotta
     *
     * @class
     * @extends quickstart.HTMLPage
     */
    class Login extends quickstart.HTMLPage {
        constructor() {
            super();
            if (this.divEmail === undefined)
                this.divEmail = null;
            if (this.divPassword === undefined)
                this.divPassword = null;
            if (this.divLogin === undefined)
                this.divLogin = null;
            if (this.labelEmail === undefined)
                this.labelEmail = null;
            if (this.labelPassword === undefined)
                this.labelPassword = null;
            if (this.emailUtente === undefined)
                this.emailUtente = null;
            if (this.passwordUtente === undefined)
                this.passwordUtente = null;
            if (this.login === undefined)
                this.login = null;
            if (this.registrati === undefined)
                this.registrati = null;
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
        static main(args) {
            new Login();
        }
    }
    /**
     * Link per il pulsante submit
     */
    Login.SERVLET_URL = "login.jsp";
    quickstart.Login = Login;
    Login["__class"] = "quickstart.Login";
})(quickstart || (quickstart = {}));
quickstart.Login.main(null);

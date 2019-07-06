/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * permette all’utente di registrarsi. La pagina di registrazione prevede: email, pass, confermapass,
     * madrelingua, altre lingue.
     * 
     * @author Mazzotta
     * @class
     * @extends quickstart.HTMLPage
     */
    export class Signup extends quickstart.HTMLPage {
        /**
         * Link per il pulsante submit
         */
        public static SERVLET_URL : string = "signup.jsp";

        /**
         * label per emailText
         */
        /*private*/ emailLabel : HTMLLabelElement;

        /**
         * label per password
         */
        /*private*/ passwordLabel : HTMLLabelElement;

        /**
         * label per passwordConferma
         */
        /*private*/ confermaPasswordLabel : HTMLLabelElement;

        /**
         * Input per l'inserimento della mail
         */
        /*private*/ emailText : HTMLInputElement;

        /**
         * Input per l'inserimento della password
         */
        /*private*/ password : HTMLInputElement;

        /**
         * Input per la conferma della password
         */
        /*private*/ passwordConferma : HTMLInputElement;

        /**
         * Div contenente l'email
         */
        /*private*/ divEmail : HTMLDivElement;

        /**
         * Div contenente le password
         */
        /*private*/ divPass : HTMLDivElement;

        /**
         * Label per checkbox e select delle lingue
         */
        /*private*/ labelMadreLingua : HTMLLabelElement;

        /**
         * Label per checkbox e select delle lingue
         */
        /*private*/ labelAltreLingue : HTMLLabelElement;

        /**
         * Div contenente le checkbox
         */
        /*private*/ divCheckbox : HTMLDivElement;

        /**
         * checkbox per l'inglese
         */
        /*private*/ checkbox1 : HTMLInputElement;

        /**
         * checkbox per l'italiano
         */
        /*private*/ checkbox2 : HTMLInputElement;

        /**
         * label checkbox1
         */
        /*private*/ labelCheckboxIng : HTMLLabelElement;

        /**
         * label checkbox2
         */
        /*private*/ labelCheckboxIta : HTMLLabelElement;

        /**
         * Div contenente le select
         */
        /*private*/ divSelect : HTMLDivElement;

        /**
         * Select per scegliere il livello della lingua
         */
        /*private*/ select : HTMLSelectElement;

        /**
         * Select per scegliere il livello della lingua
         */
        /*private*/ select2 : HTMLSelectElement;

        /**
         * label per le select
         */
        /*private*/ labelSelectIng : HTMLLabelElement;

        /**
         * label per le select
         */
        /*private*/ labelSelectIta : HTMLLabelElement;

        /**
         * Opzioni delle select
         */
        /*private*/ notSelected : HTMLOptionElement;

        /**
         * Opzioni delle select
         */
        /*private*/ notSelected2 : HTMLOptionElement;

        /**
         * Opzioni delle select
         */
        /*private*/ A1 : HTMLOptionElement;

        /**
         * Opzioni delle select
         */
        /*private*/ A2 : HTMLOptionElement;

        /**
         * Opzioni delle select
         */
        /*private*/ B1 : HTMLOptionElement;

        /**
         * Opzioni delle select
         */
        /*private*/ B2 : HTMLOptionElement;

        /**
         * Opzioni delle select
         */
        /*private*/ C1 : HTMLOptionElement;

        /**
         * Opzioni delle select
         */
        /*private*/ C2 : HTMLOptionElement;

        /**
         * Opzioni delle select
         */
        /*private*/ A12 : HTMLOptionElement;

        /**
         * Opzioni delle select
         */
        /*private*/ A22 : HTMLOptionElement;

        /**
         * Opzioni delle select
         */
        /*private*/ B12 : HTMLOptionElement;

        /**
         * Opzioni delle select
         */
        /*private*/ B22 : HTMLOptionElement;

        /**
         * Opzioni delle select
         */
        /*private*/ C12 : HTMLOptionElement;

        /**
         * Opzioni delle select
         */
        /*private*/ C22 : HTMLOptionElement;

        /**
         * Pulsante submit per inviare il form
         */
        /*private*/ signup : HTMLInputElement;

        /**
         * boolean per evitare lo spam del messaggio d'errore
         */
        /*private*/ blockSpam : boolean = false;

        /**
         * Div contenente signup
         */
        /*private*/ divSubmit : HTMLDivElement;

        /**
         * Link alla pagina di login
         */
        /*private*/ login : HTMLAnchorElement;

        public constructor() {
            super();
            if(this.emailLabel===undefined) this.emailLabel = null;
            if(this.passwordLabel===undefined) this.passwordLabel = null;
            if(this.confermaPasswordLabel===undefined) this.confermaPasswordLabel = null;
            if(this.emailText===undefined) this.emailText = null;
            if(this.password===undefined) this.password = null;
            if(this.passwordConferma===undefined) this.passwordConferma = null;
            if(this.divEmail===undefined) this.divEmail = null;
            if(this.divPass===undefined) this.divPass = null;
            if(this.labelMadreLingua===undefined) this.labelMadreLingua = null;
            if(this.labelAltreLingue===undefined) this.labelAltreLingue = null;
            if(this.divCheckbox===undefined) this.divCheckbox = null;
            if(this.checkbox1===undefined) this.checkbox1 = null;
            if(this.checkbox2===undefined) this.checkbox2 = null;
            if(this.labelCheckboxIng===undefined) this.labelCheckboxIng = null;
            if(this.labelCheckboxIta===undefined) this.labelCheckboxIta = null;
            if(this.divSelect===undefined) this.divSelect = null;
            if(this.select===undefined) this.select = null;
            if(this.select2===undefined) this.select2 = null;
            if(this.labelSelectIng===undefined) this.labelSelectIng = null;
            if(this.labelSelectIta===undefined) this.labelSelectIta = null;
            if(this.notSelected===undefined) this.notSelected = null;
            if(this.notSelected2===undefined) this.notSelected2 = null;
            if(this.A1===undefined) this.A1 = null;
            if(this.A2===undefined) this.A2 = null;
            if(this.B1===undefined) this.B1 = null;
            if(this.B2===undefined) this.B2 = null;
            if(this.C1===undefined) this.C1 = null;
            if(this.C2===undefined) this.C2 = null;
            if(this.A12===undefined) this.A12 = null;
            if(this.A22===undefined) this.A22 = null;
            if(this.B12===undefined) this.B12 = null;
            if(this.B22===undefined) this.B22 = null;
            if(this.C12===undefined) this.C12 = null;
            if(this.C22===undefined) this.C22 = null;
            if(this.signup===undefined) this.signup = null;
            if(this.divSubmit===undefined) this.divSubmit = null;
            if(this.login===undefined) this.login = null;
            this.setServlet(Signup.SERVLET_URL);
            this.divEmail = this.createDiv();
            this.emailLabel = this.createLabel("Email:");
            this.emailText = this.createInputText("emailUtente", true);
            this.emailText.pattern = quickstart.HTMLPage.REGEX_EMAIL;
            $(this.divEmail).append(this.emailLabel, this.emailText);
            this.password = this.createInputPassword("passUtente");
            this.passwordConferma = this.createInputPassword("confermaPassUtente");
            this.divPass = this.createDiv();
            this.passwordLabel = this.createLabel("Password:");
            this.confermaPasswordLabel = this.createLabel("Conferma Password:");
            $(this.divPass).append(this.passwordLabel, this.password, this.confermaPasswordLabel, this.passwordConferma);
            this.labelMadreLingua = this.createLabel("Seleziona la/e tua/e lingua madre:");
            this.labelMadreLingua.setAttribute("style", "font-weight:500");
            this.divCheckbox = this.createDiv();
            this.divCheckbox.className = "form-check-inline";
            this.checkbox1 = this.createInputCheckbox("Inglese");
            this.checkbox1.required = true;
            this.checkbox1.className = "form-check-input";
            this.labelCheckboxIng = this.createLabel("Inglese");
            this.labelCheckboxIng.className = "form-check-label";
            this.labelCheckboxIta = this.createLabel("Italiano");
            this.labelCheckboxIta.className = "form-check-label";
            this.checkbox2 = this.createInputCheckbox("Italiano");
            this.checkbox2.className = "form-check-input";
            this.checkbox2.required = true;
            $(this.divCheckbox).append(this.labelCheckboxIng, this.checkbox1, this.labelCheckboxIta, this.checkbox2);
            this.labelAltreLingue = this.createLabel("Seleziona altre lingue parlate: (opzionale)");
            this.labelAltreLingue.setAttribute("style", "font-weight:500");
            this.divSelect = this.createDiv();
            this.select = this.createSelect();
            this.notSelected = this.createOption("");
            this.A1 = this.createOption("A1");
            this.A2 = this.createOption("A2");
            this.B1 = this.createOption("B1");
            this.B2 = this.createOption("B2");
            this.C1 = this.createOption("C1");
            this.C2 = this.createOption("C2");
            this.select.add(this.notSelected);
            this.select.add(this.A1);
            this.select.add(this.A2);
            this.select.add(this.B1);
            this.select.add(this.B2);
            this.select.add(this.C1);
            this.select.add(this.C2);
            this.notSelected2 = this.createOption("");
            this.A12 = this.createOption("A1");
            this.A22 = this.createOption("A2");
            this.B12 = this.createOption("B1");
            this.B22 = this.createOption("B2");
            this.C12 = this.createOption("C1");
            this.C22 = this.createOption("C2");
            this.select2 = this.createSelect();
            this.select2.add(this.notSelected2);
            this.select2.add(this.A12);
            this.select2.add(this.A22);
            this.select2.add(this.B12);
            this.select2.add(this.B22);
            this.select2.add(this.C12);
            this.select2.add(this.C22);
            this.labelSelectIng = this.createLabel("Inglese");
            this.labelSelectIng.className = "form-check-label";
            this.labelSelectIta = this.createLabel("Italiano");
            this.labelSelectIta.className = "select-inline";
            this.labelSelectIta.style.marginLeft = "10px";
            this.select.onchange = <any>(((e) => {
                this.select.name = "Inglese=";
                return e;
            }));
            this.select2.onchange = <any>(((e) => {
                this.select2.name = "Italiano=";
                return e;
            }));
            $(this.divSelect).append(this.labelSelectIng, this.select, this.labelSelectIta, this.select2);
            this.signup = this.createInputSubmit("signupUtente", "Signup");
            this.signup.onclick = (e) => {
                if(this.checkbox1.checked || this.checkbox2.checked) {
                    this.checkbox1.required = false;
                    this.checkbox2.required = false;
                }
                if(this.password.value !== this.passwordConferma.value) {
                    if(!this.blockSpam) {
                        let error : HTMLLabelElement = this.createLabel("Le due password non corrispondono");
                        error.style.color = "red";
                        $(this.divPass).append(error);
                        this.blockSpam = true;
                    }
                    e.preventDefault();
                }
                return e;
            };
            this.divSubmit = this.createDiv();
            $(this.divSubmit).append(this.signup);
            this.login = this.createAnchor("Ho gia\' un account", "http://localhost:8080/fabbricasemantica/login.html");
            $(this.getForm()).append(this.divEmail);
            $(this.getForm()).append(this.divPass);
            $(this.getForm()).append(this.labelMadreLingua);
            $(this.getForm()).append(this.divCheckbox, this.createDiv());
            $(this.getForm()).append(this.labelAltreLingue, this.divSelect);
            $(this.getForm()).append(this.divSubmit);
            $(this.getForm()).append(this.login);
            $("body").append(this.getForm());
        }

        public static main(args : string[]) {
            new Signup();
        }
    }
    Signup["__class"] = "quickstart.Signup";

}


quickstart.Signup.main(null);

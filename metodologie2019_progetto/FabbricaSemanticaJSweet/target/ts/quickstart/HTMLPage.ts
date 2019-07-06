/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe astratta che crea il form per tutte le pagine html.
     * Aggiunge il div in cima alle pagine con titolo e sfondo.
     * 
     * @author Mazzotta
     * @class
     */
    export abstract class HTMLPage {
        /**
         * Pagine html per il pulsante skip
         */
        public static arrayIndirizzi : string[]; public static arrayIndirizzi_$LI$() : string[] { if(HTMLPage.arrayIndirizzi == null) HTMLPage.arrayIndirizzi = ["translationAnnotation.html", "wordAnnotation.html", "definitionAnnotation.html", "senseAnnotation.html", "translationValidation.html", "senseValidation.html", "myAnnotation.html"]; return HTMLPage.arrayIndirizzi; };

        /**
         * Regex per la verifica delle email
         */
        public static REGEX_EMAIL : string = "(?:[a-z0-9!#$%&\'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&\'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

        /**
         * form delle pagine html
         */
        /*private*/ form : HTMLFormElement;

        /**
         * div contenente titolo, sfondo e logout
         */
        /*private*/ divTopBar : HTMLDivElement;

        /**
         * titolo con link alla home
         */
        /*private*/ anchorFabbricaSemantica : HTMLAnchorElement;

        /**
         * link alla pagina di logout
         */
        /*private*/ logout : HTMLAnchorElement;

        public constructor() {
            if(this.form===undefined) this.form = null;
            if(this.divTopBar===undefined) this.divTopBar = null;
            if(this.anchorFabbricaSemantica===undefined) this.anchorFabbricaSemantica = null;
            if(this.logout===undefined) this.logout = null;
            this.form = this.createForm();
            this.divTopBar = this.createDiv();
            this.divTopBar.style.backgroundColor = "#00C196";
            this.divTopBar.style.height = "50px";
            this.anchorFabbricaSemantica = this.createAnchor("FabbricaSemantica", "home.html");
            this.anchorFabbricaSemantica.setAttribute("style", "font-weight:bold");
            $(this.anchorFabbricaSemantica).css("color", "#000000");
            this.anchorFabbricaSemantica.style.fontSize = "35px";
            this.anchorFabbricaSemantica.style.position = "relative";
            this.anchorFabbricaSemantica.style.top = "7px";
            this.anchorFabbricaSemantica.style.borderBottomColor = "none";
            this.logout = this.createAnchor("Logout", "logout.jsp");
            this.logout.style.cssFloat = "right";
            this.logout.style.fontSize = "22px";
            this.logout.style.position = "relative";
            this.logout.style.top = "7px";
            this.anchorFabbricaSemantica.appendChild(this.logout);
            $(this.divTopBar).append(this.anchorFabbricaSemantica);
            $(this.form).append(this.divTopBar);
            $(this.form).css("margin", "0% 1.5%");
        }

        /**
         * Crea un form
         * @return {HTMLFormElement} HTMLFormElement form
         */
        public createForm() : HTMLFormElement {
            let form : HTMLFormElement = document.createElement("form");
            form.method = "POST";
            return form;
        }

        /**
         * Setter del campo action di un form
         * @param {string} s link per il pulsante submit
         */
        public setServlet(s : string) {
            this.form.action = s;
        }

        /**
         * Crea un label
         * @param {string} s text del label
         * @return {HTMLLabelElement} HTMLLabelElement label
         */
        public createLabel(s : string) : HTMLLabelElement {
            let label : HTMLLabelElement = document.createElement("label");
            label.className = "form-control-plaintext";
            $(label).text(s);
            return label;
        }

        /**
         * Crea un div
         * @return {HTMLDivElement} div
         */
        public createDiv() : HTMLDivElement {
            let div : HTMLDivElement = document.createElement("div");
            div.className = "form-group";
            return div;
        }

        /**
         * Crea un input di testo
         * @param {string} name nome dell'oggetto
         * @param {boolean} b required
         * @return {HTMLInputElement} HTMLInputElement text
         */
        public createInputText(name : string, b : boolean) : HTMLInputElement {
            let text : HTMLInputElement = document.createElement("input");
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
         * @param {string} id del submit
         * @param {string} value testo del pulsante
         * @return {HTMLInputElement} HTMLInputElement submit
         */
        public createInputSubmit(id : string, value : string) : HTMLInputElement {
            let submit : HTMLInputElement = document.createElement("input");
            submit.type = "submit";
            submit.id = id;
            submit.className = "btn btn-primary";
            submit.value = value;
            submit.style.backgroundColor = "#00C196";
            submit.style.borderColor = "black";
            submit.style.color = "black";
            return submit;
        }

        /**
         * Crea una checkbox
         * @param {string} name nome della checkbox
         * @return {HTMLInputElement} HTMLInputElement checkbox
         */
        public createInputCheckbox(name : string) : HTMLInputElement {
            let checkbox : HTMLInputElement = document.createElement("input");
            checkbox.type = "checkbox";
            checkbox.name = name;
            return checkbox;
        }

        /**
         * Crea un link anchor
         * @param {string} text testo del link
         * @param {string} link link
         * @return {HTMLAnchorElement} HTMLAnchorElement anchor
         */
        public createAnchor(text : string, link : string) : HTMLAnchorElement {
            let anchor : HTMLAnchorElement = document.createElement("a");
            anchor.text = text;
            anchor.href = link;
            return anchor;
        }

        /**
         * Crea un'immagine con un link
         * @param {string} src immagine
         * @param {string} height altezza
         * @param {string} width larghezza
         * @return {HTMLInputElement} HTMLInputElement image
         */
        public createInputImg(src : string, height : string, width : string) : HTMLInputElement {
            let img : HTMLInputElement = document.createElement("input");
            img.type = "image";
            img.src = src;
            img.style.height = height;
            img.style.width = width;
            return img;
        }

        /**
         * Crea un pulsante radio
         * @param {string} name nome del pulsante
         * @param {string} id id del pulsante
         * @return {HTMLInputElement} HTMLInputElement radio
         */
        public createInputRadio(name : string, id : string) : HTMLInputElement {
            let radio : HTMLInputElement = document.createElement("input");
            radio.type = "radio";
            radio.name = name;
            radio.id = id;
            return radio;
        }

        /**
         * Crea un input di testo nascosto
         * @param {string} name nome dell'oggetto
         * @return {HTMLInputElement} HTMLInputElement password
         */
        public createInputPassword(name : string) : HTMLInputElement {
            let password : HTMLInputElement = document.createElement("input");
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
        public setRandomServlet() {
            let n : number = (<number>(Math.random() * (HTMLPage.arrayIndirizzi_$LI$().length))|0);
            this.setServlet(HTMLPage.arrayIndirizzi_$LI$()[n]);
        }

        /**
         * Crea un label per le parole d'esempio
         * @return {HTMLLabelElement} HTMLLabelElement word
         */
        public createWord() : HTMLLabelElement {
            let word : HTMLLabelElement = this.createLabel("");
            word.setAttribute("style", "font-weight:900");
            return word;
        }

        /**
         * Crea un label per le descrizioni d'esempio
         * @return {HTMLLabelElement} HTMLLabelElement description
         */
        public createDescription() : HTMLLabelElement {
            let description : HTMLLabelElement = this.createLabel("");
            description.setAttribute("style", "font-weight:100");
            description.setAttribute("style", "font-style: italic");
            return description;
        }

        /**
         * Crea un testo nascosto (aiuto per il submit)
         * @param {string} name nome dell'oggetto
         * @param {string} value valore
         * @return {HTMLInputElement} HTMLInputElement input
         */
        public createHiddenInputText(name : string, value : string) : HTMLInputElement {
            let input : HTMLInputElement = this.createInputText(name, false);
            input.value = value;
            input.hidden = true;
            return input;
        }

        /**
         * Crea una select
         * @return {HTMLSelectElement} HTMLSelectElement select
         */
        public createSelect() : HTMLSelectElement {
            let select : HTMLSelectElement = document.createElement("select");
            return select;
        }

        /**
         * Crea un opzione per una select
         * @param {string} text testo dell'opzione
         * @return {HTMLOptionElement} HTMLOptionElement option
         */
        public createOption(text : string) : HTMLOptionElement {
            let option : HTMLOptionElement = document.createElement("option");
            option.text = text;
            return option;
        }

        /**
         * Getter di form
         * @return {HTMLFormElement} form
         */
        public getForm() : HTMLFormElement {
            return this.form;
        }
    }
    HTMLPage["__class"] = "quickstart.HTMLPage";

}


quickstart.HTMLPage.arrayIndirizzi_$LI$();

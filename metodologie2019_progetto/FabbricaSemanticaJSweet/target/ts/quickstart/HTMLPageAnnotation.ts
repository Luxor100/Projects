/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che definisce la costruzione delle pagine di annotazione/validazione.
     * Aggiunge ad ognuna di esse i pulsanti next e skip
     * 
     * @author Mazzotta
     * 
     * @class
     * @extends quickstart.HTMLPage
     */
    export abstract class HTMLPageAnnotation extends quickstart.HTMLPage {
        /**
         * Link utilizzato dalle pagine nel metodo setPage()
         */
        public static REST_URL : string = "nextExample.jsp";

        /**
         * Pulsante next, fa submit e porta al prossimo task
         */
        /*private*/ next : HTMLInputElement;

        /**
         * Pulsante skip, porta al prossimo task
         */
        /*private*/ skip : HTMLInputElement;

        /**
         * Label per la descrizione dei task di ciascuna pagina
         */
        /*private*/ task : HTMLLabelElement;

        /**
         * Div per task
         */
        /*private*/ divTask : HTMLDivElement;

        /**
         * Div per pulsante next e skip
         */
        /*private*/ divButtons : HTMLDivElement;

        public constructor() {
            super();
            if(this.next===undefined) this.next = null;
            if(this.skip===undefined) this.skip = null;
            if(this.task===undefined) this.task = null;
            if(this.divTask===undefined) this.divTask = null;
            if(this.divButtons===undefined) this.divButtons = null;
            this.next = this.createInputSubmit("next", "next");
            this.skip = this.createInputSubmit("skip", "skip");
            this.skip.style.cssFloat = "right";
            this.skip.onclick = (e) => {
                this.setRandomServlet();
                return e;
            };
            this.task = this.createLabel("");
            this.task.setAttribute("style", "font-weight:550");
            this.divTask = this.createDiv();
            $(this.divTask).append(this.task);
            $(this.getForm()).append(this.divTask);
            this.divButtons = this.createDiv();
            this.divButtons.className = "form-group";
            $(this.divButtons).append(this.next, this.skip);
        }

        /**
         * Metodo che definisce la costruzione degli esempi della pagina
         */
        public abstract setPage();

        /**
         * Setta il text del label task
         * @param {string} s String per il text del label task
         */
        public setTask(s : string) {
            $(this.task).text(s);
        }

        /**
         * Getter di next
         * @return {HTMLInputElement} next
         */
        public getNext() : HTMLInputElement {
            return this.next;
        }

        /**
         * Getter di DivButtons
         * @return {HTMLDivElement} DivButtons
         */
        public getDivButtons() : HTMLDivElement {
            return this.divButtons;
        }
    }
    HTMLPageAnnotation["__class"] = "quickstart.HTMLPageAnnotation";

}


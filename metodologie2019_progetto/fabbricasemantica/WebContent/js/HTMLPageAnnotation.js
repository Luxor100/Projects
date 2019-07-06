/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che definisce la costruzione delle pagine di annotazione/validazione.
     * Aggiunge ad ognuna di esse i pulsanti next e skip
     *
     * @author Mazzotta
     *
     * @class
     * @extends quickstart.HTMLPage
     */
    class HTMLPageAnnotation extends quickstart.HTMLPage {
        constructor() {
            super();
            if (this.next === undefined)
                this.next = null;
            if (this.skip === undefined)
                this.skip = null;
            if (this.task === undefined)
                this.task = null;
            if (this.divTask === undefined)
                this.divTask = null;
            if (this.divButtons === undefined)
                this.divButtons = null;
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
         * Setta il text del label task
         * @param {string} s String per il text del label task
         */
        setTask(s) {
            $(this.task).text(s);
        }
        /**
         * Getter di next
         * @return {HTMLInputElement} next
         */
        getNext() {
            return this.next;
        }
        /**
         * Getter di DivButtons
         * @return {HTMLDivElement} DivButtons
         */
        getDivButtons() {
            return this.divButtons;
        }
    }
    /**
     * Link utilizzato dalle pagine nel metodo setPage()
     */
    HTMLPageAnnotation.REST_URL = "nextExample.jsp";
    quickstart.HTMLPageAnnotation = HTMLPageAnnotation;
    HTMLPageAnnotation["__class"] = "quickstart.HTMLPageAnnotation";
})(quickstart || (quickstart = {}));

/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che definisce la costruzione del task wordAnnotation.
     * Data una definizione in inglese, l�utente deve provare a indovinare la parola definita.
     *
     * @author Mazzotta
     *
     * @class
     * @extends quickstart.HTMLPageAnnotation
     */
    class WordAnnotation extends quickstart.HTMLPageAnnotation {
        constructor() {
            super();
            if (this.description === undefined)
                this.description = null;
            if (this.response === undefined)
                this.response = null;
            if (this.divPage === undefined)
                this.divPage = null;
            this.setServlet(WordAnnotation.SERVLET_URL);
            this.setTask(WordAnnotation.S_TASK);
            this.description = this.createDescription();
            this.response = this.createInputText("respons", false);
            this.response.placeholder = "Indovina la parola qui...";
            this.setPage();
            this.divPage = this.createDiv();
            $(this.divPage).append(this.description, this.response);
            $(this.getForm()).append(this.divPage);
            $(this.getForm()).append(this.getDivButtons());
            $("body").append(this.getForm());
        }
        /**
         *
         */
        setPage() {
            $.getJSON(quickstart.HTMLPageAnnotation.REST_URL, "task=WORD_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let sDescription = (json["description"]);
                $(this.description).text(sDescription);
                return null;
            });
        }
        static main(args) {
            new WordAnnotation();
        }
    }
    /**
     * Link per il tasto submit
     */
    WordAnnotation.SERVLET_URL = "wordAnnotation.jsp";
    /**
     * Descrizione del task della pagina
     */
    WordAnnotation.S_TASK = "Data la definizione in inglese, provare ad indovinare la parola definita.";
    quickstart.WordAnnotation = WordAnnotation;
    WordAnnotation["__class"] = "quickstart.WordAnnotation";
})(quickstart || (quickstart = {}));
quickstart.WordAnnotation.main(null);

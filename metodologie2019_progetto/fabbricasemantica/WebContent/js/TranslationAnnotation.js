/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che definisce la costruzione del task traslationAnnotation.
     * Data una parola e una sua definizione in inglese, l�utente deve fornire una traduzione nella sua lingua madre.
     *
     * @author Mazzotta
     *
     * @class
     * @extends quickstart.HTMLPageAnnotation
     */
    class TranslationAnnotation extends quickstart.HTMLPageAnnotation {
        constructor() {
            super();
            if (this.word === undefined)
                this.word = null;
            if (this.description === undefined)
                this.description = null;
            if (this.response === undefined)
                this.response = null;
            if (this.divPage === undefined)
                this.divPage = null;
            this.setServlet(TranslationAnnotation.SERVLET_URL);
            this.setTask(TranslationAnnotation.S_TASK);
            this.word = this.createWord();
            this.description = this.createDescription();
            this.response = this.createInputText("respons", false);
            this.response.placeholder = "Scrivi la traduzione qui...";
            this.setPage();
            this.divPage = this.createDiv();
            $(this.divPage).append(this.word, this.description, this.response);
            $(this.getForm()).append(this.divPage);
            $(this.getForm()).append(this.getDivButtons());
            $("body").append(this.getForm());
        }
        /**
         *
         */
        setPage() {
            $.getJSON(quickstart.HTMLPageAnnotation.REST_URL, "task=TRANSLATION_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let sWord = (json["word"]);
                let sDescription = (json["description"]);
                $(this.word).text(sWord);
                $(this.description).text(sDescription);
                return null;
            });
        }
        static main(args) {
            new TranslationAnnotation();
        }
    }
    /**
     * Link per il pulsante submit
     */
    TranslationAnnotation.SERVLET_URL = "translationAnnotation.jsp";
    /**
     * Descrizione del task della pagina
     */
    TranslationAnnotation.S_TASK = "Data la parola e una sua definizione in inglese, fornire una traduzione.";
    quickstart.TranslationAnnotation = TranslationAnnotation;
    TranslationAnnotation["__class"] = "quickstart.TranslationAnnotation";
})(quickstart || (quickstart = {}));
quickstart.TranslationAnnotation.main(null);

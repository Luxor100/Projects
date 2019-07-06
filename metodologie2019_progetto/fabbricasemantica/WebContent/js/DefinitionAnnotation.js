/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che definisce la costruzione del task definitionAnnotation.
     * Data una parola e un suo iperonimo (ovvero, una sua generalizzazione, ad es. veicolo come iperonimo di macchina),
     * l�utente deve fornire una definizione nella sua lingua.
     *
     * @author Mazzotta
     * @class
     * @extends quickstart.HTMLPageAnnotation
     */
    class DefinitionAnnotation extends quickstart.HTMLPageAnnotation {
        constructor() {
            super();
            if (this.word === undefined)
                this.word = null;
            if (this.hypernym === undefined)
                this.hypernym = null;
            if (this.respons === undefined)
                this.respons = null;
            if (this.pageDiv === undefined)
                this.pageDiv = null;
            this.setServlet(DefinitionAnnotation.SERVLET_URL);
            this.setTask(DefinitionAnnotation.S_TASK);
            this.word = this.createWord();
            this.hypernym = this.createDescription();
            this.respons = this.createInputText("respons", false);
            this.respons.placeholder = "Scrivi la definizione qui...";
            this.setPage();
            this.pageDiv = this.createDiv();
            $(this.pageDiv).append(this.word, this.hypernym, this.respons);
            $(this.getForm()).append(this.pageDiv, this.getDivButtons());
            $("body").append(this.getForm());
        }
        /**
         *
         */
        setPage() {
            $.getJSON(quickstart.HTMLPageAnnotation.REST_URL, "task=DEFINITION_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let sWord = (json["word"]);
                let sHypernym = (json["hypernym"]);
                $(this.word).text(sWord);
                $(this.hypernym).text(sHypernym);
                return null;
            });
        }
        static main(args) {
            new DefinitionAnnotation();
        }
    }
    /**
     * Link per il pulsante submit
     */
    DefinitionAnnotation.SERVLET_URL = "definitionAnnotation.jsp";
    /**
     * Descrizione del task della pagina
     */
    DefinitionAnnotation.S_TASK = "Data la parola e un suo iperonimo (ovvero, una sua generalizzazione, ad es. veicolo come iperonimo di macchina), fornire una definizione.";
    quickstart.DefinitionAnnotation = DefinitionAnnotation;
    DefinitionAnnotation["__class"] = "quickstart.DefinitionAnnotation";
})(quickstart || (quickstart = {}));
quickstart.DefinitionAnnotation.main(null);

/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che definisce la costruzione del task definitionAnnotation.
     * Data una parola e un suo iperonimo (ovvero, una sua generalizzazione, ad es. veicolo come iperonimo di macchina),
     * l’utente deve fornire una definizione nella sua lingua.
     * 
     * @author Mazzotta
     * @class
     * @extends quickstart.HTMLPageAnnotation
     */
    export class DefinitionAnnotation extends quickstart.HTMLPageAnnotation {
        /**
         * Link per il pulsante submit
         */
        public static SERVLET_URL : string = "definitionAnnotation.jsp";

        /**
         * Descrizione del task della pagina
         */
        public static S_TASK : string = "Data la parola e un suo iperonimo (ovvero, una sua generalizzazione, ad es. veicolo come iperonimo di macchina), fornire una definizione.";

        /**
         * Parola presa dal back-end come esempio
         */
        /*private*/ word : HTMLLabelElement;

        /**
         * Iperonimo preso dal back-end come esempio
         */
        /*private*/ hypernym : HTMLLabelElement;

        /**
         * Input dell'utente
         */
        /*private*/ respons : HTMLInputElement;

        /**
         * Div della pagina
         */
        /*private*/ pageDiv : HTMLDivElement;

        public constructor() {
            super();
            if(this.word===undefined) this.word = null;
            if(this.hypernym===undefined) this.hypernym = null;
            if(this.respons===undefined) this.respons = null;
            if(this.pageDiv===undefined) this.pageDiv = null;
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
        public setPage() {
            $.getJSON(quickstart.HTMLPageAnnotation.REST_URL, "task=DEFINITION_ANNOTATION", (result, a, ctx) => {
                let json : JSON = <JSON>result;
                let sWord : string = <any>(json["word"]);
                let sHypernym : string = <any>(json["hypernym"]);
                $(this.word).text(sWord);
                $(this.hypernym).text(sHypernym);
                return null;
            });
        }

        public static main(args : string[]) {
            new DefinitionAnnotation();
        }
    }
    DefinitionAnnotation["__class"] = "quickstart.DefinitionAnnotation";

}


quickstart.DefinitionAnnotation.main(null);

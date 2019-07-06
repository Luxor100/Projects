/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che definisce la costruzione del task traslationAnnotation.
     * Data una parola e una sua definizione in inglese, l’utente deve fornire una traduzione nella sua lingua madre.
     * 
     * @author Mazzotta
     * 
     * @class
     * @extends quickstart.HTMLPageAnnotation
     */
    export class TranslationAnnotation extends quickstart.HTMLPageAnnotation {
        /**
         * Link per il pulsante submit
         */
        public static SERVLET_URL : string = "translationAnnotation.jsp";

        /**
         * Descrizione del task della pagina
         */
        public static S_TASK : string = "Data la parola e una sua definizione in inglese, fornire una traduzione.";

        /**
         * Parola presa dal back-end come esempio
         */
        /*private*/ word : HTMLLabelElement;

        /**
         * Descrizione presa dal back-end come esempio
         */
        /*private*/ description : HTMLLabelElement;

        /**
         * Input dell'utente
         */
        /*private*/ response : HTMLInputElement;

        /**
         * Div della pagina
         */
        /*private*/ divPage : HTMLDivElement;

        public constructor() {
            super();
            if(this.word===undefined) this.word = null;
            if(this.description===undefined) this.description = null;
            if(this.response===undefined) this.response = null;
            if(this.divPage===undefined) this.divPage = null;
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
        public setPage() {
            $.getJSON(quickstart.HTMLPageAnnotation.REST_URL, "task=TRANSLATION_ANNOTATION", (result, a, ctx) => {
                let json : JSON = <JSON>result;
                let sWord : string = <any>(json["word"]);
                let sDescription : string = <any>(json["description"]);
                $(this.word).text(sWord);
                $(this.description).text(sDescription);
                return null;
            });
        }

        public static main(args : string[]) {
            new TranslationAnnotation();
        }
    }
    TranslationAnnotation["__class"] = "quickstart.TranslationAnnotation";

}


quickstart.TranslationAnnotation.main(null);

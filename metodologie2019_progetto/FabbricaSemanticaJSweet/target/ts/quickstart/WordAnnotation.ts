/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che definisce la costruzione del task wordAnnotation.
     * Data una definizione in inglese, l’utente deve provare a indovinare la parola definita.
     * 
     * @author Mazzotta
     * 
     * @class
     * @extends quickstart.HTMLPageAnnotation
     */
    export class WordAnnotation extends quickstart.HTMLPageAnnotation {
        /**
         * Link per il tasto submit
         */
        public static SERVLET_URL : string = "wordAnnotation.jsp";

        /**
         * Descrizione del task della pagina
         */
        public static S_TASK : string = "Data la definizione in inglese, provare ad indovinare la parola definita.";

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
            if(this.description===undefined) this.description = null;
            if(this.response===undefined) this.response = null;
            if(this.divPage===undefined) this.divPage = null;
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
        public setPage() {
            $.getJSON(quickstart.HTMLPageAnnotation.REST_URL, "task=WORD_ANNOTATION", (result, a, ctx) => {
                let json : JSON = <JSON>result;
                let sDescription : string = <any>(json["description"]);
                $(this.description).text(sDescription);
                return null;
            });
        }

        public static main(args : string[]) {
            new WordAnnotation();
        }
    }
    WordAnnotation["__class"] = "quickstart.WordAnnotation";

}


quickstart.WordAnnotation.main(null);

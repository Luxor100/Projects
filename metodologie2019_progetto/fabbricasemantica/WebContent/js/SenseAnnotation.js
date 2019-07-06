/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che definisce la costruzione del task senseAnnotation.
     * Data una parola e una frase in cui la parola appare, l�utente deve selezionare il senso appropriato.
     *
     * @author Mazzotta
     * @class
     * @extends quickstart.HTMLPageAnnotation
     */
    class SenseAnnotation extends quickstart.HTMLPageAnnotation {
        constructor() {
            super();
            /**
             * Lista contenente i label per le checkbox
             */
            /*private*/ this.listaLabel = ([]);
            if (this.word === undefined)
                this.word = null;
            if (this.description === undefined)
                this.description = null;
            if (this.checkboxDiv === undefined)
                this.checkboxDiv = null;
            if (this.pageDiv === undefined)
                this.pageDiv = null;
            this.setServlet(SenseAnnotation.SERVLET_URL);
            this.setTask(SenseAnnotation.S_TASK);
            this.word = this.createWord();
            this.description = this.createDescription();
            this.checkboxDiv = this.createDiv();
            this.setPage();
            this.pageDiv = this.createDiv();
            $(this.pageDiv).append(this.word, this.description);
            $(this.getForm()).append(this.pageDiv);
            $(this.getForm()).append(this.checkboxDiv);
            $(this.getForm()).append(this.getDivButtons());
            $("body").append(this.getForm());
        }
        /**
         *
         */
        setPage() {
            $.getJSON(quickstart.HTMLPageAnnotation.REST_URL, "task=SENSE_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let sWord = (json["word"]);
                let sDescription = (json["description"]);
                let sSenses = (json["senses"]);
                for (let k = 0; k < sSenses.length; k++) {
                    {
                        let labelSenses = this.createLabel("");
                        labelSenses.className = "form-check-label";
                        $(labelSenses).text(sSenses[k]);
                        /* add */ (this.listaLabel.push(labelSenses) > 0);
                    }
                    ;
                }
                let j = 1;
                $(this.word).text(sWord);
                $(this.description).text(sDescription);
                for (let index122 = 0; index122 < this.listaLabel.length; index122++) {
                    let label = this.listaLabel[index122];
                    {
                        $(this.checkboxDiv).append(label, this.createInputCheckbox("" + j++));
                        $(this.checkboxDiv).append(this.createDiv());
                    }
                }
                return null;
            });
        }
        static main(args) {
            new SenseAnnotation();
        }
    }
    /**
     * Link per il pulsante submit
     */
    SenseAnnotation.SERVLET_URL = "senseAnnotation.jsp";
    /**
     * Descrizione del task della pagina
     */
    SenseAnnotation.S_TASK = "Data la parola e una frase in cui la parola appare, selezionare il senso appropriato.";
    quickstart.SenseAnnotation = SenseAnnotation;
    SenseAnnotation["__class"] = "quickstart.SenseAnnotation";
})(quickstart || (quickstart = {}));
quickstart.SenseAnnotation.main(null);

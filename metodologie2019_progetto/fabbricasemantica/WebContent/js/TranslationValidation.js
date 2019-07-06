/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che definisce la costruzione del task traslationValidation.
     * Data una parola e una sua definizione in inglese, l�utente deve scegliere la miglior traduzione tra quelle fornite o specificare <nessuna>.
     *
     * @author Mazzotta
     *
     * @class
     * @extends quickstart.HTMLPageAnnotation
     */
    class TranslationValidation extends quickstart.HTMLPageAnnotation {
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
            if (this.divPage === undefined)
                this.divPage = null;
            if (this.divLabelCheckbox === undefined)
                this.divLabelCheckbox = null;
            if (this.nessuna === undefined)
                this.nessuna = null;
            if (this.nessunaCheckbox === undefined)
                this.nessunaCheckbox = null;
            this.setServlet(TranslationValidation.SERVLET_URL);
            this.setTask(TranslationValidation.S_TASK);
            this.word = this.createWord();
            this.description = this.createDescription();
            this.divPage = this.createDiv();
            this.divLabelCheckbox = this.createDiv();
            this.setPage();
            $(this.divPage).append(this.word, this.description);
            $(this.getForm()).append(this.divPage, this.divLabelCheckbox, this.getDivButtons());
            $("body").append(this.getForm());
        }
        /**
         *
         */
        setPage() {
            $.getJSON(quickstart.HTMLPageAnnotation.REST_URL, "task=TRANSLATION_VALIDATION", (result, a, ctx) => {
                let json = result;
                let sWord = (json["word"]);
                let sDescription = (json["description"]);
                let sTranslations = (json["translations"]);
                $(this.word).text(sWord);
                $(this.description).text(sDescription);
                for (let k = 0; k < sTranslations.length; k++) {
                    {
                        let labelTranslations = this.createLabel("");
                        labelTranslations.className = "form-check-label";
                        $(labelTranslations).text(sTranslations[k]);
                        /* add */ (this.listaLabel.push(labelTranslations) > 0);
                    }
                    ;
                }
                let j = 0;
                for (let index123 = 0; index123 < this.listaLabel.length; index123++) {
                    let label = this.listaLabel[index123];
                    {
                        $(this.divLabelCheckbox).append(label, this.createInputCheckbox("" + j++));
                        $(this.divLabelCheckbox).append(this.createDiv());
                    }
                }
                this.nessuna = this.createLabel("Nessuna");
                this.nessuna.className = "form-check-label";
                this.nessunaCheckbox = this.createInputCheckbox("nessuna");
                $(this.divLabelCheckbox).append(this.nessuna, this.nessunaCheckbox, this.createDiv());
                return null;
            });
        }
        static main(args) {
            new TranslationValidation();
        }
    }
    /**
     * Link per il pulsante submit
     */
    TranslationValidation.SERVLET_URL = "translationValidation.jsp";
    /**
     * Descrizione del task della pagina
     */
    TranslationValidation.S_TASK = "Data la parola e una sua definizione in inglese, scegliere la miglior traduzione tra quelle fornite o specificare <nessuna>.";
    quickstart.TranslationValidation = TranslationValidation;
    TranslationValidation["__class"] = "quickstart.TranslationValidation";
})(quickstart || (quickstart = {}));
quickstart.TranslationValidation.main(null);

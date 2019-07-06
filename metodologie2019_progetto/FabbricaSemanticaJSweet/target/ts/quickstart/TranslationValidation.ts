/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che definisce la costruzione del task traslationValidation.
     * Data una parola e una sua definizione in inglese, l’utente deve scegliere la miglior traduzione tra quelle fornite o specificare <nessuna>.
     * 
     * @author Mazzotta
     * 
     * @class
     * @extends quickstart.HTMLPageAnnotation
     */
    export class TranslationValidation extends quickstart.HTMLPageAnnotation {
        /**
         * Link per il pulsante submit
         */
        public static SERVLET_URL : string = "translationValidation.jsp";

        /**
         * Descrizione del task della pagina
         */
        public static S_TASK : string = "Data la parola e una sua definizione in inglese, scegliere la miglior traduzione tra quelle fornite o specificare <nessuna>.";

        /**
         * Parola presa dal back-end come esempio
         */
        /*private*/ word : HTMLLabelElement;

        /**
         * Descrizione presa dal back-end come esempio
         */
        /*private*/ description : HTMLLabelElement;

        /**
         * Div della pagina
         */
        /*private*/ divPage : HTMLDivElement;

        /**
         * Div dei Label per le checkbox
         */
        /*private*/ divLabelCheckbox : HTMLDivElement;

        /**
         * Label per nessunaCheckbox
         */
        /*private*/ nessuna : HTMLLabelElement;

        /**
         * Checkbox per l'opzione nessuna
         */
        /*private*/ nessunaCheckbox : HTMLInputElement;

        /**
         * Lista contenente i label per le checkbox
         */
        /*private*/ listaLabel : Array<HTMLLabelElement> = <any>([]);

        public constructor() {
            super();
            if(this.word===undefined) this.word = null;
            if(this.description===undefined) this.description = null;
            if(this.divPage===undefined) this.divPage = null;
            if(this.divLabelCheckbox===undefined) this.divLabelCheckbox = null;
            if(this.nessuna===undefined) this.nessuna = null;
            if(this.nessunaCheckbox===undefined) this.nessunaCheckbox = null;
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
        public setPage() {
            $.getJSON(quickstart.HTMLPageAnnotation.REST_URL, "task=TRANSLATION_VALIDATION", (result, a, ctx) => {
                let json : JSON = <JSON>result;
                let sWord : string = <any>(json["word"]);
                let sDescription : string = <any>(json["description"]);
                let sTranslations : string[] = <any>(json["translations"]);
                $(this.word).text(sWord);
                $(this.description).text(sDescription);
                for(let k : number = 0; k < sTranslations.length; k++) {{
                    let labelTranslations : HTMLLabelElement = this.createLabel("");
                    labelTranslations.className = "form-check-label";
                    $(labelTranslations).text(sTranslations[k]);
                    /* add */(this.listaLabel.push(labelTranslations)>0);
                };}
                let j : number = 0;
                for(let index123=0; index123 < this.listaLabel.length; index123++) {
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

        public static main(args : string[]) {
            new TranslationValidation();
        }
    }
    TranslationValidation["__class"] = "quickstart.TranslationValidation";

}


quickstart.TranslationValidation.main(null);

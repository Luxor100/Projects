/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che definisce la costruzione del task senseValidation.
     * Data una parola e una frase in cui appare, l’utente deve verificare se il senso fornito dal sistema è appropriato.
     * 
     * @author Mazzotta
     * 
     * @class
     * @extends quickstart.HTMLPageAnnotation
     */
    export class SenseValidation extends quickstart.HTMLPageAnnotation {
        /**
         * Link per il pulsante submit
         */
        public static SERVLET_URL : string = "senseValidation.jsp";

        /**
         * Descrizione del task della pagina
         */
        public static S_TASK : string = "Data la parola e una frase in cui appare, verificare se il senso fornito dal sistema \u00e8 appropriato.";

        /**
         * Parola presa dal back-end come esempio
         */
        /*private*/ word : HTMLLabelElement;

        /**
         * Esempio preso dal back-end come esempio
         */
        /*private*/ example : HTMLLabelElement;

        /**
         * Senso preso dal back-end come esempio
         */
        /*private*/ sense : HTMLLabelElement;

        /**
         * Div della pagina
         */
        /*private*/ pageDiv : HTMLDivElement;

        /**
         * Div dei pulsanti radio
         */
        /*private*/ radioDiv : HTMLDivElement;

        /**
         * Label per il pulsante radio no
         */
        /*private*/ noLabel : HTMLLabelElement;

        /**
         * Label per il pulsante radio si
         */
        /*private*/ yesLabel : HTMLLabelElement;

        /**
         * Pulsante radio si
         */
        /*private*/ radioButtonYes : HTMLInputElement;

        /**
         * Pulsante radio no
         */
        /*private*/ radioButtonNo : HTMLInputElement;

        public constructor() {
            super();
            if(this.word===undefined) this.word = null;
            if(this.example===undefined) this.example = null;
            if(this.sense===undefined) this.sense = null;
            if(this.pageDiv===undefined) this.pageDiv = null;
            if(this.radioDiv===undefined) this.radioDiv = null;
            if(this.noLabel===undefined) this.noLabel = null;
            if(this.yesLabel===undefined) this.yesLabel = null;
            if(this.radioButtonYes===undefined) this.radioButtonYes = null;
            if(this.radioButtonNo===undefined) this.radioButtonNo = null;
            this.setServlet(SenseValidation.SERVLET_URL);
            this.setTask(SenseValidation.S_TASK);
            this.word = this.createWord();
            this.example = this.createDescription();
            this.sense = this.createLabel("");
            this.setPage();
            this.pageDiv = this.createDiv();
            this.radioButtonYes = this.createInputRadio("optradio", "radioButtonYes");
            this.radioButtonNo = this.createInputRadio("optradio", "radioButtonNo");
            this.radioButtonNo.style.position = "relative";
            this.radioButtonNo.style.left = "10px";
            this.yesLabel = this.createLabel("Si");
            this.noLabel = this.createLabel("No");
            this.noLabel.style.position = "relative";
            this.noLabel.style.left = "10px";
            this.radioDiv = this.createDiv();
            this.radioDiv.className = "form-check-inline";
            $(this.radioDiv).append(this.yesLabel, this.radioButtonYes, this.noLabel, this.radioButtonNo);
            $(this.pageDiv).append(this.word, this.example, this.sense);
            $(this.getForm()).append(this.pageDiv, this.radioDiv, this.createDiv(), this.getDivButtons());
            this.getNext().onclick = <any>(((e) => {
                if(this.radioButtonYes.checked) this.radioButtonYes.name = "si"; else this.radioButtonNo.name = "no";
                return e;
            }));
            $("body").append(this.getForm());
        }

        /**
         * 
         */
        public setPage() {
            $.getJSON(quickstart.HTMLPageAnnotation.REST_URL, "task=SENSE_VALIDATION", (result, a, ctx) => {
                let json : JSON = <JSON>result;
                let sWord : string = <any>(json["word"]);
                let sExample : string = <any>(json["example"]);
                let sSense : string = <any>(json["sense"]);
                $(this.word).text(sWord);
                $(this.example).text(sExample);
                $(this.sense).text(sSense);
                return null;
            });
        }

        public static main(args : string[]) {
            new SenseValidation();
        }
    }
    SenseValidation["__class"] = "quickstart.SenseValidation";

}


quickstart.SenseValidation.main(null);

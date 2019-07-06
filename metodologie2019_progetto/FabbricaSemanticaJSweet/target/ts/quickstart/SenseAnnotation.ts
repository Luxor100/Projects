/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
namespace quickstart {
    /**
     * Classe che definisce la costruzione del task senseAnnotation.
     * Data una parola e una frase in cui la parola appare, l’utente deve selezionare il senso appropriato.
     * 
     * @author Mazzotta
     * @class
     * @extends quickstart.HTMLPageAnnotation
     */
    export class SenseAnnotation extends quickstart.HTMLPageAnnotation {
        /**
         * Link per il pulsante submit
         */
        public static SERVLET_URL : string = "senseAnnotation.jsp";

        /**
         * Descrizione del task della pagina
         */
        public static S_TASK : string = "Data la parola e una frase in cui la parola appare, selezionare il senso appropriato.";

        /**
         * Parola presa dal back-end come esempio
         */
        /*private*/ word : HTMLLabelElement;

        /**
         * Descrizione presa dal back-end come esempio
         */
        /*private*/ description : HTMLLabelElement;

        /**
         * Div per le checkbox della pagina
         */
        /*private*/ checkboxDiv : HTMLDivElement;

        /**
         * Div della pagina
         */
        /*private*/ pageDiv : HTMLDivElement;

        /**
         * Lista contenente i label per le checkbox
         */
        /*private*/ listaLabel : Array<HTMLLabelElement> = <any>([]);

        public constructor() {
            super();
            if(this.word===undefined) this.word = null;
            if(this.description===undefined) this.description = null;
            if(this.checkboxDiv===undefined) this.checkboxDiv = null;
            if(this.pageDiv===undefined) this.pageDiv = null;
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
        public setPage() {
            $.getJSON(quickstart.HTMLPageAnnotation.REST_URL, "task=SENSE_ANNOTATION", (result, a, ctx) => {
                let json : JSON = <JSON>result;
                let sWord : string = <any>(json["word"]);
                let sDescription : string = <any>(json["description"]);
                let sSenses : string[] = <any>(json["senses"]);
                for(let k : number = 0; k < sSenses.length; k++) {{
                    let labelSenses : HTMLLabelElement = this.createLabel("");
                    labelSenses.className = "form-check-label";
                    $(labelSenses).text(sSenses[k]);
                    /* add */(this.listaLabel.push(labelSenses)>0);
                };}
                let j : number = 1;
                $(this.word).text(sWord);
                $(this.description).text(sDescription);
                for(let index122=0; index122 < this.listaLabel.length; index122++) {
                    let label = this.listaLabel[index122];
                    {
                        $(this.checkboxDiv).append(label, this.createInputCheckbox("" + j++));
                        $(this.checkboxDiv).append(this.createDiv());
                    }
                }
                return null;
            });
        }

        public static main(args : string[]) {
            new SenseAnnotation();
        }
    }
    SenseAnnotation["__class"] = "quickstart.SenseAnnotation";

}


quickstart.SenseAnnotation.main(null);

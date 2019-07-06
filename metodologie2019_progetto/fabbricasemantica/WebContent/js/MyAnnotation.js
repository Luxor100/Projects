/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che definisce la costruzione del task senseValidation.
     * Date delle parole, l'utente deve tradurne il piu' possibile in un minuto
     * @author Mazzotta
     * @class
     * @extends quickstart.HTMLPageAnnotation
     */
    class MyAnnotation extends quickstart.HTMLPageAnnotation {
        constructor() {
            super();
            /**
             * Label per le risposte dell'utente
             */
            /*private*/ this.labels = [this.createWord(), this.createWord(), this.createWord(), this.createWord(), this.createWord(), this.createWord(), this.createWord(), this.createWord(), this.createWord(), this.createWord()];
            /**
             * Risposte dell'utente
             */
            /*private*/ this.responses = ([]);
            /**
             * int per il timer
             */
            /*private*/ this.time = 60;
            /**
             * true se time = 0;
             */
            /*private*/ this.done = false;
            /**
             * int per la creazione dei label dopo l'input dell'utente
             */
            /*private*/ this.n = 0;
            if (this.response === undefined)
                this.response = null;
            if (this.countdown === undefined)
                this.countdown = null;
            if (this.button === undefined)
                this.button = null;
            if (this.divResponse === undefined)
                this.divResponse = null;
            if (this.divLabel1 === undefined)
                this.divLabel1 = null;
            this.setServlet(MyAnnotation.SERVLET_URL);
            this.setTask(MyAnnotation.S_TASK);
            this.countdown = this.createLabel("60");
            this.countdown.style.fontSize = "70px";
            this.countdown.style.position = "relative";
            this.countdown.style.left = "600px";
            setInterval((() => { return this.countDown(); }), 1000);
            this.response = this.createInputText("response", false);
            this.button = this.createInputSubmit("button", "Invia");
            this.button.onclick = (((e) => {
                if (this.done) {
                    e.preventDefault();
                    return e;
                }
                else {
                    /* add */ (this.responses.push(this.createHiddenInputText("input" + (this.n++), this.response.value)) > 0);
                    this.response.value = "";
                    e.preventDefault();
                    return e;
                }
            }));
            this.setPage();
            this.setLabels();
            this.divResponse = this.createDiv();
            $(this.divResponse).append(this.response, this.button);
            $(this.getForm()).append(this.countdown);
            $(this.getForm()).append(this.divLabel1);
            $(this.getForm()).append(this.divResponse);
            $(this.getForm()).append(this.getDivButtons());
            this.getNext().onclick = (((e) => {
                for (let index121 = 0; index121 < this.responses.length; index121++) {
                    let input = this.responses[index121];
                    $(this.getForm()).append(input);
                }
                return e;
            }));
            $("body").append(this.getForm());
        }
        /**
         *
         */
        setPage() {
            $.getJSON(quickstart.HTMLPageAnnotation.REST_URL, "task=MY_ANNOTATION", (result, a, ctx) => {
                let json = result;
                let sWords = (json["words"]);
                for (let k = 0; k < 10; k++) {
                    $(this.labels[k]).text(sWords[k]);
                }
                return null;
            });
        }
        /**
         * Metodo per il countdown del timer, arrivato a 0 cambia in tempo scaduto
         * @private
         */
        /*private*/ countDown() {
            this.countdown.innerHTML = this.time + "";
            this.time--;
            if (this.time <= 0) {
                this.countdown.innerHTML = "Tempo Scaduto";
                this.countdown.style.color = "red";
                this.countdown.style.fontSize = "50px";
                this.countdown.style.left = "420px";
                this.done = true;
            }
        }
        /**
         * Metodo che insieme a setPage() setta gli esempi per la pagina
         * @private
         */
        /*private*/ setLabels() {
            this.divLabel1 = this.createDiv();
            this.divLabel1.className = "form-check-inline";
            for (let k = 0; k < 10; k++) {
                {
                    this.labels[k].style.marginLeft = "75px";
                    $(this.divLabel1).append(this.labels[k]);
                }
                ;
            }
        }
        static main(args) {
            new MyAnnotation();
        }
    }
    /**
     * Link per il pulsante submit
     */
    MyAnnotation.SERVLET_URL = "myAnnotation.jsp";
    /**
     * Descrizione del task della pagina
     */
    MyAnnotation.S_TASK = "Time Attack! Traduci quante piu\' parole in un minuto!";
    quickstart.MyAnnotation = MyAnnotation;
    MyAnnotation["__class"] = "quickstart.MyAnnotation";
})(quickstart || (quickstart = {}));
quickstart.MyAnnotation.main(null);

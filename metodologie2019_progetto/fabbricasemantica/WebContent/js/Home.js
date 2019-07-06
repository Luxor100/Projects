/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * Classe che definisce la costruzione della pagina home.
     * Permette all�utente di iniziare ad eseguire i task di annotazione/validazione.
     *
     * @author Mazzotta
     *
     * @class
     * @extends quickstart.HTMLPage
     */
    class Home extends quickstart.HTMLPage {
        constructor() {
            super();
            if (this.imgStart === undefined)
                this.imgStart = null;
            this.imgStart = this.createInputImg("https://i.ibb.co/N6Mynhy/START.jpg", "170px", "500px");
            this.imgStart.style.position = "relative";
            this.imgStart.style.left = "400px";
            this.imgStart.style.top = "150px";
            this.imgStart.onclick = (e) => {
                this.setRandomServlet();
                return e;
            };
            $(this.getForm()).append(this.imgStart);
            $("body").append(this.getForm());
        }
        static main(args) {
            new Home();
        }
    }
    quickstart.Home = Home;
    Home["__class"] = "quickstart.Home";
})(quickstart || (quickstart = {}));
quickstart.Home.main(null);

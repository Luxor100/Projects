package quickstart;


import def.dom.HTMLInputElement;

import static def.jquery.Globals.$;
/**
 * Classe che definisce la costruzione della pagina home.
 * Permette all’utente di iniziare ad eseguire i task di annotazione/validazione.
 * 
 * @author Mazzotta
 * 
 */
public class Home extends HTMLPage{
	
	/**
	 * Immagine con link per i task
	 */
	private HTMLInputElement imgStart;
	
	public Home() {
		super();
		
		imgStart = createInputImg("https://i.ibb.co/N6Mynhy/START.jpg", "170px", "500px");
		imgStart.style.position = "relative";
		imgStart.style.left = "400px";
		imgStart.style.top = "150px";
		imgStart.onclick = e -> { setRandomServlet(); return e; };
		
		$(getForm()).append(imgStart);
		$("body").append(getForm());
	}
	
	public static void main(String[] args) {
		new Home();
	}
}

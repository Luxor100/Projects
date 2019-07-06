package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Se l'utente esiste gia' nel database l'utente viene reindirizzato alla pagina di signup, 
 * altrimenti viene salvato nella base di dati e reindirizzato alla home
 * I dati sono salvati nel formato "nomeAttributo=input"
 * @author Mazzotta
 *
 */
@WebServlet(name="SignupServlet", urlPatterns="/signup.jsp")
public class SignupServlet extends BaseServlet {
	private static final long serialVersionUID = 8484501789787L;
	
	/**
	 * Parte del path per la cartella contenente la base di dati
	 */
	public static final String CARTELLA_INIZIALE = ".";
	/**
	 * Parte del path per la cartella contenente la base di dati
	 */
	public static final String DATA = "Data.txt";
	/**
	 * Path per la cartella contenente la base di dati
	 */
	public static final Path PATHDATA = Paths.get(CARTELLA_INIZIALE, DATA);
	/**
	 * Percorso per la cartella contenente la base di dati
	 */
	public static final String FILEDATA = CARTELLA_INIZIALE + File.separator + DATA;
	/**
	 * true se l'email e' gia' presente nella base di dati
	 */
	private boolean isInData;
	
	/**
	 * Appende nella base di dati le informazioni immesse dall'utente
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> lines = new ArrayList<>();
		String username = (String) request.getParameter("emailUtente");
		Map<String, String[]> mappa = request.getParameterMap();
		mappa.forEach((s, value) -> { if (s.equals("Inglese") || s.equals("Italiano")) 
											lines.add("Madrelingua="+s);
									else if (s.equals("Inglese=") || s.equals("Italiano="))
											lines.add(s+value[0]);
									else lines.add(s+"="+value[0]);
		});
		String stringa = "";
		for (String s : lines) 
			stringa+= s+ " ";
		stringa = stringa.substring(0, stringa.length()-1);
		
		Path path = PATHDATA;
		try(FileWriter fw = new FileWriter(FILEDATA, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    Files.lines(path)
			    	.forEach(s -> { if (s.contains("emailUtente="+username)) isInData = true;});
				if (!isInData) {
					out.println(stringa);
					response.sendRedirect("home.html");
				}
				else {
					isInData = false;
					response.sendRedirect("signup.html");
				}
			} catch (IOException e) {
			    e.printStackTrace();
		}
	}

}

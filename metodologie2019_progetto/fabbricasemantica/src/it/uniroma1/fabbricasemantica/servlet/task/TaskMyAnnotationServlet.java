package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import it.uniroma1.fabbricasemantica.servlet.user.SignupServlet;

/**
 * Servlet che salva i dati del task nella base di dati. I dati sono salvati nel formato "nomeTask=Input"
 * @author Mazzotta
 *
 */
@WebServlet(name = "TaskMyAnnotationServlet", urlPatterns = "/myAnnotation.jsp")
public class TaskMyAnnotationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Array contenente gli indirizzi per il pulsante next
	 */
	public static final String[] arrayIndirizzi = new String[] { "translationAnnotation.html", "wordAnnotation.html", "definitionAnnotation.html",
			"senseAnnotation.html", "translationValidation.html", "senseValidation.html",
			"myAnnotation.html"};
	/**
	 * separator
	 */
	public static String newline = System.getProperty("line.separator");

	/**
	 * Legge e salva la base di dati, modifica le informazioni dell'utente in base all'input e riscrive la base di dati
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> lines = new ArrayList<>();
		Map<String, String[]> mappa = request.getParameterMap();
		mappa.forEach((s, value) -> lines.add(value[0]));
		String stringa = " myAnnotation=";
		for (String s : lines) 
			stringa+= s+ " ";
		stringa = stringa.substring(0, stringa.length()-1);
		
		String tot = "";
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		try (BufferedReader br = Files.newBufferedReader(SignupServlet.PATHDATA)) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("emailUtente="+username))
					tot+= line + stringa + newline;
				else tot+= line + newline;
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		try(FileWriter fw = new FileWriter(SignupServlet.FILEDATA, false);
			    BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
				out.print("");
				out.write(tot);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		int n = (int) (Math.random()*(arrayIndirizzi.length));
		response.sendRedirect(arrayIndirizzi[n]);
	}
}

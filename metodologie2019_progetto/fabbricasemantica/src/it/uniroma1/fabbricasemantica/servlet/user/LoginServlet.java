package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.nio.file.Files;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Se nella base di dati e' presente l'utente, viene salvato come autenticato, altrimenti reindirizzato
 * alla pagina di login
 * @author Mazzotta
 *
 */
@WebServlet(name="LoginServlet", urlPatterns="/login.jsp")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 8484501789787L;

	/**
	 * true if l'utente esiste nella base di dati
	 */
	private boolean isInData;
	
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getParameter("emailUtente");
		String password = (String) request.getParameter("passwordUtente");
		
		try {
			Files.lines(SignupServlet.PATHDATA)
				.forEach(s ->  { if (s.contains("passUtente="+password) && s.startsWith("emailUtente="+email)) isInData = true;});
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		if (isInData) {
			HttpSession session = request.getSession();
			session.setAttribute("username", email);
			isInData = false;
			response.sendRedirect("home.html");
		}
		else response.sendRedirect("login.html");
	}

}

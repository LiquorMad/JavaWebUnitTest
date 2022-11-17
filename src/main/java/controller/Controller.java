package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/logar", "/insert", "/listar", "/novo" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans utilizador = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/insert")) {
			novoUtilizador(request, response);
		} else if (action.equals("/listar")) {
			listarUtilizador(request, response);
		} else if (action.equals("/logar")) {
			logar(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar Utilizador
	protected void listarUtilizador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// criando objecto que vai receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarUtilizadores();
		// Encaminhar lista para utilizador.jsp
		request.setAttribute("utilizador", lista);
		RequestDispatcher rd = request.getRequestDispatcher("utilizador.jsp");
		rd.forward(request, response);
	}

	// verefica se o utilizador esta logado
	protected boolean authencication(String username, String password) {
		ArrayList<JavaBeans> lista = dao.listarUtilizadores();
		for (int i = 0; i < lista.size(); i++) {
			if ((lista.get(i).getUser().equals(username) && lista.get(i).getPassword().equals(password))
					&& isValidlenghtPassword(password)) {
				return true;
			}
		}
		return false;
	}

	// retorna tamanho de password
	protected boolean isValidlenghtPassword(String password) {
		return (password.length() >= 12 && password.length() <= 64);
	}

	// vereficar input
	protected boolean isValidName(String name) {
		return name.matches("[a-zA-Z]{2,}");
	}

	/**
	 * protected boolean isValidEmail() {
	 * 
	 * } protected boolean isValidPhone() {
	 * 
	 * }
	 **/

	ArrayList<Cookie> cookie = new ArrayList<>();

	protected void logar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// criando objecto que vai receber os dados JavaBeans
		if (authencication(request.getParameter("user"), request.getParameter("psw"))) {
			response.sendRedirect("listar");

			// Cookie
			Cookie cookies[] = request.getCookies();
			cookie.add(cookies[0]);
			System.out.println("tamanho cookie: " + cookies.length);
			System.out.println("Valor do cookie : " + cookies[0].getValue());
			System.out.println("Secure cookie: " + cookies[0].getSecure());
			String cookieName = "SAPCookie";
			String defaultValue = "1";
			// Cookie
		} else {
			System.out.println("erro no login");
		}
	}

	protected boolean isSecureCookie() {
		// Cookie
		boolean isSecure = false;
		for (int i = 0; i < cookie.size(); i++) {
			isSecure = cookie.get(i).getSecure();
		}
		return isSecure;
		// Cookie
	}

	protected void novoUtilizador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis JavaBeans
		utilizador.setName(request.getParameter("name"));
		utilizador.setEmail(request.getParameter("email"));
		utilizador.setPhone(request.getParameter("phone"));
		utilizador.setUser(request.getParameter("user"));
		utilizador.setPassword(request.getParameter("psw"));
		// invocar o método inserirUtilzador passando o Objecto utilizador
		dao.inserirUtilzador(utilizador);
		// redicionamento para documento agenda.jsp
		response.sendRedirect("listar");
	}

}

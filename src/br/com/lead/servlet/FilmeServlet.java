package br.com.lead.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lead.modelo.Filme;
import br.com.lead.util.JPAUtil;


@WebServlet("/filme")
public class FilmeServlet extends HttpServlet {

	private static final long serialVersionUID = 8018533721461228920L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		Filme filme = em.find(Filme.class, 1);
		
		em.close();
		
		ArrayList<Filme> listaFiltrada = new ArrayList<Filme>();
		listaFiltrada.add(filme);
		
		req.setAttribute("listaFiltrada", listaFiltrada);
		
		RequestDispatcher dispather = req.getRequestDispatcher("lista-filmes.jsp");
		dispather.forward(req, resp);
		
	}
}

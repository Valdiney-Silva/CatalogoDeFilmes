package br.com.lead.servlet;

import java.io.IOException;
import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lead.modelo.Filme;



@WebServlet("/persistir-filme")
public class PersisteFilmeServlet extends HttpServlet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8533932775601250471L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String genero = req.getParameter("genero");
		Long ano = Long.parseLong(req.getParameter("ano"));

		Filme filme = new Filme(nome, genero, ano);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogodefilmes");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(filme);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}

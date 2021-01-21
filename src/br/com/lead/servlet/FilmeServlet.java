package br.com.lead.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lead.modelo.Filme;


@WebServlet("/filme")
public class FilmeServlet extends HttpServlet {

	private static final long serialVersionUID = 8018533721461228920L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Filme filme1 = new Filme("O Irlandês", "Acao", 2019L);
		Filme filme2 = new Filme("Logan", "Aventura", 2017L);
		Filme filme3 = new Filme("DeadPool", "Comedia", 2016L);
		Filme filme4 = new Filme("Jogos Mortais", "Terror", 2010L);
		Filme filme5 = new Filme("Carros 2", "Desenho", 2018L);
		
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		filmes.add(filme1);
		filmes.add(filme2);
		filmes.add(filme3);
		filmes.add(filme4);
		filmes.add(filme5);
		String genero = req.getParameter("genero");

		
		ArrayList<Filme> listaFiltrada = filmes.stream().filter(filme -> filme.getGenero().equalsIgnoreCase(genero))
				.collect(Collectors.toCollection(ArrayList::new));
		
		req.setAttribute("listaFiltrada", listaFiltrada);
		
		RequestDispatcher dispacther = req.getRequestDispatcher("/infofilme.jsp");
		dispacther.forward(req, resp);
	}
}

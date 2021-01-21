<%@page import="br.com.lead.modelo.Filme"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Informações dos filmes</title>
</head>
<body>
	<h2>Informações dos filmes</h2>
	<ul>
		<%
			ArrayList<Filme> listaDeFilmes = new ArrayList<Filme>();
		listaDeFilmes = (ArrayList<Filme>) request.getAttribute("listaFiltrada");

		for (Filme filme : listaDeFilmes) {
		%>
		<table cellspacing=0 cellpadding=2 bordercolor="black">
		<li>
			<tr align="left">
				<th><%out.println("Nome:");%></th>
				<td><%out.println(filme.getNome());%></td>
			</tr>
			<tr align="left">	
				<th><%out.println("Genero:");%></th>
				<td><%out.println(filme.getGenero());%></td>
			</tr>
			<tr  align="left">	
				<th><%out.println("Ano:");%></th>
				<td><%out.println(filme.getAno());%></td>
			</tr>
		</li>
		</table>
		<%
			}
		%>
	</ul>
</body>
</html>
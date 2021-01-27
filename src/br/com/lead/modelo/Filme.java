package br.com.lead.modelo;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="filme")
@Table(name="filme")
public class Filme implements Serializable {

	private static final long serialVersionUID = 7950490320492982513L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private int id;
	
	@Column (name ="filme", nullable = false)
	private String nome;
	private String genero;
	private int ano;
	
	@ManyToOne
	private Autor autor;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Filme() {
		
	}
	
	public Filme(String nome, String genero, int ano) {
		this.nome = nome;
		this.genero = genero;
		this.ano = ano;
	}
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
	public String getNome() {
		return nome;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public int getAno() {
		return ano;
	}
}
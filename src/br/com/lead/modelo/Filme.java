package br.com.lead.modelo;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity(name="filme")
@Table(name="filme")
public class Filme implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7950490320492982513L;

	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private Long id;
	
	@Column (name ="filme", nullable = false)
	private String nome;
	
	@Column (name ="genero", nullable = false)
	private String genero;
	
	@Column (name ="ano", nullable = false)
	private Long ano;
	
	public Filme() {}
	
	public Filme(String nome, String genero, Long ano) {
		this.nome = nome;
		this.genero = genero;
		this.ano = ano;
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
	public String getNome() {
		return nome;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public Long getAno() {
		return ano;
	}
}
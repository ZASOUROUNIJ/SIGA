package br.com.siga.repository.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_turma")
@NamedQueries({
	 
	@NamedQuery(name = "TurmaEntity.findAll",query= "SELECT t FROM TurmaEntity t")
 
})

public class TurmaEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private Integer Id;
	
	@Column(name = "nivel")
	private String nivel;
	
	@Column(name= "nome")
	private String nome;
	
	@Column(name = "turno")
	private String turno;
	
	@Column(name = "professor")
	private Integer professor; 

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Integer getProfessor() {
		return professor;
	}

	public void setProfessor(Integer professor) {
		this.professor = professor;
	}

	
	
	
	
	
	
}

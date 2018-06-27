package br.com.siga.repository.entity;

import java.time.LocalDateTime;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 
 
@Entity
@Table(name="tb_professor")
@NamedQueries({
	 
	@NamedQuery(name = "ProfessorEntity.findAll",query= "SELECT p FROM ProfessorEntity p")
 
})

public class ProfessorEntity {

	@Id
	@GeneratedValue
	@Column(name = "matricula")
	private Integer codigo;
 
	@Column(name = "nome")
	private String  nome;
 
	@Column(name = "dataNasc")
	private Date	data;
 
	@Column(name = "telefone")
	private String  telefone;
	
	@Column(name = "endereco")
	private String  endereco;
	
	@Column(name = "dt_cadastro")
	private LocalDateTime	dataCad;
 

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public LocalDateTime getDataCad() {
		return dataCad;
	}
	public void setDataCad(LocalDateTime dataCad) {
		this.dataCad = dataCad;
	}
 
}

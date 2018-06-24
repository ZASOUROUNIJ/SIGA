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
@Table(name="tb_aluno")
@NamedQueries({
	 
	@NamedQuery(name = "PessoaEntity.findAll",query= "SELECT p FROM PessoaEntity p")
 
})
public class PessoaEntity {
 
	@Id
	@GeneratedValue
	@Column(name = "matricula")
	private Integer codigo;
 
	@Column(name = "nome")
	private String  nome;
 
	@Column(name = "sexo")
	private String  sexo;
 
	@Column(name = "dataNasc")
	private Date	data;
 
	@Column(name = "idade")
	private int    idade;
 
	@Column(name = "nomePai")
	private String  pai;
 
	@Column(name = "nomeMae")
	private String  mae;
	
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getMae() {
		return mae;
	}
	public void setMae(String mae) {
		this.mae = mae;
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
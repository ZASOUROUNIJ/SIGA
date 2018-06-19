package br.com.siga.model;

public class TurmaModel {
	private Integer Id;
	private String nivel;
	private String nome;
	private String turno;
	private Integer professor;
	private UsuarioModel usuarioModel;
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
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	
	
	
}

package br.com.siga.model;

import java.io.Serializable;

public class UsuarioModel implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private int codigo;
	private String usuario;
	private String senha;
	//private UsuarioModel usuarioModel;
 
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	//public UsuarioModel getUsuarioModel() {
	//	return usuarioModel;
	//}
	//public void setUsuarioModel(UsuarioModel usuarioModel) {
	//	this.usuarioModel = usuarioModel;
	//}
 
}

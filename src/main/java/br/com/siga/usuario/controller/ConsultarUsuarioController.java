package br.com.siga.usuario.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
 
import br.com.siga.model.UsuarioModel;
import br.com.siga.repository.UsuarioRepository;
//import org.junit.Test;

@Named(value="consultarUsuarioController")
@ViewScoped
public class ConsultarUsuarioController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private UsuarioModel usuarioModel;
 
	@Produces 
	private List<UsuarioModel> usuarios;
 
	@Inject transient
	private UsuarioRepository usuarioRepository;
 
	public List<UsuarioModel> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioModel> usuarios) {
		this.usuarios = usuarios;
	}		
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
 
	/***
	 * CARREGA AS PESSOAS NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		//RETORNAR AS PESSOAS CADASTRADAS
		this.usuarios = usuarioRepository.GetUsuarios();
	}
 
	public void Editar(UsuarioModel usuarioModel){ 
		this.usuarioModel = usuarioModel;
 
	}

 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 * @throws ParseException 
	 */
	public void AlterarRegistro() throws ParseException{
 
		this.usuarioRepository.AlterarRegistro(this.usuarioModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param pessoaModel
	 */
	public void ExcluirUsuario(UsuarioModel usuarioModel){
 
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.usuarioRepository.ExcluirRegistro(usuarioModel.getCodigo());
 
		//REMOVENDO A PESSOA DA LISTA
		//ASSIM QUE É A PESSOA É REMOVIDA DA LISTA O DATATABLE É ATUALIZADO
		this.usuarios.remove(usuarioModel);
 
	}
 
}


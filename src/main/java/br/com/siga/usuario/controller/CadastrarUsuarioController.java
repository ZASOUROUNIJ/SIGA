package br.com.siga.usuario.controller;

import java.text.ParseException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.siga.model.UsuarioModel;
import br.com.siga.repository.UsuarioRepository;
import br.com.siga.uteis.Uteis;

@Named(value="cadastrarUsuarioController")
@RequestScoped
public class CadastrarUsuarioController {

	@Inject
	UsuarioModel usuarioModel;
 
	@Inject
	UsuarioController usuarioController;
 
	@Inject
	UsuarioRepository usuarioRepository;
 
 
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
 
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 * @throws ParseException 
	 */
	public void SalvarNovoUsuario() throws ParseException{
 
		//usuarioModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());
 
		//INFORMANDO QUE O CADASTRO FOI VIA INPUT
 
		usuarioRepository.SalvarNovoRegistro(this.usuarioModel);
 
		this.usuarioModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
}

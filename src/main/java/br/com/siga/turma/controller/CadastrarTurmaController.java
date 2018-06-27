package br.com.siga.turma.controller;

import java.text.ParseException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
 
import br.com.siga.model.TurmaModel;
import br.com.siga.repository.TurmaRepository;
import br.com.siga.uteis.Uteis;

@Named(value="cadastrarTurmaController")
@RequestScoped
public class CadastrarTurmaController {
	@Inject
	TurmaModel turmaModel;
 
	@Inject
	TurmaRepository turmaRepository;
	
	public TurmaModel getTurmaModel() {
		return turmaModel;
	}
 
	public void setTurmaModel(TurmaModel turmaModel) {
		this.turmaModel = turmaModel;
	}
	
	public void SalvarNovaTurma() throws ParseException{
 
		//INFORMANDO QUE O CADASTRO FOI VIA INPUT
 
		turmaRepository.SalvarNovoRegistro(this.turmaModel);
 
		this.turmaModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
}

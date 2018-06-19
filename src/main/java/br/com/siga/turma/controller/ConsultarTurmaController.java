package br.com.siga.turma.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.siga.model.PessoaModel;
import br.com.siga.model.TurmaModel;
import br.com.siga.repository.TurmaRepository;

@Named(value="consultarTurmaController")
@ViewScoped
public class ConsultarTurmaController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject transient
	private TurmaModel turmaModel;
 
	@Produces 
	private List<TurmaModel> turmas;
 
	@Inject transient
	private TurmaRepository turmaRepository;
	
	public List<TurmaModel> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<TurmaModel> turmas) {
		this.turmas = turmas;
	}		
	public TurmaModel getTurmaModel() {
		return turmaModel;
	}
	public void setTurmaModel(TurmaModel turmaModel) {
		this.turmaModel = turmaModel;
	}
	
	@PostConstruct
	public void init(){
 
		//RETORNAR AS PESSOAS CADASTRADAS
		this.turmas = turmaRepository.GetTurmas();
	}
	
	public void Editar(TurmaModel turmaModel){
		 
		/*PEGA APENAS A PRIMEIRA LETRA DO SEXO PARA SETAR NO CAMPO(M OU F)*/
 
		this.turmaModel = turmaModel;
 
	}
	
	public void AlterarRegistro() throws ParseException{
		 
		this.turmaRepository.AlterarRegistro(this.turmaModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	public void ExcluirTurma(TurmaModel turmaModel){
		 
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.turmaRepository.ExcluirRegistro(turmaModel.getId());
 
		//REMOVENDO A PESSOA DA LISTA
		//ASSIM QUE É A PESSOA É REMOVIDA DA LISTA O DATATABLE É ATUALIZADO
		this.turmas.remove(turmaModel);
 
	}
	
}

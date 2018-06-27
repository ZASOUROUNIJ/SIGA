package br.com.siga.professor.controler;

import java.text.ParseException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.siga.model.ProfessorModel;
import br.com.siga.repository.ProfessorRepository;
import br.com.siga.uteis.Uteis;

//import org.junit.Test;

@Named(value="cadastrarProfessorController")
@RequestScoped
public class CadastrarProfessorController {

	@Inject
	ProfessorModel professorModel;
 
	@Inject
	ProfessorRepository professorRepository;
 
 
	public ProfessorModel getProfessorModel() {
		return professorModel;
	}
 
	public void setProfessorModel(ProfessorModel professorModel) {
		this.professorModel = professorModel;
	}
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 * @throws ParseException 
	 */
	public void SalvarNovoProfessor() throws ParseException{
 
		//INFORMANDO QUE O CADASTRO FOI VIA INPUT
 
		professorRepository.SalvarNovoRegistro(this.professorModel);
 
		this.professorModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
 
	}
}

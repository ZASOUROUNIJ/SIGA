package br.com.siga.professor.controler;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.siga.model.ProfessorModel;
import br.com.siga.repository.ProfessorRepository;
//import org.junit.Test;

@Named(value="consultarProfessorController")
@ViewScoped
public class ConsultarProfessorController implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Inject transient
	private ProfessorModel professorModel;
 
	@Produces 
	private List<ProfessorModel> professores;
 
	@Inject transient
	private ProfessorRepository professorRepository;
 
	public List<ProfessorModel> getProfessores() {
		return professores;
	}
	public void setProfessores(List<ProfessorModel> professores) {
		this.professores = professores;
	}		
	public ProfessorModel getProfessorModel() {
		return professorModel;
	}
	public void setProfessorModel(ProfessorModel professorModel) {
		this.professorModel = professorModel;
	}
 
	/***
	 * CARREGA AS PESSOAS NA INICIALIZAÇÃO 
	 */
	@PostConstruct
	public void init(){
 
		//RETORNAR AS PESSOAS CADASTRADAS
		this.professores = professorRepository.GetProfessores();
	}
 
	/***
	 * CARREGA INFORMAÇÕES DE UM PROFESSOR PARA SER EDITADO
	 * @param pessoaModel
	 */
	public void Editar(ProfessorModel professorModel){ 
		this.professorModel = professorModel;
 
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 * @throws ParseException 
	 */
	public void AlterarRegistro() throws ParseException{
 
		this.professorRepository.AlterarRegistro(this.professorModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param pessoaModel
	 */
	public void ExcluirProfessor(ProfessorModel professorModel){
 
		//EXCLUI O PROFESSOR DO BANCO DE DADOS
		this.professorRepository.ExcluirRegistro(professorModel.getCodigo());
 
		//REMOVENDO O PROFESSOR DA LISTA
		//ASSIM QUE O PROFESSOR É REMOVIDO DA LISTA O DATATABLE É ATUALIZADO
		this.professores.remove(professorModel);
 
	}
 
}

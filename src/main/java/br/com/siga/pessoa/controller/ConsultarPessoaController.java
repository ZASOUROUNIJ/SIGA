package br.com.siga.pessoa.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
 
import br.com.siga.model.PessoaModel;
import br.com.siga.repository.PessoaRepository;
//import org.junit.Test;

@Named(value="consultarPessoaController")
@ViewScoped
public class ConsultarPessoaController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	@Inject transient
	private PessoaModel pessoaModel;

    @Produces 
	private List<PessoaModel> pessoas;
 
	@Inject transient
	private PessoaRepository pessoaRepository;
	
	private int id_turma;
    private int ano;
	
	public int getId_turma() {
        return id_turma;
    }
    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public List<PessoaModel> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<PessoaModel> pessoas) {
		this.pessoas = pessoas;
	}	
	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}
	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}
	
 
	/***
	 * CARREGA AS PESSOAS NA INICIALIZA��O 
	 */
	@PostConstruct
	public void init(){
 
		//RETORNAR AS PESSOAS CADASTRADAS
		this.pessoas = pessoaRepository.GetPessoas();
	}
 
	/***
	 * CARREGA INFORMA��ES DE UMA PESSOA PARA SER EDITADA
	 * @param pessoaModel
	 */
	public void Editar(PessoaModel pessoaModel){
 
		/*PEGA APENAS A PRIMEIRA LETRA DO SEXO PARA SETAR NO CAMPO(M OU F)*/
		pessoaModel.setSexo(pessoaModel.getSexo().substring(0, 1));
 
		this.pessoaModel = pessoaModel;
 
	}
 
	/***
	 * ATUALIZA O REGISTRO QUE FOI ALTERADO
	 * @throws ParseException 
	 */
	public void AlterarRegistro() throws ParseException{
 
		this.pessoaRepository.AlterarRegistro(this.pessoaModel);	
 
 
		/*RECARREGA OS REGISTROS*/
		this.init();
	}
	
	/***
	 * EXCLUINDO UM REGISTRO
	 * @param pessoaModel
	 */
	public void ExcluirPessoa(PessoaModel pessoaModel){
 
		//EXCLUI A PESSOA DO BANCO DE DADOS
		this.pessoaRepository.ExcluirRegistro(pessoaModel.getCodigo());
 
		//REMOVENDO A PESSOA DA LISTA
		//ASSIM QUE � A PESSOA � REMOVIDA DA LISTA O DATATABLE � ATUALIZADO
		this.pessoas.remove(pessoaModel);
 
	}
	
	/***
     * ATUALIZA O REGISTRO QUE FOI ALTERADO
     * @throws ParseException 
     */
    public void AlocarAluno() throws ParseException{
 
        this.pessoaRepository.AlocarAluno(this.pessoaModel.getCodigo(), id_turma, ano); 
 
    }
}

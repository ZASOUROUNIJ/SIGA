package br.com.siga.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.siga.model.PessoaModel;
import br.com.siga.model.UsuarioModel;
import br.com.siga.repository.PessoaRepository;

public class InsertAlunoTest {

	
	//PessoaModel pessoaEntity;

	PessoaRepository dao;
	PessoaModel pessoaModel;

	@Before
	public void setUp() throws Exception {
		dao = new PessoaRepository();
		
		pessoaModel = new PessoaModel();
		pessoaModel.setNome("Aluno Test");
		pessoaModel.setSexo("M");
		pessoaModel.setData("16/05/2018");
		pessoaModel.setIdade(22);
		pessoaModel.setPai("Pai Aluno");
		pessoaModel.setMae("Mãe Aluno");
		pessoaModel.setTelefone("9 9602-9665");
		pessoaModel.setEndereco("Rua do Aluno");

		UsuarioModel usuarioEntity = new UsuarioModel();
		usuarioEntity.setCodigo("1");
		usuarioEntity.setSenha("123456");
		usuarioEntity.setUsuario("admin");

		pessoaModel.setUsuarioModel(usuarioEntity);
	}

	@After
	public void tearDown() throws Exception {
		 try {
			 //Pega a lista de alunos cadastrados no banco de dados
			 List<PessoaModel> alunos = dao.GetPessoas();
			 
			 //Pega o último aluno(que foi cadastrado pelo teste) 
			 pessoaModel = alunos.get(alunos.size() -1);
			 
			 //Exclui do Banco de Dados o aluno inserido pelo teste
			 dao.ExcluirRegistro(pessoaModel.getCodigo());
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	
	@Test
	public void testSalvarNovoRegistro() throws Exception {
		List<PessoaModel> alunos = dao.GetPessoas();
		int valueOld = alunos.size();
		
		dao.SalvarNovoRegistro(pessoaModel);
		
		alunos = dao.GetPessoas();
		int valueNew = alunos.size();
		
		assertEquals("T01", valueOld+1, valueNew);
		
		
		
	}
	/*
	@Test
	public void test() {
		dao = new PessoaRepository();

		System.out.println("Inserindo Aluno");

		pessoaEntity = new PessoaModel();
		pessoaEntity.setCodigo(32);
		pessoaEntity.setNome("Antonio Carlos Florentino De Souza Junior");
		pessoaEntity.setSexo("M");
		pessoaEntity.setData("16/05/2018");
		pessoaEntity.setIdade(22);
		pessoaEntity.setPai("Antonio Carlos Florentino De Souza");
		pessoaEntity.setMae("Maria Assunção Pereira");
		pessoaEntity.setTelefone("(84)996869885");
		pessoaEntity.setEndereco("Rua: Major Ajax");
		pessoaEntity.setDataCad(LocalDateTime.now());

		UsuarioModel usuarioEntity = new UsuarioModel();
		usuarioEntity.setCodigo("1");
		usuarioEntity.setSenha("123456");
		usuarioEntity.setUsuario("admin");

		pessoaEntity.setUsuarioModel(usuarioEntity);
		
		try {
			dao.SalvarNovoRegistro(pessoaEntity);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}

		System.out.println("Fim da inserção");
		//assertEquals(2,2);
	}*/
	//@Test
	public void testGetPessoas() {
		List<PessoaModel> pessoas = dao.GetPessoas();
		
		assertNotNull("T01", pessoas);
		
		int tamanho = pessoas.size();
		
		//Inserir um pessoa
		
		pessoas = dao.GetPessoas();
		
		assertEquals("T02", tamanho, pessoas.size());
	
	}

	//@Test
	public void testAlterarRegistro() {
		fail("Not yet implemented");
	}

	//@Test
	public void testExcluirRegistro() {
		fail("Not yet implemented");
	}
	
}
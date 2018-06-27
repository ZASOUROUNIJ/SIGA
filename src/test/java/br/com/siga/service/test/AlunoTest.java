package br.com.siga.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.siga.model.PessoaModel;
import br.com.siga.repository.PessoaRepository;

public class AlunoTest {

	// PessoaModel pessoaEntity;

	PessoaRepository dao;
	PessoaModel aluno1;
	PessoaModel aluno2;
	PessoaModel alunoAux;

	@Before
	public void setUp() throws Exception {
		dao = new PessoaRepository();

		// preenchendo o Aluno1
		aluno1 = new PessoaModel();
		aluno1.setNome("Aluno Test Um");
		aluno1.setSexo("M");
		aluno1.setData("16/05/2018");
		aluno1.setIdade(22);
		aluno1.setPai("Pai Aluno Um");
		aluno1.setMae("Mãe Aluno Um");
		aluno1.setTelefone("9 9602-9665");
		aluno1.setEndereco("Rua do Aluno Um");

		// preenchendo o Aluno2
		aluno2 = new PessoaModel();
		aluno2.setNome("Aluno Test Dois");
		aluno2.setSexo("M");
		aluno2.setData("16/05/2018");
		aluno2.setIdade(22);
		aluno2.setPai("Pai Aluno Dois");
		aluno2.setMae("Mãe Aluno Dois");
		aluno2.setTelefone("9 9602-9665");
		aluno2.setEndereco("Rua do Aluno Dois");

		// preenchendo o AlunoAux
		alunoAux = new PessoaModel();

	}

	// @After
	public void tearDown() throws Exception {
		try {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSalvarNovoRegistro() throws Exception {
		try {
			List<PessoaModel> alunos = dao.GetPessoas();
			int valueOld = alunos.size();

			dao.SalvarNovoRegistro(aluno1);

			alunos = dao.GetPessoas();
			int valueNew = alunos.size();

			assertNotNull("1", aluno1);
			assertEquals("2", valueOld + 1, valueNew);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testBuscar() throws Exception {
		try {
			// Pega a lista de alunos cadastrados no banco de dados
			List<PessoaModel> alunos = dao.GetPessoas();

			// Pega o último aluno(que foi cadastrado pelo teste)
			alunoAux = alunos.get(alunos.size()-1);

			String nome = alunoAux.getNome();

			
			assertEquals("1", "Aluno Test Um", nome);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testExcluirRegistro() throws Exception {
		try {
			

			//dao.SalvarNovoRegistro(aluno2);
			
			// Pega a lista de alunos cadastrados no banco de dados
			List<PessoaModel> alunos = dao.GetPessoas();
			int valueOld = alunos.size();
			
			// Pega o último aluno(que foi cadastrado pelo teste)
			alunoAux = alunos.get(alunos.size());
			
			// Exclui do Banco de Dados o aluno inserido pelo teste
			dao.ExcluirRegistro(alunoAux.getCodigo());
			
			alunos = dao.GetPessoas();
			int valueNew = alunos.size();

			assertEquals("1", valueOld -1 , valueNew);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void testGetPessoas() {
		List<PessoaModel> pessoas = dao.GetPessoas();

		assertNotNull("T01", pessoas);

		int tamanho = pessoas.size();

		// Inserir um pessoa

		pessoas = dao.GetPessoas();

		assertEquals("T02", tamanho, pessoas.size());

	}

	// @Test
	public void testAlterarRegistro() {
		fail("Not yet implemented");
	}

}
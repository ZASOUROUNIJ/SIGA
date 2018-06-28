package br.com.siga.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.siga.model.ProfessorModel;
import br.com.siga.repository.ProfessorRepository;


public class ProfessorTest {
	// PessoaModel pessoaEntity;

	ProfessorRepository dao;
	ProfessorModel professor1;
	ProfessorModel professor2;
	ProfessorModel professorAux;

	@Before
	public void setUp() throws Exception {
		dao = new ProfessorRepository();

		// preenchendo o Aluno1
		professor1 = new ProfessorModel();
		professor1.setNome("Professor Test Um");
		professor1.setData("16/05/2018");
		professor1.setTelefone("9 9602-9665");
		professor1.setEndereco("Rua do Aluno Um");

		// preenchendo o Aluno2
		professor2 = new ProfessorModel();
		professor2.setNome("Professor Test Dois");
		professor2.setData("16/05/2018");
		professor2.setTelefone("9 9602-9665");
		professor2.setEndereco("Rua do Aluno Dois");

		// preenchendo o AlunoAux
		professorAux = new ProfessorModel();

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
			List<ProfessorModel> professores = dao.GetProfessores();
			int valueOld = professores.size();

			dao.SalvarNovoRegistro(professor1);

			professores = dao.GetProfessores();
			int valueNew = professores.size();

			assertNotNull("1", professor1);
			assertEquals("2", valueOld + 1, valueNew);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testBuscar() throws Exception {
		try {
			// Pega a lista de professores cadastrados no banco de dados
			List<ProfessorModel> professores = dao.GetProfessores();

			// Pega o último professor(que foi cadastrado pelo teste)
			professorAux = professores.get(professores.size()-1);

			String nome = professorAux.getNome();

			
			assertEquals("1", "Professor Test Um", nome);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testExcluirRegistro() throws Exception {
		try {
			

			//dao.SalvarNovoRegistro(aluno2);
			
			// Pega a lista de alunos cadastrados no banco de dados
			List<ProfessorModel> professores = dao.GetProfessores();
			int valueOld = professores.size();
			
			// Pega o último aluno(que foi cadastrado pelo teste)
			professorAux = professores.get(professores.size());
			
			// Exclui do Banco de Dados o aluno inserido pelo teste
			dao.ExcluirRegistro(professorAux.getCodigo());
			
			professores = dao.GetProfessores();
			int valueNew = professores.size();

			assertEquals("1", valueOld -1 , valueNew);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void testGetPessoas() {
		List<ProfessorModel> professores = dao.GetProfessores();

		assertNotNull("T01", professores);

		int tamanho = professores.size();

		// Inserir um professor

		professores = dao.GetProfessores();

		assertEquals("T02", tamanho, professores.size());

	}

	// @Test
	public void testAlterarRegistro() {
		fail("Not yet implemented");
	}
}

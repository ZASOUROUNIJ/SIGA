package br.com.siga.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.siga.model.TurmaModel;
import br.com.siga.repository.TurmaRepository;


public class TurmaTest {
	TurmaRepository dao;
	TurmaModel turma1;
	TurmaModel turma2;
	TurmaModel turmaAux;
	
	@Before
	public void setUp() throws Exception {
		dao = new TurmaRepository();

		turma1 = new TurmaModel();
		turma1.setNome("Turma Test Um");
		turma1.setNivel("1");
		turma1.setTurno("Matutino");

		turma2 = new TurmaModel();
		turma2.setNome("Turma Test Dois");
		turma2.setNivel("2");
		turma2.setTurno("Vespertino");

		turmaAux = new TurmaModel();

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
				List<TurmaModel> turmas = dao.GetTurmas();
				int valueOld = turmas.size();

				dao.SalvarNovoRegistro(turma1);

				turmas = dao.GetTurmas();
				int valueNew = turmas.size();

				assertNotNull("1", turma1);
				assertEquals("2", valueOld + 1, valueNew);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		public void testBuscar() throws Exception {
			try {
				List<TurmaModel> turmas = dao.GetTurmas();

				turmaAux = turmas.get(turmas.size()-1);

				String nome = turmaAux.getNome();

				
				assertEquals("1", "Turma Test Um", nome);
			} catch (Exception e) {
				fail();
			}
		}

		@Test
		public void testExcluirRegistro() throws Exception {
			try {
				

				List<TurmaModel> turmas = dao.GetTurmas();
				int valueOld = turmas.size();
				
				turmaAux = turmas.get(turmas.size());
				
				dao.ExcluirRegistro(turmaAux.getId());
				
				turmas = dao.GetTurmas();
				int valueNew = turmas.size();

				assertEquals("1", valueOld -1 , valueNew);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// @Test
		public void testGetPessoas() {
			List<TurmaModel> turmas = dao.GetTurmas();

			assertNotNull("T01", turmas);

			int tamanho = turmas.size();

			// Inserir um pessoa

			turmas = dao.GetTurmas();

			assertEquals("T02", tamanho, turmas.size());

		}

		// @Test
		public void testAlterarRegistro() {
			fail("Not yet implemented");
		}
}

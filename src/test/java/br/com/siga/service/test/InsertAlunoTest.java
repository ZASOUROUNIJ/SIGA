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
import br.com.siga.repository.entity.PessoaEntity;

public class InsertAlunoTest {

	// PessoaModel pessoaEntity;

	PessoaRepository dao;
	PessoaModel aluno1;
	PessoaModel aluno2;

	@Before
	public void setUp() throws Exception {
		dao = new PessoaRepository();

		// preenchendo o usuarioEntity
		UsuarioModel usuarioEntity = new UsuarioModel();
		usuarioEntity.setCodigo("1");
		usuarioEntity.setSenha("123456");
		usuarioEntity.setUsuario("admin");

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
		aluno1.setUsuarioModel(usuarioEntity);

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
		aluno2.setUsuarioModel(usuarioEntity);
	}

	@After
	public void tearDown() throws Exception {
		try {
			// Pega a lista de alunos cadastrados no banco de dados
			List<PessoaModel> alunos = dao.GetPessoas();

			// Pega o último aluno(que foi cadastrado pelo teste)
			aluno1 = alunos.get(alunos.size() - 1);
			
			// Exclui do Banco de Dados o aluno inserido pelo teste
			dao.ExcluirRegistro(aluno1.getCodigo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSalvarNovoRegistro() throws Exception {
		List<PessoaModel> alunos = dao.GetPessoas();
		int valueOld = alunos.size();

		dao.SalvarNovoRegistro(aluno1);

		alunos = dao.GetPessoas();
		int valueNew = alunos.size();

		assertEquals("TestInsertAluno", valueOld + 1, valueNew);

	}

	//@Test
	public void testBuscar() {
		try {
			dao.SalvarNovoRegistro(aluno2);
			
			// Pega a lista de alunos cadastrados no banco de dados
			List<PessoaModel> alunos = dao.GetPessoas();

			// Pega o último aluno(que foi cadastrado pelo teste)
			aluno2 = alunos.get(alunos.size() - 1);
			
			PessoaEntity alunoBuscado = new PessoaEntity();
			alunoBuscado = dao.findPessoa(aluno2.getCodigo());

			assertNotNull("1", aluno2);
			assertNotNull("2", aluno2.getCodigo());
			assertEquals("3", "Aluno Test Dois", aluno2.getNome());

			assertEquals("4", alunoBuscado.getCodigo(), aluno2.getCodigo());
		} catch (Exception e) {
			fail();
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

	// @Test
	public void testExcluirRegistro() {
		fail("Not yet implemented");
	}

}
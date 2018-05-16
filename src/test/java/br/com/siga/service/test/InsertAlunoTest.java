package br.com.siga.service.test;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import br.com.siga.model.PessoaModel;
import br.com.siga.model.UsuarioModel;
import br.com.siga.repository.PessoaRepository;

public class InsertAlunoTest {

	@Inject
	PessoaModel pessoaEntity;

	PessoaRepository dao;

	@Test
	public void test() {

		Date data = new Date();

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

		// UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, 1);
		UsuarioModel usuarioEntity = new UsuarioModel();
		usuarioEntity.setCodigo("2");
		usuarioEntity.setSenha("123");
		usuarioEntity.setUsuario("usu");

		pessoaEntity.setUsuarioModel(usuarioEntity);

		try {
			dao.SalvarNovoRegistro(pessoaEntity);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}

		System.out.println("Fim da inserção");

	}
}
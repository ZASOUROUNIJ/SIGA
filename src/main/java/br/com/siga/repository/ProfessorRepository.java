package br.com.siga.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import br.com.siga.model.ProfessorModel;
import br.com.siga.model.UsuarioModel;
import br.com.siga.repository.entity.ProfessorEntity;
import br.com.siga.repository.entity.UsuarioEntity;
import br.com.siga.uteis.Uteis;
//import org.junit.Test;

public class ProfessorRepository {
	
		@Inject
		ProfessorEntity professorEntity;

		EntityManager entityManager;

		/***
		 * MÉTODO RESPONSÁVEL POR SALVAR UM NOVO PROFESSOR
		 * 
		 * @param professorModel
		 * @throws ParseException
		 */
		public void SalvarNovoRegistro(ProfessorModel professorModel) throws ParseException {

			entityManager = Uteis.JpaEntityManager();
			entityManager.getTransaction().begin();

			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date dataFormatada = formato.parse(professorModel.getData());

			professorEntity = new ProfessorEntity();
			professorEntity.setCodigo(professorModel.getCodigo());
			professorEntity.setNome(professorModel.getNome());
			professorEntity.setData(dataFormatada);
			professorEntity.setTelefone(professorModel.getTelefone());
			professorEntity.setEndereco(professorModel.getEndereco());
			professorEntity.setDataCad(LocalDateTime.now());

			UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class,
					professorModel.getUsuarioModel().getCodigo());
			professorEntity.setUsuarioEntity(usuarioEntity);

			entityManager.persist(professorEntity);
			entityManager.flush();
			entityManager.getTransaction().commit();
			entityManager.close();
		}

		public ProfessorEntity findProfessor(Integer id) {
			return entityManager.find(ProfessorEntity.class, id);
		}

		/***
		 * MÉTODO PARA CONSULTAR A PESSOA
		 * 
		 * @return
		 */
		public List<ProfessorModel> GetProfessores() {

			List<ProfessorModel> professoresModel = new ArrayList<ProfessorModel>();

			entityManager = Uteis.JpaEntityManager();

			Query query = entityManager.createNamedQuery("ProfessorEntity.findAll");

			@SuppressWarnings("unchecked")
			Collection<ProfessorEntity> professoresEntity = (Collection<ProfessorEntity>) query.getResultList();

			ProfessorModel professorModel = null;

			for (ProfessorEntity professorEntity : professoresEntity) {

				SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
				String dataFormatada = formatador.format(professorEntity.getData());

				professorModel = new ProfessorModel();
				professorModel.setCodigo(professorEntity.getCodigo());
				professorModel.setNome(professorEntity.getNome());
				professorModel.setData(dataFormatada);
				professorModel.setTelefone(professorEntity.getTelefone());
				professorModel.setEndereco(professorEntity.getEndereco());
				professorModel.setDataCad(professorEntity.getDataCad());

				UsuarioEntity usuarioEntity = professorEntity.getUsuarioEntity();

				UsuarioModel usuarioModel = new UsuarioModel();
				usuarioModel.setUsuario(usuarioEntity.getUsuario());

				professorModel.setUsuarioModel(usuarioModel);

				professoresModel.add(professorModel);
			}

			return professoresModel;

		}

		/***
		 * CONSULTA UM PROFESSOR CADASTRADO PELO CÓDIGO
		 * 
		 * @param codigo
		 * @return
		 */
		private ProfessorEntity GetProfessor(int codigo) {

			entityManager = Uteis.JpaEntityManager();

			return entityManager.find(ProfessorEntity.class, codigo);
		}

		/***
		 * ALTERA UM REGISTRO CADASTRADO NO BANCO DE DADOS
		 * 
		 * @param professorModel
		 * @throws ParseException
		 */
		public void AlterarRegistro(ProfessorModel professorModel) throws ParseException {
			EntityManager entityManager = null;
			try {
				entityManager = Uteis.JpaEntityManager();
				entityManager.getTransaction().begin();

				SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
				Date dataFormatada2 = formato2.parse(professorModel.getData());

				professorEntity = this.GetProfessor(professorModel.getCodigo());
				professorEntity.setNome(professorModel.getNome());
				professorEntity.setData(dataFormatada2);
				professorEntity.setEndereco(professorModel.getEndereco());
				professorEntity.setTelefone(professorModel.getTelefone());

				professorEntity = entityManager.merge(professorEntity);
				entityManager.getTransaction().commit();
			} catch (Exception ex) {
				String msg = ex.getLocalizedMessage();
				if (msg == null || msg.length() == 0) {
					Integer id = professorModel.getCodigo();
					if (findProfessor(id) == null) {
						System.out.println("Professor não encontrado");
					}
				}
				throw ex;
			} finally {
				if (entityManager != null) {
					entityManager.close();
				}
			}
		}

		/***
		 * EXCLUI UM REGISTRO DO BANCO DE DADOS
		 * 
		 * @param codigo
		 */
		public void ExcluirRegistro(int codigo) {
			try {
				entityManager = Uteis.JpaEntityManager();
				entityManager.getTransaction().begin();
				ProfessorEntity professor = new ProfessorEntity();
				try {
					professor = entityManager.getReference(ProfessorEntity.class, codigo);
					professor.getCodigo();
				} catch (EntityNotFoundException enfe) {
					// throw new NonexistentEntityException("The avaliacao with id " + id + " no
					// longer exists.", enfe);
				}
				entityManager.remove(professor);
				entityManager.getTransaction().commit();
			} finally {
				if (entityManager != null) {
					entityManager.close();
				}
			}
		}
	}

package br.com.siga.repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import br.com.siga.model.TurmaModel;
import br.com.siga.repository.entity.TurmaEntity;
import br.com.siga.uteis.Uteis;

public class TurmaRepository {

	@Inject 
	TurmaEntity turmaEntity;
	
	EntityManager entityManager;
	
	public void SalvarNovoRegistro(TurmaModel turmaModel) {
		entityManager = Uteis.JpaEntityManager();
		entityManager.getTransaction().begin();
		
		turmaEntity = new TurmaEntity();
		turmaEntity.setId(turmaModel.getId());
		turmaEntity.setNivel(turmaModel.getNivel());
		turmaEntity.setNome(turmaModel.getNome());
		turmaEntity.setTurno(turmaModel.getTurno());
		turmaEntity.setProfessor(turmaModel.getProfessor());
		
		
		entityManager.persist(turmaEntity);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public TurmaEntity findTurma(Integer id) {
		return entityManager.find(TurmaEntity.class, id);
	}
	
	public List<TurmaModel> GetTurmas() {

		List<TurmaModel> turmasModel = new ArrayList<TurmaModel>();

		entityManager = Uteis.JpaEntityManager();

		Query query = entityManager.createNamedQuery("TurmaEntity.findAll");

		@SuppressWarnings("unchecked")
		Collection<TurmaEntity> turmasEntity = (Collection<TurmaEntity>) query.getResultList();

		TurmaModel turmaModel = null;

		for (TurmaEntity turmaEntity : turmasEntity) {

			turmaModel = new TurmaModel();
			turmaModel.setId((turmaEntity.getId()));
			turmaModel.setNivel((turmaEntity.getNivel()));
			turmaModel.setNome((turmaEntity.getNome()));
			turmaModel.setTurno((turmaEntity.getTurno()));
			turmaModel.setProfessor((turmaEntity.getProfessor()));


			turmasModel.add(turmaModel);
		}

		return turmasModel;

	}
	
	private TurmaEntity GetTurma(int id) {

		entityManager = Uteis.JpaEntityManager();

		return entityManager.find(TurmaEntity.class, id);
	}
	
	public void AlterarRegistro(TurmaModel turmaModel) throws ParseException {
		EntityManager entityManager = null;
		try {
			entityManager = Uteis.JpaEntityManager();
			entityManager.getTransaction().begin();

			turmaEntity = this.GetTurma(turmaModel.getId());
			turmaEntity.setNivel((turmaModel.getNivel()));
			turmaEntity.setNome(turmaModel.getNome());
			turmaEntity.setTurno(turmaModel.getTurno());
			turmaEntity.setProfessor(turmaModel.getProfessor());

			turmaEntity = entityManager.merge(turmaEntity);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = turmaModel.getId();
				if (findTurma(id) == null) {
					System.out.println("Turma não encontrada");
				}
			}
			throw ex;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
	
	public void ExcluirRegistro(int id) {
		try {
			entityManager = Uteis.JpaEntityManager();
			entityManager.getTransaction().begin();
			TurmaEntity turma = new TurmaEntity();
			try {
				turma = entityManager.getReference(TurmaEntity.class, id);
				turma.getId();
			} catch (EntityNotFoundException enfe) {
				// throw new NonexistentEntityException("The avaliacao with id " + id + " no
				// longer exists.", enfe);
			}
			entityManager.remove(turma);
			entityManager.getTransaction().commit();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
}

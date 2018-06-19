package br.com.siga.repository;

import java.io.Serializable;
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
import br.com.siga.repository.entity.PessoaEntity;
import br.com.siga.repository.entity.ProfessorEntity;
import br.com.siga.repository.entity.UsuarioEntity;
import br.com.siga.uteis.Uteis;
 
import org.junit.Test;
 
public class UsuarioRepository implements Serializable {
	
	@Inject
	UsuarioEntity usuarioEntity;
	
	UsuarioModel usuarioModel;

	EntityManager entityManager;
 
 
	private static final long serialVersionUID = 1L;
 
	public UsuarioEntity ValidaUsuario(UsuarioModel usuarioModel){
 
		try {
 
			//QUERY QUE VAI SER EXECUTADA (UsuarioEntity.findUser) 	
			Query query = Uteis.JpaEntityManager().createNamedQuery("UsuarioEntity.findUser");
 
			//PARÂMETROS DA QUERY
			query.setParameter("usuario", usuarioModel.getUsuario());
			query.setParameter("senha", usuarioModel.getSenha());
 
			//RETORNA O USUÁRIO SE FOR LOCALIZADO
			return (UsuarioEntity)query.getSingleResult();
 
		} catch (Exception e) {
 
			return null;
		}
 
 
 
	}
	public void SalvarNovoRegistro(UsuarioModel usuarioModel) throws ParseException {

		entityManager = Uteis.JpaEntityManager();
		entityManager.getTransaction().begin();


		usuarioEntity = new UsuarioEntity();
		usuarioEntity.setCodigo(usuarioModel.getCodigo());
		usuarioEntity.setUsuario(usuarioModel.getUsuario());
		usuarioEntity.setSenha(usuarioModel.getSenha());

		//UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class,
		//		usuarioModel.getUsuarioModel().getCodigo());
		//usuarioEntity.setUsuarioEntity(usuarioEntity);

		entityManager.persist(usuarioEntity);
		entityManager.flush();
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public UsuarioEntity findUsuario(Integer id) {
		return entityManager.find(UsuarioEntity.class, id);
	}
	public List<UsuarioModel> GetUsuarios() {

		List<UsuarioModel> usuariosModel = new ArrayList<UsuarioModel>();

		entityManager = Uteis.JpaEntityManager();

		Query query = entityManager.createNamedQuery("UsuarioEntity.findAll");

		@SuppressWarnings("unchecked")
		Collection<UsuarioEntity> usuariosEntity = (Collection<UsuarioEntity>) query.getResultList();

		UsuarioModel usuarioModel = null;

		for (UsuarioEntity usuarioEntity : usuariosEntity) {


			usuarioModel = new UsuarioModel();
			usuarioModel.setCodigo(usuarioEntity.getCodigo());
			usuarioModel.setUsuario(usuarioEntity.getUsuario());

			usuarioModel.setSenha(usuarioEntity.getSenha());





			usuariosModel.add(usuarioModel);
		}

		return usuariosModel;

	}
	
	private UsuarioEntity GetUsuario(int codigo) {

		entityManager = Uteis.JpaEntityManager();

		return entityManager.find(UsuarioEntity.class, codigo);
	}
	
	public void AlterarRegistro(UsuarioModel usuarioModel) throws ParseException {
		EntityManager entityManager = null;
		try {
			entityManager = Uteis.JpaEntityManager();
			entityManager.getTransaction().begin();

			usuarioEntity = this.GetUsuario(usuarioModel.getCodigo());
			usuarioEntity.setUsuario(usuarioModel.getUsuario());
			usuarioEntity.setSenha(usuarioModel.getSenha());

			usuarioEntity = entityManager.merge(usuarioEntity);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = usuarioModel.getCodigo();
				if (findUsuario(id) == null) {
					System.out.println("Usuário não encontrado");
				}
			}
			throw ex;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
	
	public void ExcluirRegistro(int codigo) {
		try {
			entityManager = Uteis.JpaEntityManager();
			entityManager.getTransaction().begin();
			UsuarioEntity usuario = new UsuarioEntity();
			try {
				usuario = entityManager.getReference(UsuarioEntity.class, codigo);
				usuario.getCodigo();
			} catch (EntityNotFoundException enfe) {
				// throw new NonexistentEntityException("The avaliacao with id " + id + " no
				// longer exists.", enfe);
			}
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
}
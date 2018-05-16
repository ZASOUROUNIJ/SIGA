package br.com.siga.uteis;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
 
public class Uteis {
 
	public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("unit_app");
	
	public static EntityManager JpaEntityManagerOld(){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		ExternalContext externalContext = facesContext.getExternalContext();
 
		HttpServletRequest request  = (HttpServletRequest)externalContext.getRequest();
 
		return (EntityManager)request.getAttribute("entityManager");
	}
	
	public static EntityManager JpaEntityManager(){
 
		return EMF.createEntityManager();
	}
	
	
 
	//MOSTRAR MENSAGEM
	public static void Mensagem(String mensagem){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		facesContext.addMessage(null, new FacesMessage("Alerta",mensagem));
	}
 
	//MOSTRAR MENSAGEM
	public static void MensagemAtencao(String mensagem){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atencao:", mensagem));
	}
 
	//MOSTRAR MENSAGEM
	public static void MensagemInfo(String mensagem){
 
		FacesContext facesContext = FacesContext.getCurrentInstance();
 
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
	}
 
}
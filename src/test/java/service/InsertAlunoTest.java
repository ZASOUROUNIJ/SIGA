package service;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.siga.model.PessoaModel;
import br.com.siga.repository.entity.*;
import br.com.siga.usuario.controller.UsuarioController;
import br.com.siga.uteis.Uteis;
import br.com.siga.pessoa.controller.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class InsertAlunoTest {
    
    
   
    @Test
    public void test() {
        
        fail("Not yet implemented :|" );
    }
        /*
        Date data =new Date();
        
        EntityManager entityManager;
       
        PessoaEntity pessoaEntity;
        entityManager =  Uteis.JpaEntityManager();
        

            System.out.println("Inserindo Aluno");
            
            pessoaEntity = new PessoaEntity();
            pessoaEntity.setCodigo(32);
            pessoaEntity.setNome("Antonio Carlos Florentino De Souza Junior");
            pessoaEntity.setSexo("M");
            pessoaEntity.setData(data);
            pessoaEntity.setIdade(22);
            pessoaEntity.setPai("Antonio Carlos Florentino De Souza");
            pessoaEntity.setMae("Maria Assunção Pereira");
            pessoaEntity.setTelefone("(84)996869885");
            pessoaEntity.setEndereco("Rua: Major Ajax");
            pessoaEntity.setDataCad(LocalDateTime.now());
            
            entityManager.persist(pessoaEntity);
            
            System.out.println("Fim da inserção");
  
        }
        
      */
    }

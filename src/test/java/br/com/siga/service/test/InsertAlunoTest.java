package br.com.siga.service.test;

import static org.junit.Assert.*;

import org.junit.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;



import br.com.siga.repository.entity.*;

import br.com.siga.uteis.Uteis;

import java.time.LocalDateTime;
import java.util.Date;





public class InsertAlunoTest {
    
    
    @Inject
    PessoaEntity pessoaEntity;
    
    EntityManager entityManager;
  
    @Test
    public void test() {

        fail("Not yet implemented");
    }
}
        
        /*
        Date data =new Date();
        
       
        
        entityManager =  Uteis.JpaEntityManager();
        if (entityManager == null) {
            System.out.println("NULOOOOOOOO");
        }

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
            
            //UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, 1);
            UsuarioEntity usuarioEntity = new UsuarioEntity();
            usuarioEntity.setCodigo("2");
            usuarioEntity.setSenha("123");
            usuarioEntity.setUsuario("usu");
            
            pessoaEntity.setUsuarioEntity(usuarioEntity);
            entityManager.persist(pessoaEntity);
            
            System.out.println("Fim da inserção");
             
        }
         
      
    }
*/
package br.com.siga.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 
 
@Entity
@Table(name="tb_turma_aluno")
@NamedQueries({
     
    @NamedQuery(name = "TurmaAlunoEntity.findAll",query= "SELECT p FROM TurmaAlunoEntity p")
 
})
public class TurmaAlunoEntity {

    @Id
    @Column(name = "id")
    private Integer id_turma;
    
    @Column(name = "matricula")
    private Integer matricula;
 
    @Column(name = "ano")
    private Integer  ano;

    public Integer getId_turma() {
        return id_turma;
    }

    public void setId_turma(Integer id_turma) {
        this.id_turma = id_turma;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
 
}

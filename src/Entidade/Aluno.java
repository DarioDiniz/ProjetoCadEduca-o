
package Entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity 
public class Aluno {
    @Id
    @GeneratedValue
    @Column(unique=true)
    private int id;
    @Column (nullable = false)
    private String nome;
    
    @Column(nullable=false,unique=true)
    private int matricula;
    
   
   @Column(nullable=false)
    private String nomeCurso;

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    
    
    
    
    @Column (nullable = false,unique=true)
    private String cpf;
    
    @Column (nullable = false,unique=true)
    private String email;
     
    @Column (nullable = false,unique=true)
    private String celular;
    
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
}

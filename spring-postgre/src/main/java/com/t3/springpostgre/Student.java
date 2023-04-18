package com.t3.springpostgre;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Classe = Tabela    Objeto = Linha 
public class Student {
    
    @Id //Indica a propriedade que sera a CHAVE PRIMARIA da tabela
    @GeneratedValue(strategy = GenerationType.AUTO) // Diz para gerar o valor dessa propriedade automaticamente
    private long ra;
    
    private String firstName;
    private String lastName;
    private String course;

    //Necessario para o JPA trabalhar com o banco
    public Student() {
    }

    //Ignora o ra pois ele é gerado automaticamente
    public Student(String firstName, String lastName, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student [ra=" + ra + ", firstName=" + firstName + ", lastName=" + lastName + ", course=" + course + "]";
    }

    public long getRa() {
        return ra;
    }

    public void setRa(long ra) {
        this.ra = ra;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    

    
    
}

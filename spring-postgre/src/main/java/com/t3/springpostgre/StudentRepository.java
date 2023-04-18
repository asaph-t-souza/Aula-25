package com.t3.springpostgre;

import org.springframework.data.jpa.repository.JpaRepository;

//CrudRepository<Objeto, Tipo da propriedade setada como id>
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}

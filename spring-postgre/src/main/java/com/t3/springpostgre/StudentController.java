package com.t3.springpostgre;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller// indica que a classe é um controller
public class StudentController {
    
    //Inicializamos o JPA com o nosso banco de dados
    private StudentRepository repository;

    //Inicializamos o nosso repositorio no construtor da classe
    public StudentController(StudentRepository repository){
        this.repository = repository;
    }

    //mapeamos a URL "/" para o template index.html
    @GetMapping("/")
    public String index() {
        return "index";
    }

    //mapeamos a URL "/students/add" para o template addEdit.html
    @GetMapping("/students/add")
    public String createStudent(Model model){
        model.addAttribute("title2", "Adding a new Student");
        model.addAttribute("student", new Student());
        return "addEdit";
    }

    //mapeamos a URL com metodo POST "/students/save" para salvar o Objeto no banco, e redirecionamos para a URL students
    @PostMapping("/students/save")
    public String saveStudent(Student student){
        repository.save(student);
        return "redirect:/students";
    }

    //mapeamos a URL "/students" para o template studentList.html
    @GetMapping("/students")
    public String getAllStudents(Model model){
        model.addAttribute("students", repository.findAll(Sort.by("course")));
        return "studentList";
    }

    //mapeamos a URL "/students/edit/{ra}" onde se captura o valor de {ra} atraves da anotação @PathVariable
    @GetMapping("/students/edit/{ra}")
    public String editStudent(Model model, @PathVariable(value="ra") long ra){
        model.addAttribute("title2", "Editing a student");
        //findById procura um objeto pela sua chave primaria
        model.addAttribute("student", repository.findById(ra));
        return "addEdit";
    }

    //mapeamos a URL "/students/delete/{ra}" onde se captura o valor de {ra} atraves da anotação @PathVariable
    @GetMapping("/students/delete/{ra}")
    public String deleteStudent(@PathVariable(value="ra") long ra){
        repository.deleteById(ra);
        return "redirect:/students";
    }

    //passa um valor para todos os models que tenha o atributo descrito
    @ModelAttribute("periodOptions")
    public List<Period> selectOptionsPeriod(){
        return Arrays.asList(Period.values());
    }
       
}

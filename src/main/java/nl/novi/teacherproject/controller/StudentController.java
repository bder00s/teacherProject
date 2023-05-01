package nl.novi.teacherproject.controller;

import nl.novi.teacherproject.model.Student;
import nl.novi.teacherproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@RestController

public class StudentController {

    public ArrayList<Student> students = new ArrayList<>();

    @Autowired
    private StudentRepository repostudent;


    //// GET MAPPING ////////////////////////////////

    @GetMapping("/allstudents")
    public ResponseEntity<Iterable<Student>> getStudents() {
        return ResponseEntity.ok(repostudent.findAll());
    }

    @GetMapping("/findstudent")
    public ResponseEntity<ArrayList<Student>> getStudent(@RequestParam String fullName) {
        return ResponseEntity.ok(repostudent.findAllByFullName(fullName));
    }


    ////  POST MAPPING ////////////////////////////

    @PostMapping("/addstudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student stud) {

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + stud.getStudentNr()).toUriString());

        repostudent.save(stud);
        return ResponseEntity.created(uri).body(stud);

    }


}

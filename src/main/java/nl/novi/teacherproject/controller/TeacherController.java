package nl.novi.teacherproject.controller;

import nl.novi.teacherproject.model.Teacher;
import nl.novi.teacherproject.repository.TeacherRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController

public class TeacherController {

    public ArrayList<Teacher> teachers = new ArrayList<>();

    @Autowired
    private TeacherRepository repos;


    ////GET MAPPING/////////////////////////////////////////////
    @GetMapping("/allteachers")
    public ResponseEntity<Iterable<Teacher>> getTeachers() {
        return ResponseEntity.ok(repos.findAll());
    }

    @GetMapping("/findteacher")
    public ResponseEntity<ArrayList<Teacher>> getTeacher(@RequestParam String firstName, String lastName) {
        return ResponseEntity.ok(repos.findByFirstNameAndLastName(firstName, lastName));
    }

    ///////////// POST MAPPING /////////////////////////////////////////


    @PostMapping("/addteacher")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teach) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + teach.getId()).toUriString());

        repos.save(teach);
        return ResponseEntity.created(uri).body(teach);
    }


}

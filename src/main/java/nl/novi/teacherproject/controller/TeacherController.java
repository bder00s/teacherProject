package nl.novi.teacherproject.controller;

import nl.novi.teacherproject.model.Teacher;
import nl.novi.teacherproject.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController

public class TeacherController {

    public ArrayList<Teacher> teachers = new ArrayList<>();

    @Autowired private TeacherRepository repos;

    @GetMapping("/teachers")
    public ResponseEntity<ArrayList<Teacher>> getTeachers() {
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @PostMapping("/addteachers")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teach) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + teach.getId()). toUriString());

        repos.save(teach);
        return ResponseEntity.created(uri).body(teach);
    }
}

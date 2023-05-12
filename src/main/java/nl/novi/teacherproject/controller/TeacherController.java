package nl.novi.teacherproject.controller;

import jakarta.validation.Valid;
import nl.novi.teacherproject.DTO.TeacherDto;
import nl.novi.teacherproject.model.Teacher;
import nl.novi.teacherproject.repository.TeacherRepository;
import nl.novi.teacherproject.service.TeacherService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController

public class TeacherController {
    private final TeacherService service;


    // constructor injection ////
    public TeacherController(TeacherService service) {
        this.service = service;
    }


    ////GET MAPPING//////
//    @GetMapping("/allteachers")
//    public ResponseEntity<Iterable<Teacher>> getTeachers() {
//
//        return ResponseEntity.ok(repos.findAll());
//    }

//    @GetMapping("/findteacher")
//    public ResponseEntity<ArrayList<Teacher>> getTeacher(@RequestParam String firstName, String lastName) {
//        return ResponseEntity.ok(repos.findByFirstNameAndLastName(firstName, lastName));
//    }


/// GET MAPPING /////////////
    @GetMapping("/getteacher")
public ResponseEntity<Object> getTeacher(TeacherDto teacherDto, @RequestParam TeacherDto id, TeacherDto firstName, TeacherDto lastName){
return ResponseEntity.ok(service.getTeacher(teacherDto.id));
    }




    ///////////// POST MAPPING ///////
    @PostMapping("/addteacher")

    //TeacherDTO komt binnen
    public ResponseEntity<Object> addTeacher(@Valid @RequestBody TeacherDto teacherDto, BindingResult bindingResult) {
        //bindingResult test het resultaat en mogelijke errors
        if (bindingResult.hasFieldErrors()) {
            //Stringbuilder aangemaakt die de message gaat samenvoegen
            StringBuilder stringbuilder = new StringBuilder();
            // Wanneer er een fieldError is, wordt deze in een message aan de gebruiker teruggegeven
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                stringbuilder.append(fieldError.getField() + ": ");
                stringbuilder.append(fieldError.getDefaultMessage());
                stringbuilder.append("\n");
            }
            return ResponseEntity.badRequest().body(stringbuilder.toString());
        } else {
            // als er geen fieldErrors zijn, gaan we door naar deze return
            // Er komt een link naar de servicelaag
            Long newId = service.createTeacher(teacherDto);

            //Vangt Id op en gebruikt de Id om de response header te vullen
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newId).toUriString());

            // Geeft een response van de nieuwe ID aan de client
            return ResponseEntity.created(uri).body(newId);
        }
    }


}

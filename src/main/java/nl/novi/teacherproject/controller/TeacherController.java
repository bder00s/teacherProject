package nl.novi.teacherproject.controller;

import jakarta.validation.Valid;
import nl.novi.teacherproject.DTO.TeacherDto;
import nl.novi.teacherproject.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

//@RestController

//public class TeacherController {
//    private final TeacherService teacherService;
//
//
//    // SERVICE CONSTRUCTOR INJECTION//////
//    public TeacherController(TeacherService teacherService) {
//        this.teacherService = teacherService;
//    }
//
//    @GetMapping("/allteachers")
//// Return die naar front-end gaat -> omzetten in JSON
//    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
//        return ResponseEntity.ok().body(teacherService.getAllTeachers());
//    }
//
//
//@GetMapping("/getTeacher/{id}")
//public ResponseEntity<TeacherDto> getTeacher(@PathVariable Long id){
//        return ResponseEntity.ok(teacherService.getTeacher(id));
//}

//@GetMapping("/findByName/{name}")
//public ResponseEntity<TeacherDto> findTeacher(@RequestBody TeacherDto teacherDto){
//        return ResponseEntity.ok().body(teacherService.)
//
//}


    /// POST MAPPING ///////
//    @PostMapping("/addteacher")
//
//    //TeacherDTO komt binnen
//    public ResponseEntity<Object> addTeacher(@Valid @RequestBody TeacherDto teacherDto, BindingResult bindingResult) {
//        //bindingResult test het resultaat en mogelijke errors
//        if (bindingResult.hasFieldErrors()) {
//            //Stringbuilder aangemaakt die de message gaat samenvoegen
//            StringBuilder stringbuilder = new StringBuilder();
//            // Wanneer er een fieldError is, wordt deze in een message aan de gebruiker teruggegeven
//            for (FieldError fieldError : bindingResult.getFieldErrors()) {
//                stringbuilder.append(fieldError.getField() + ": ");
//                stringbuilder.append(fieldError.getDefaultMessage());
//                stringbuilder.append("\n");
//            }
//            return ResponseEntity.badRequest().body(stringbuilder.toString());
//        } else {
//            // als er geen fieldErrors zijn, gaan we door naar deze return
//            // Er komt een link naar de servicelaag
//            String teacherinfo = teacherService.createTeacher(teacherDto);
//
//            //Vangt velden op en gebruikt die om de response header te vullen
//            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + teacherinfo).toUriString());
//
//            // Geeft een response van de nieuwe ID aan de client
//            return ResponseEntity.created(uri).body(teacherinfo);
//        }
//    }


//}

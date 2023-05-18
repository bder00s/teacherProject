package nl.novi.teacherproject.service;

import nl.novi.teacherproject.DTO.TeacherDto;
import nl.novi.teacherproject.exception.RecordNotFoundException;
import nl.novi.teacherproject.model.Teacher;
import nl.novi.teacherproject.repository.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;


    // constructor injection
    public TeacherService(TeacherRepository teacherRepository) {

        this.teacherRepository = teacherRepository;
    }


    // POST METHODE ////
    public String createTeacher(TeacherDto teacherDto) {
        //2. teacher object wordt aangemaakt;
        Teacher teacher = new Teacher();
        //3. de velden worden allemaal uit het DTO object gehaald;
        teacher.setId(teacherDto.id);
        teacher.setFirstName(teacherDto.firstName);
        teacher.setLastName(teacherDto.lastName);
        //4. het object teacher met de gevulde velden wordt opgeslagen in de database;
        teacherRepository.save(teacher);

        //5. de Id van de net aangemaakte teacher wordt teruggegeven
        String teacherinfo = teacher.getId() + ", " + teacher.getFirstName() + ", " + teacher.getLastName();
        return teacherinfo;

    }

    // GET METHODE ///
    public List<TeacherDto> getAllTeachers() {
        //Lijst van teachers
        List<Teacher> allteachers = teacherRepository.findAll();
        //Lijst van teacher dto's
        List<TeacherDto> teacherDtoList = new ArrayList<>();

        // Forloop om alle waardes in de nieuwe dto te loopen - vanuit de lijst van allteachers (Teachers)
        for (Teacher teacher : allteachers) {
            // De waardes uit de Dto's worden toegevoegd aan de televisionDtosLijst
            teacherDtoList.add(transferTeacherToDto(teacher));
        }
        return teacherDtoList;
    }

    // GET 1 TEACHER ///
//    List<TeacherDto> getTeacher(@RequestParam String firstName, String lastName) {
//        //Lijst van teachers
//            List<Teacher> listofteachers = teacherRepository.findAll();
//        //Lijst van teacher dto's
//            List <TeacherDto> teacherDtoList = new ArrayList<>();
//            for (Teacher teacher : listofteachers) {
//                teacherDtoList.add(transferTeacherToDto(teacher));
//            }
//            return teacherRepository.findByFirstNameAndLastName(transferTeacherToDto(teacher.getFirstName());
//
//    }


//    Teacher teacher = teacherRepository.findByFirstNameAndLastName(transferTeacherToDto(teacher).firstName).orElseThrow(() -> new
//            RecordNotFoundException("Teacher not found"));
//// lambda expressie - code zonder method -> anonieme methods (net als anonieme functies in javascript)


    // METHODE VOOR HET OMZETTEN VAN DTO VELDEN ///
    public TeacherDto transferTeacherToDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();
        // de nieuwe dto vullen met de waardes uit Television
        teacherDto.id = teacher.getId();
        teacherDto.firstName = teacher.getFirstName();
        teacherDto.lastName = teacher.getLastName();
        return teacherDto;
    }
}

// VAN ENTITY TERUG NAAR DTO -> GET, PUT, EVENTUEEL POST // OUTPUT DTO -> NAAR CLIENT
// VAN DTO NAAR ENTITY -> POST, PUT // INPUT DTO -> NAAR DATABASE

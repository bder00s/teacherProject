package nl.novi.teacherproject.service;

import nl.novi.teacherproject.DTO.TeacherDto;
import nl.novi.teacherproject.exception.RecordNotFoundException;
import nl.novi.teacherproject.model.Teacher;
import nl.novi.teacherproject.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository repos;
// constructor injection
    public TeacherService(TeacherRepository repos) {
        this.repos = repos;
    }

    public TeacherDto getTeacher(Long id){
       Teacher teacher = repos.findById(id).orElseThrow(() -> new
               RecordNotFoundException("Teacher not found"));
       //lambda expressie - code zonder method -> anonieme methods (net als anonieme functies in javascript)
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.id = teacher.getId();
        teacherDto.firstName = teacher.getFirstName();
        teacherDto.lastName = teacher.getLastName();
        // hierboven haal je alle velden op uit de DTO
        return teacherDto;
    }






    //1. POST MAPPING - TEACHER OPHALEN
    // DTO wordt opgeroepen

    public Long createTeacher(TeacherDto teacherDto) {
        //2. teacher object wordt aangemaakt;
        Teacher teacher = new Teacher();
        //3. de velden worden allemaal uit het DTO object gehaald;
        teacher.setFirstName(teacherDto.firstName);
        teacher.setLastName(teacherDto.lastName);
        //4. het object teacher met de gevulde velden wordt opgeslagen in de database;
        repos.save(teacher);

        //5. de Id van de net aangemaakte teacher wordt teruggegeven
        return teacher.getId();

    }





}

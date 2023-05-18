package nl.novi.teacherproject.controller;


import nl.novi.teacherproject.DTO.CourseDto;
import nl.novi.teacherproject.model.Course;
import nl.novi.teacherproject.model.Teacher;
import nl.novi.teacherproject.repository.CourseRepository;
import nl.novi.teacherproject.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepos;
    private final TeacherRepository teacherRepos;


    //constructor injection
    public CourseController(CourseRepository courseRepos, TeacherRepository teacherRepos) {
    this.courseRepos = courseRepos;
    this.teacherRepos = teacherRepos;
}

//post mapping
    @PostMapping
    public ResponseEntity<Long> createCourse(@RequestBody CourseDto courseDto){
        // course object maken
        Course course = new Course();

        // info out de courseDto halen
        course.setTitle(courseDto.title);
        course.setStudypoints(courseDto.studypoints);
        // teacherId (uit Course) koppelen aan Teacher
        Teacher teacher = teacherRepos.findById(courseDto.teacherId).get();
        course.setTeacher(teacher);

        // info in de database opslaan
        courseRepos.save(course);

        // de net aangemaakte course tonen aan de gebruiker
        return new ResponseEntity<>(course.getId(), HttpStatus.CREATED);

    }

    //get mapping - alle courses vinden
    @GetMapping
    public ResponseEntity<Iterable<Course>> getAllCourses(){
        return new ResponseEntity<>(courseRepos.findAll(), HttpStatus.OK);
    }


}

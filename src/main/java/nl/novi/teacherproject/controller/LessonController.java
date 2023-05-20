package nl.novi.teacherproject.controller;


import nl.novi.teacherproject.DTO.LessonDto;
import nl.novi.teacherproject.exception.RecordNotFoundException;
import nl.novi.teacherproject.model.Course;
import nl.novi.teacherproject.model.Lesson;
import nl.novi.teacherproject.repository.CourseRepository;
import nl.novi.teacherproject.repository.LessonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    // constructor injection
    public LessonController(LessonRepository lessonRepository, CourseRepository courseRepository) {
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;
    }

    // post mapping
    @PostMapping
    public ResponseEntity<String> createLesson(@RequestBody LessonDto lessonDto) {

        // lesson object maken
        Lesson lesson = new Lesson();

        // info uit de lessonDto halen
        lesson.setLessonId(lessonDto.lessonId);
        lesson.setTopic(lessonDto.topic);
        Course course = courseRepository.findById(lessonDto.courseId).get();
        lesson.setCourse(course);

        //info in de database opslaan
        lessonRepository.save(lesson);

        // de net aangemaakte lesson tonen aan de gebruiker
        return new ResponseEntity<>(lesson.getTopic() + ", id: " + lesson.getLessonId(), HttpStatus.CREATED);
    }

    // get mapping - alle lessons vinden

    @GetMapping
    public ResponseEntity<Iterable<Lesson>> getAllLessons(){
        return new ResponseEntity<>(lessonRepository.findAll(), HttpStatus.FOUND);
    }

    //get mapping - één lesson vinden
//    @GetMapping("/onelesson")
//    public LessonDto getLesson(@RequestParam Long id){
//        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Lesson not found"));
//        LessonDto lessonDto = new LessonDto();
//        lessonDto.lessonId = lesson.getLessonId();
//    }

}

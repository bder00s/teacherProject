package nl.novi.teacherproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonId;

    private String topic;

    @ManyToOne
    @JsonIgnore
   private Course course;


    ///////////////////////////////////////

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long id) {
        this.lessonId = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

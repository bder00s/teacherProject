package nl.novi.teacherproject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int studypoints;


    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    List<Lesson> lessonList;


    ////////////////////////////////////////
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStudypoints() {
        return studypoints;
    }

    public void setStudypoints(int studypoints) {
        this.studypoints = studypoints;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher(){
        return teacher;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }
}

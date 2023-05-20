package nl.novi.teacherproject.DTO;

import java.util.ArrayList;
import java.util.List;

public class CourseDto {

    public Long id;
    public  String title;
    public int studypoints;

    // koppeling met teacher
    public Long teacherId;

    public List<String> lessonTitles = new ArrayList<>();



}

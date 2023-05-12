package nl.novi.teacherproject.service;


import nl.novi.teacherproject.model.Student;
import nl.novi.teacherproject.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    private StudentRepository repostudent;

    public ArrayList<Student> getStudents(String name) {
        return repostudent.findAllByFullName(name);
    }


}

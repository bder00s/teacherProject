package nl.novi.teacherproject.repository;

import nl.novi.teacherproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface StudentRepository extends JpaRepository <Student, Long> {

    ArrayList<Student> findAllByFullName(String fullName);


}

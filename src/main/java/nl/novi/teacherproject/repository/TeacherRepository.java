package nl.novi.teacherproject.repository;

import nl.novi.teacherproject.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    ArrayList<Teacher> findByFirstNameAndLastName(String firstName, String lastName);
 Teacher findByFirstName(String firstName);

}

package nl.novi.teacherproject.repository;

import nl.novi.teacherproject.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}

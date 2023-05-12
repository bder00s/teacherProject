package nl.novi.teacherproject.model;
import lombok.Setter;
import lombok.Getter;
import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
@Getter
@Setter

public class Teacher {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;


}
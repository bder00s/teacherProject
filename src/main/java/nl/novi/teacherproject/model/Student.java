package nl.novi.teacherproject.model;
import lombok.Setter;
import lombok.Getter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "students")

public class Student {

    @Id
    @GeneratedValue
    private Long studentNr;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;


}



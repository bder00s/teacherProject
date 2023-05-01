package nl.novi.teacherproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")

public class Teacher {
    @Id
    @GeneratedValue
    private Long id;
   @Column (name = "first_name")
    private String firstName;
   @Column(name = "last_name")
    private String lastName;



    /// GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

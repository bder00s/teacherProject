package nl.novi.teacherproject.DTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TeacherDto {

    public Long id;
@NotBlank
    public String firstName;
@NotBlank
@Size(min = 2, message = "lengte moet tussen de 2 en de 100 liggen")
    public String lastName;

}

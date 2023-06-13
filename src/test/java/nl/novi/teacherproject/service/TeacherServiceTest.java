package nl.novi.teacherproject.service;

import jakarta.inject.Inject;
import nl.novi.teacherproject.model.Teacher;
import nl.novi.teacherproject.repository.TeacherRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TeacherServiceTest {

    @Mock
    TeacherRepository teacherRepository;

    @InjectMocks
    TeacherService teacherService;

    @Captor
    ArgumentCaptor<Teacher> captor;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTeacher() {

        //arrange/given - benodigdheden klaarzetten
        Teacher teacher1 = new Teacher(1L, "Paul", "Dijxhoorn");
        Teacher teacher2 = new Teacher(2L, "Ollie", "de Roos");


        //act/when - we gaan iets uitvoeren

//        when(teacherRepository.findByFirstName("Paul")).thenReturn(teacher1);

//        when(teacherRepository.findByFirstName("Ollie")).thenReturn(teacher2);
Teacher teacherFound = teacherService.findTeacher("Ollie");

        //assert/then - checken of hetgene dat terugkomt overeenkomt met wat we verwachten van de methode

        assertEquals("Paul", teacher1.getFirstName());
        assertEquals("Ollie", teacher2.getFirstName());


    }
}
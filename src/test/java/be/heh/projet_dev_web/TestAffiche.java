package be.heh.projet_dev_web;

import be.heh.testarchitecturehexa.adaptater.in.StudentController;
import be.heh.testarchitecturehexa.model.Student;
import be.heh.testarchitecturehexa.port.in.StudentListUseCase;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
//@RunWith(SpringRunner.class)
@WebMvcTest(TournamentController.class)

public class TestAffiche {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentListUseCase studentListUseCase;

    private List<Student> students = new ArrayList<>();

    @Test
    public void testStudentController() throws Exception {

        students.add(new Student("tata","titi", LocalDate.of(2010,03,24)));
        students.add(new Student("tata1","titi1", LocalDate.of(2011,04,25)));
        students.add(new Student("tata2","titi2", LocalDate.of(2012,05,26)));

        //Stub
        Mockito.when(studentListUseCase.getStudentList()).thenReturn(students);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("studentList"))
                .andExpect(model().attributeExists("students"))
                .andExpect(model().attribute("students", Matchers.hasSize(3)));
    }
}

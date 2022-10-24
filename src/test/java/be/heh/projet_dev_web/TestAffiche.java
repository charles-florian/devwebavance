package be.heh.projet_dev_web;

import be.heh.projet_dev_web.adaptater.in.TournamentControler;
import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentListUseCase;
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
@WebMvcTest(TournamentControler.class)

public class TestAffiche {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TournamentListUseCase tournamentListUseCase;

    private List<Tournament> tournaments = new ArrayList<>();

    @Test
    public void testTournamentController() throws Exception {

        tournaments.add(new Tournament("tata", LocalDate.of(2010,03,24),17.5));
        tournaments.add(new Tournament("tata1", LocalDate.of(2011,04,25),17.5));
        tournaments.add(new Tournament("tata2", LocalDate.of(2012,05,26),17.5));

        //Stub
        Mockito.when(tournamentListUseCase.getTournamentList()).thenReturn(tournaments);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("tournamentList"))
                .andExpect(model().attributeExists("tournaments"))
                .andExpect(model().attribute("tournaments", Matchers.hasSize(3)));
    }
}

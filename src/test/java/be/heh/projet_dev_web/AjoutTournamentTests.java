package be.heh.projet_dev_web;

import be.heh.projet_dev_web.adaptater.in.AddController;
import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentAddUseCase;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(AddController.class)
public class AjoutTournamentTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TournamentAddUseCase tournamentAddUseCase;

    private Tournament tournament;

    @Test
    public void testAddTournamentController() throws Exception {
        tournament=new Tournament("VALORANT", LocalDate.now(),25.5);

        //Stub
        Mockito.when(tournamentAddUseCase.addTournament()).thenReturn(tournament);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("tournamentAdd"))
                .andExpect(model().attributeExists("tournament"));
    }
}

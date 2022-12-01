package be.heh.projet_dev_web;

import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentAddUseCase;
import be.heh.projet_dev_web.port.in.TournamentListUseCase;
import be.heh.projet_dev_web.port.in.TournamentUpdateUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
public class UpdateTournamentTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TournamentListUseCase tournamentListUseCase;

    @MockBean
    private TournamentAddUseCase tournamentAddUseCase;
    @MockBean
    private TournamentUpdateUseCase tournamentUpdateUseCase;


    @Test
    public void testUpdateController() throws Exception{

        Tournament tournament=new Tournament("VALORANT", "LocalDate.now()",25.5,10);

        Mockito.when(tournamentUpdateUseCase.toUpdateTournament("1")).thenReturn(tournament);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}

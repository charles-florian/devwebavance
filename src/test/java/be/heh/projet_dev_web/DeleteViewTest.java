package be.heh.projet_dev_web;

import be.heh.projet_dev_web.port.in.TournamentAddUseCase;
import be.heh.projet_dev_web.port.in.TournamentDeleteUseCase;
import be.heh.projet_dev_web.port.in.TournamentListUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

public class DeleteViewTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TournamentListUseCase tournamentListUseCase;

    @MockBean
    private TournamentAddUseCase tournamentAddUseCase;

    @MockBean
    private TournamentDeleteUseCase tournamentDeleteUseCase;

    @Test
    public void deleteViewTest() throws Exception{

        //Mockito.when(tournamentDeleteUseCase.tournamentDelete(10L)).thenReturn(null);
    }
}

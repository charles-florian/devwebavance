package be.heh.projet_dev_web;

import be.heh.projet_dev_web.adaptater.out.*;
import be.heh.projet_dev_web.model.Tournament;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

public class AddPersistenceTests extends AbstractIntegrationTest {

    private Tournament tournament=new Tournament("VALORANT",String.now(),15.5,10);

    @Autowired
    private TournamentRepository tournamentRepository;
    private AddPersistenceAdaptater addPersistenceAdaptater;
    private TournamentMapper tournamentMapper;
    private TournamentPersistenceAdapter tournamentPersistenceAdapter;



    @Test
    @Sql("createTournamentTable.sql")
    void addTournament(){


        addPersistenceAdaptater=new AddPersistenceAdaptater(tournamentRepository);
        addPersistenceAdaptater.addTournament(tournament);

        tournamentMapper=new TournamentMapper();
        tournamentPersistenceAdapter=new TournamentPersistenceAdapter(tournamentRepository,tournamentMapper);
        List<Tournament> tournaments;
        tournaments=tournamentPersistenceAdapter.getTournamentList();
        assertEquals("VALORANT",tournaments.get(tournaments.size()-1).getNom());
    }

}

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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class UpdatePersistenceTest {
    @Autowired
    private TournamentRepository tournamentRepository;
    private TournamentMapper tournamentMapper;


    private UpdatePersistenceAdaptater updatePersistenceAdaptater;
    private TournamentPersistenceAdapter tournamentPersistenceAdapter;

    @Test
    @Sql({"createTournamentTable.sql"})
    void getTournamentList(){

        Tournament tournament=new Tournament("VALORANT","747",21.2,1);
        AddPersistenceAdaptater addPersistenceAdaptater = new AddPersistenceAdaptater(tournamentRepository);
        addPersistenceAdaptater.addTournament(tournament);

        tournamentMapper=new TournamentMapper();
        tournamentPersistenceAdapter=new TournamentPersistenceAdapter(tournamentRepository,tournamentMapper);
        List<Tournament> tournaments;
        tournaments=tournamentPersistenceAdapter.getTournamentList();
        updatePersistenceAdaptater=new UpdatePersistenceAdaptater(tournamentRepository,tournamentMapper);
        Tournament t=new Tournament("CSGO","747",21.2,1);
        updatePersistenceAdaptater.updateTournament(t);
        tournaments=tournamentPersistenceAdapter.getTournamentList();

        assertEquals("CSGO",tournaments.get(tournaments.size()-1).getNom());
    }


}

package be.heh.projet_dev_web;


import be.heh.projet_dev_web.adaptater.out.TournamentMapper;
import be.heh.projet_dev_web.adaptater.out.TournamentRepository;
import be.heh.projet_dev_web.adaptater.out.TournamentPersistenceAdapter;
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
public class PersistenceTournamentTests extends AbstractIntegrationTest{

    @Autowired
    private TournamentRepository tournamentRepository;
    private TournamentMapper tournamentMapper;

    private TournamentPersistenceAdapter tournamentPersistenceAdapter;

    @Test
    @Sql({"createStudentTable.sql","dataStudent.sql"})
    void getTournamentList(){
        tournamentMapper = new TournamentMapper();
        tournamentPersistenceAdapter = new TournamentPersistenceAdapter(tournamentRepository,tournamentMapper);

        List<Tournament> tournaments;

        tournaments = TournamentPersistenceAdapter.getTournamentList();


        assertEquals("tata1",tournaments.get(1).getNom());
        assertEquals("tutu1",tournaments.get(1).getPrix());
        assertEquals(2000,tournaments.get(1).getDate().getYear());
    }
}
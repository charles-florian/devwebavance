package be.heh.projet_dev_web;

import be.heh.projet_dev_web.adaptater.out.*;
import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.model.User;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DeleteTournamentTest extends AbstractIntegrationTest {
    @Autowired
    private TournamentRepository repository;

    private TournamentPersistenceAdapter tournamentPersistenceAdapter;
    private TournamentMapper tournamentMapper;



    @Test
    @Sql("dataTournament.sql")
     void deletById(){
        tournamentMapper = new TournamentMapper();
        tournamentPersistenceAdapter = new TournamentPersistenceAdapter(repository,tournamentMapper);

        List<Tournament> tournaments;

        tournaments = tournamentPersistenceAdapter.getTournamentList();

        assertEquals(1,repository.count());

    }



}

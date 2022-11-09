package be.heh.projet_dev_web;

import be.heh.projet_dev_web.adaptater.out.AddPersistenceAdaptater;
import be.heh.projet_dev_web.adaptater.out.TournamentJpaEntity;
import be.heh.projet_dev_web.adaptater.out.TournamentMapper;
import be.heh.projet_dev_web.adaptater.out.TournamentRepository;
import be.heh.projet_dev_web.model.Tournament;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AddPersistenceTests extends AbstractIntegrationTest {

    private Tournament tournament=new Tournament("VALORANT",LocalDate.now(),15.5);

    @Autowired
    private TournamentRepository tournamentRepository;
    private AddPersistenceAdaptater addPersistenceAdaptater;


    @Test
    void addTournament(){


        addPersistenceAdaptater=new AddPersistenceAdaptater(tournamentRepository);
    }

}

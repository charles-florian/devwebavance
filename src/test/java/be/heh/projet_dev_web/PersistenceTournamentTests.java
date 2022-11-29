package be.heh.projet_dev_web;


import be.heh.projet_dev_web.adaptater.out.*;
import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.model.User;
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
public class PersistenceTournamentTests extends AbstractIntegrationTest {

    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private UserRepository userRepository;

    private TournamentMapper tournamentMapper;
    private UserMapper userMapper;


    private TournamentPersistenceAdapter tournamentPersistenceAdapter;
    private UserPersistenceAdapter userPersistenceAdapter;

    @Test
    @Sql({"createTournamentTable.sql","dataTournament.sql"})
    void getTournamentList(){
        tournamentMapper = new TournamentMapper();
        tournamentPersistenceAdapter = new TournamentPersistenceAdapter(tournamentRepository,tournamentMapper);

        List<Tournament> tournament;

        tournament = tournamentPersistenceAdapter.getTournamentList();


        assertEquals("cs",tournament.get(1).getNom());
    }

    @Test
    @Sql({"createUser.sql","dataUser.sql"})
    void getUserList(){
        userMapper = new UserMapper();
        userPersistenceAdapter = new UserPersistenceAdapter(userRepository,userMapper);

        List<User> users;

        users = userPersistenceAdapter.getUserList();

        assertEquals("toto@gmail.com",users.get(0).getEmail());

    }
}
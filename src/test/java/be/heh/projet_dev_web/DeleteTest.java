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

import static java.lang.Long.parseLong;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DeleteTest {


    @Autowired
    private TournamentRepository tournamentRepository;
    private TournamentMapper tournamentMapper;
    private TournamentPersistenceAdapter tournamentPersistenceAdapter;

    @Test
    @Sql({"creatingTournamentTable.sql", "putTournament.sql"})
    void deleteTournament(){


        tournamentMapper=new TournamentMapper();
        tournamentPersistenceAdapter=new TournamentPersistenceAdapter(tournamentRepository,tournamentMapper);
        List<Tournament> tournaments;
        tournaments=tournamentPersistenceAdapter.getTournamentList();
        int x=tournaments.size();
        Tournament t=tournaments.get(x-1);
        DeletePersistenceAdaptater deletePersistenceAdaptater=new DeletePersistenceAdaptater(tournamentRepository);
        deletePersistenceAdaptater.tournamentDelete(t.getId_tournament());
        tournaments=tournamentPersistenceAdapter.getTournamentList();
        int y=tournaments.size();

        int z=x-y;

        assertEquals(1,z);



    }
}

package be.heh.projet_dev_web;

import be.heh.projet_dev_web.adaptater.out.TournamentMapper;
import be.heh.projet_dev_web.adaptater.out.TournamentPersistenceAdapter;
import be.heh.projet_dev_web.adaptater.out.TournamentRepository;
import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
    @Autowired
    private TournamentRepository tournamentRepository;

    private TournamentMapper tournamentMapper = new TournamentMapper();

    @Bean
    TournamentListUseCase getTournamentListUseCase(){

        return new TournamentPersistenceAdapter(tournamentRepository,tournamentMapper);
    }

}
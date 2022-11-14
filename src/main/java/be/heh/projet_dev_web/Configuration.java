package be.heh.projet_dev_web;

import be.heh.projet_dev_web.adaptater.out.TournamentMapper;
import be.heh.projet_dev_web.adaptater.out.TournamentPersistenceAdapter;
import be.heh.projet_dev_web.adaptater.out.TournamentRepository;
import be.heh.projet_dev_web.adaptater.out.AddPersistenceAdaptater;
import be.heh.projet_dev_web.port.in.TournamentAddUseCase;
import be.heh.projet_dev_web.port.in.TournamentListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
    @Autowired
    private TournamentRepository tournamentRepository;

    private TournamentMapper tournamentMapper=new TournamentMapper();

    @Bean
    TournamentAddUseCase addTournament(){
        return new AddPersistenceAdaptater(tournamentRepository);
    }

    @Bean
    TournamentListUseCase getTounamentList(){
        return new TournamentPersistenceAdapter(tournamentRepository,tournamentMapper);
    }

}

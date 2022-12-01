package be.heh.projet_dev_web;

import be.heh.projet_dev_web.adaptater.out.*;
import be.heh.projet_dev_web.port.in.TournamentAddUseCase;
import be.heh.projet_dev_web.port.in.TournamentDeleteUseCase;
import be.heh.projet_dev_web.port.in.TournamentListUseCase;
import be.heh.projet_dev_web.port.in.TournamentUpdateUseCase;
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
    TournamentListUseCase getTournamentList(){
        return new TournamentPersistenceAdapter(tournamentRepository,tournamentMapper);
    }
    @Bean
    TournamentDeleteUseCase tournamentDeleteUseCase(){
        return new DeletePersistenceAdaptater(tournamentRepository);

    }

    @Bean
    TournamentUpdateUseCase toUpdateTournament(){
        return new UpdatePersistenceAdaptater(tournamentRepository,tournamentMapper);
    }


}

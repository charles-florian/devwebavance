package be.heh.projet_dev_web;

import be.heh.projet_dev_web.adaptater.out.*;
import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentListUseCase;
import be.heh.projet_dev_web.port.in.UserListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
    @Autowired
    private TournamentRepository tournamentRepository;
    private UserRepository userRepository;

    private TournamentMapper tournamentMapper = new TournamentMapper();
    private UserMapper userMapper = new UserMapper();

    @Bean
    TournamentListUseCase getTournamentListUseCase(){

        return new TournamentPersistenceAdapter(tournamentRepository,tournamentMapper);
    }

    @Bean
    UserListUseCase getUserListUseCase(){
        return new UserPersistenceAdapter(userRepository,userMapper);
    }

}
package be.heh.projet_dev_web.adaptater.out;

import be.heh.projet_dev_web.model.Tournament;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class TournamentMapper {
    List<Tournament> mapToDomainEntity(List<TournamentJpaEntity> tournaments){
        List<Tournament> tournamentsList = new ArrayList<>();

        for (TournamentJpaEntity tournamentJpaEntity: tournaments) {
            tournamentsList.add(new Tournament(tournamentJpaEntity.getNom(),tournamentJpaEntity.getDate(),tournamentJpaEntity.getPrix()));
        }
        return tournamentsList;
    }
}

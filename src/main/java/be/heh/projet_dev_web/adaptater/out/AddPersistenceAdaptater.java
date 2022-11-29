package be.heh.projet_dev_web.adaptater.out;

import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentAddUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddPersistenceAdaptater implements TournamentAddUseCase {

    private final TournamentRepository tournamentRepository;

    @Override
    public String addTournament(Tournament tournament) {

        TournamentJpaEntity tournamentEntity =new TournamentJpaEntity(tournament.getNom(), tournament.getDate(), tournament.getPrix());
        tournamentRepository.save(tournamentEntity);

        return null;

    }
}

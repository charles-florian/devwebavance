package be.heh.projet_dev_web.adaptater.out;

import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentAddUseCase;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

@RequiredArgsConstructor
public class AddPersistenceAdaptater implements TournamentAddUseCase {

    private final TournamentRepository tournamentRepository;

    @Override
    public String addTournament(Tournament tournament) {



        TournamentJpaEntity tournamentEntity =new TournamentJpaEntity(Jsoup.clean(tournament.getNom(),Safelist.basic()), Jsoup.clean(tournament.getDate(),Safelist.basic()), tournament.getPrix());
        tournamentRepository.save(tournamentEntity);

        return null;

    }
}

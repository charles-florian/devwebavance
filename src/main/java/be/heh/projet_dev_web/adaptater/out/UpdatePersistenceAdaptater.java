package be.heh.projet_dev_web.adaptater.out;

import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

@RequiredArgsConstructor
public class UpdatePersistenceAdaptater implements TournamentUpdateUseCase {

    private final TournamentRepository tournamentRepository;
    private List<Tournament> tournaments;

    private final TournamentMapper tournamentMapper;
    @Override
    public Tournament toUpdateTournament(String id) {
        List<TournamentJpaEntity> tournamentEntity = tournamentRepository.findAll();
        tournaments=tournamentMapper.mapToDomainEntity(tournamentEntity);
        Tournament toReturn=new Tournament("test","test",20.5,99);

        for (Tournament x:tournaments) {
            if(x.getId_tournament()==parseLong(id))
            {
                toReturn=x;
            }
        }
        return toReturn;
    }

    @Override
    public void updateTournament(Tournament t){

        TournamentJpaEntity tournament=tournamentRepository.getReferenceById(t.getId_tournament());
        tournament.setDate(Jsoup.clean(t.getDate(), Safelist.basic()));
        tournament.setNom(Jsoup.clean(t.getNom(),Safelist.basic()));
        tournament.setPrix(t.getPrix());
        tournamentRepository.save(tournament);
    }
}

package be.heh.projet_dev_web.adaptater.out;

import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentUpdateUseCase;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

@RequiredArgsConstructor
public class UpdatePersistenceAdaptater implements TournamentUpdateUseCase {

    private final TournamentRepository tournamentRepository;
    private List<Tournament> tournaments;

    private final TournamentMapper tournamentMapper;
    @Override
    public List<Tournament> toUpdateTournament(String id) {
        List<TournamentJpaEntity> tournamentEntity = tournamentRepository.findAll();
        tournaments=tournamentMapper.mapToDomainEntity(tournamentEntity);
        List<Tournament> toReturn=new ArrayList<>();

        for (Tournament x:tournaments) {

            if(x.getId_tournament()==parseLong(id))
            {
                toReturn.add(x);

            }
        }

        return toReturn;

    }
}

package be.heh.projet_dev_web.adaptater.out;


import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

import javax.persistence.OrderBy;
import java.util.List;
@RequiredArgsConstructor
public class TournamentPersistenceAdapter implements TournamentListUseCase {


    private final TournamentRepository tournamentRepository;
    private List<Tournament> tournaments;

    private final TournamentMapper tournamentMapper;

    @Override
    public  List<Tournament> getTournamentList() {
        List<TournamentJpaEntity> tournamentEntity = tournamentRepository.findAll();

        return tournamentMapper.mapToDomainEntity(tournamentEntity);
    }

}

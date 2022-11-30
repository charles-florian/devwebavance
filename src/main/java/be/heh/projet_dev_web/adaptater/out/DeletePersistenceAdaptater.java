package be.heh.projet_dev_web.adaptater.out;

import be.heh.projet_dev_web.model.Tournament;
import be.heh.projet_dev_web.port.in.TournamentDeleteUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeletePersistenceAdaptater implements TournamentDeleteUseCase {
    private final TournamentRepository tournamentRepository;
    @Override
    public void tournamentDelete(Long id) {
        tournamentRepository.deleteById(id);
    }
}

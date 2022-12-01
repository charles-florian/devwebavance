package be.heh.projet_dev_web.port.in;

import be.heh.projet_dev_web.model.Tournament;

import java.util.List;

public interface TournamentUpdateUseCase {

    Tournament toUpdateTournament(String id);

    void updateTournament(Tournament t);

}

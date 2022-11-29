package be.heh.projet_dev_web.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class Tournament {

    @Getter
    private final String nom;
    @Getter
    private final LocalDate date;
    @Getter
    private final Double prix;
    @Getter
    private final long id_tournament;


}
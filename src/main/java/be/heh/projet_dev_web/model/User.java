package be.heh.projet_dev_web.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {
    @Getter
    private final String email;

    @Getter
    private final String pseudo;

    @Getter
    private final String mdp;



}

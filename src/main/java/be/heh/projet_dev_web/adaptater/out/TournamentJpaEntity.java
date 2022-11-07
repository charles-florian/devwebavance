package be.heh.projet_dev_web.adaptater.out;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "tournaments")
public class TournamentJpaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "nom")
    private String nom;

    @Column(name = "prix")
    private double prix;



    @Column(name = "date_tournament")
    private LocalDate date;
}
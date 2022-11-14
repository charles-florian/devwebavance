package be.heh.projet_dev_web.adaptater.out;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Setter
@Table(name = "tournaments")
public class TournamentJpaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_tournament")
    private Long id_tournament;

    @Column(name = "prix")
    private double prix;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_tournament")
    private LocalDate date;
    public TournamentJpaEntity(){}

    public TournamentJpaEntity(String nom,LocalDate date,double prix){
        this.nom=nom;
        this.date=date;
        this.prix=prix;
    }

    //protected TournamentJpaEntity() {}
}
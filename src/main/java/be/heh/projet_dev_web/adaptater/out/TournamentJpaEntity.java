package be.heh.projet_dev_web.adaptater.out;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Setter
@Table(name = "students")
public class TournamentJpaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "prix")
    private Double prix;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date")
    private LocalDate date;

    public TournamentJpaEntity(String nom,LocalDate date,Double prix){
        this.nom=nom;
        this.date=date;
        this.prix=prix;
    }

    protected TournamentJpaEntity() {}
}
package be.heh.projet_dev_web.adaptater.out;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")

public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="email")
    private String email;

    @Column(name="pseudo")
    private String pseudo;

    @Column(name="mdp")
    private String mdp;


}

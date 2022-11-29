package be.heh.projet_dev_web.adaptater.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserJpaEntity,Long> {
}

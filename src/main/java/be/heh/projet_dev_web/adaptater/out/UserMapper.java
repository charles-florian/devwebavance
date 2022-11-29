package be.heh.projet_dev_web.adaptater.out;



import be.heh.projet_dev_web.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    List<User> mapToDomainEntity(List<UserJpaEntity> users){
        List<User> usersList = new ArrayList<>();

        for (UserJpaEntity userJpaEntity: users) {
            usersList.add(new User(userJpaEntity.getEmail(),userJpaEntity.getPseudo(),userJpaEntity.getMdp()));
        }
        return usersList;
    }
}

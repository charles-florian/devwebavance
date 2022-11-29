package be.heh.projet_dev_web.adaptater.out;



import be.heh.projet_dev_web.port.in.UserListUseCase;
import lombok.RequiredArgsConstructor;
import be.heh.projet_dev_web.model.User;

import java.util.List;
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserListUseCase {


    private final UserRepository userRepository;
    private List<User> users;

    private final UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        List<UserJpaEntity> userEntity = userRepository.findAll();
        return userMapper.mapToDomainEntity(userEntity);
    }

}

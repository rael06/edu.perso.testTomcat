package domain.repositoriesInterfaces;

import domain.User;

import java.util.Optional;

public interface IUserRepository {
    void add(User user);
    Optional<User> findByLoginPassword (String login, String password);
}

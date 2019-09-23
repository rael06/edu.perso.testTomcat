package infrastructure;

import domain.User;
import domain.repositoriesInterfaces.IUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements IUserRepository {
    private static InMemoryUserRepository INSTANCE;

    private List<User> users = new ArrayList<>();

    private InMemoryUserRepository() {}

    public static InMemoryUserRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (InMemoryUserRepository.class) {
                INSTANCE = new InMemoryUserRepository();
                INSTANCE.add(new User("rael", "pass"));
            }
        }
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    public Optional<User> findByLoginPassword (String login, String password) {
        return users.stream().filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password)).findFirst();
    }
}

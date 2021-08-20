package storage;

import model.User;

import java.util.List;

public interface IUserStorage {

    User get(String login);

    boolean add(User user);

    List<User> getAll();

    boolean existByLogin(String login);

    User getByLoginAndPassword(String login, String password);
}

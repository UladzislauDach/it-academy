package storage;

import model.User;

import java.util.Map;

public interface IUserStorage {

    User get(String login);

    boolean add(User user);

    Map<String, User> getAll();
}

package storage;

import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RamUserStorage implements IUserStorage {

    private static final RamUserStorage instance = new RamUserStorage();
    private final Map<String, User> userMap = new HashMap<>();

    private RamUserStorage() {
    }

    public static RamUserStorage getInstance() {
        return instance;
    }

    @Override
    public User get(String login) {
        return userMap.get(login);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userMap.values();
    }

    @Override
    public boolean existByLogin(String login) {
        return userMap.containsKey(login);
    }

    @Override
    public User getByLoginAndPassword(String login, String password) {
        if (!userMap.containsKey(login)) {
            return null;
        }
        User user = userMap.get(login);
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }

    }

    @Override
    public boolean add(User user) {
        if (userMap.containsKey(user.getLogin())) {
            return false;
        } else {
            userMap.put(user.getLogin(), user);
            return true;
        }
    }


}

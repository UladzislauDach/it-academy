package storage.ram;

import model.User;
import storage.IUserStorage;

import java.util.HashMap;
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
    public Map<String, User> getAll() {
        return userMap;
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

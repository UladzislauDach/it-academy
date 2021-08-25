package view;

import model.User;
import storage.AppParam;
import storage.EStorageType;
import storage.api.IUserStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {
    private static final UserService instance = new UserService();

    private final IUserStorage userStorage;

    public static UserService getInstance() {
        return instance;
    }

    private UserService() {
        AppParam appParam = AppParam.getInstance();
        EStorageType userStorageType = appParam.getStorageType();
        this.userStorage = userStorageType.getUserStorageType();
    }

    public User getByLoginAndPassword(String login, String password) {
        Map<String, User> userMap = userStorage.getAll();
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

    public boolean existByLogin(String login) {
        return userStorage.getAll().containsKey(login);
    }

    public void add(User user) {
        userStorage.add(user);
    }

    public List<User> getAll() {
        return new ArrayList<>(userStorage.getAll().values());
    }
}

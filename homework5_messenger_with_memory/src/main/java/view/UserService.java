package view;

import model.User;
import storage.EStorageType;
import storage.file.FileUserStorage;
import storage.IUserStorage;

public class UserService {
    private static final UserService instance = new UserService();

    private final IUserStorage userStorage;

    public static UserService getInstance() {
        return instance;
    }

    private UserService() {
        this.userStorage = EStorageType.valueOfIgnoreCase("ram").getUserStorageType();
    }

    public User getByLoginAndPassword(String login, String password) {
        return userStorage.getByLoginAndPassword(login, password);
    }

    public boolean existByLogin(String login) {
        return userStorage.existByLogin(login);
    }

    public void add(User user) {
        userStorage.add(user);
    }
}

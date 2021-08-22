package view;

import model.User;
import storage.CurrentStorageType;
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
        CurrentStorageType currentStorageType = CurrentStorageType.getInstance();
        EStorageType userStorageType = EStorageType.valueOfIgnoreCase(currentStorageType.getStorageType());
        this.userStorage = userStorageType.getUserStorageType();
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

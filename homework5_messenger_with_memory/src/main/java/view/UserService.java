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
            throw new IllegalArgumentException("Неправильный логин или пароль");
        }
        User user = userMap.get(login);
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            throw new IllegalArgumentException("Неправильный логин или пароль");
        }
    }

    public void validateUserForSingUp(User user) {
        if (existByLogin(user.getLogin())) {
            throw new IllegalArgumentException("Логин уже занят");
        }
        validationUserFields(user);


    }

    private void validationUserFields(User user) {
        String errorMsg = "";
        if (nullOrEmpty(user.getLogin())) {
            errorMsg += "Поле логин не заполнено ";
        }
        if (nullOrEmpty(user.getPassword())) {
            errorMsg += "Поле пароль не заполнено ";
        }
        if (nullOrEmpty(user.getBirthDate())) {
            errorMsg += "Поле день рождения не заполнено ";
        }
        if (nullOrEmpty(user.getName())) {
            errorMsg += "Поле ФИО не заполнено ";
        }
        if (!errorMsg.isEmpty()) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    private boolean nullOrEmpty(String str) {
        return str == null || str.isEmpty();
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

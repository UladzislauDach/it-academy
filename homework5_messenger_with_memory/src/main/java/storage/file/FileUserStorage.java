package storage.file;

import model.User;
import storage.IUserStorage;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUserStorage implements IUserStorage {

    public static FileUserStorage fileUserStorage = new FileUserStorage();

    public static FileUserStorage getInstance() {
        return fileUserStorage;
    }

    private FileUserStorage() {
        writeUserMap();
    }

    private Map<String, User> userMap = new HashMap<>();

    private void writeUserMap() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.bin"))) {
            oos.writeObject(userMap);
        } catch (IOException e) {
            e.printStackTrace(); //todo сделать норм обработку
        }
    }

    @SuppressWarnings("unchecked")
    private void readUserMap() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.bin"))) {
            userMap = (Map<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); //todo сделать норм обработку
        }
    }

    @Override
    public User get(String login) {
        readUserMap();
        return userMap.get(login);
    }

    @Override
    public boolean add(User user) {
        if (userMap.containsKey(user.getLogin())) {
            return false;
        } else {
            userMap.put(user.getLogin(), user);
            writeUserMap();
            return true;
        }
    }

    @Override
    public List<User> getAll() {
        readUserMap();
        return (List<User>) userMap.values();
    }

    @Override
    public boolean existByLogin(String login) {
        readUserMap();
        return userMap.containsKey(login);
    }

    @Override
    public User getByLoginAndPassword(String login, String password) {
        readUserMap();
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
}

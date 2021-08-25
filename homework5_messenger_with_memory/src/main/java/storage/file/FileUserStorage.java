package storage.file;

import model.User;
import storage.api.IUserStorage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileUserStorage implements IUserStorage {

    private static final FileUserStorage fileUserStorage = new FileUserStorage();
    private static final String FILE_NAME = "users.bin";

    public static FileUserStorage getInstance() {
        return fileUserStorage;
    }

    private FileUserStorage() {
        writeUserMap(); //записываем пустой файл
    }

    private Map<String, User> userMap = new HashMap<>();

    private void writeUserMap() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(userMap);
        } catch (IOException e) {
            e.printStackTrace(); //todo как лучше обработать?
        }
    }


    private void readUserMap() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            userMap = (Map<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); //todo как лучше обработать?
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
    public Map<String, User> getAll() {
        return userMap;
    }
}

package storage.file;

import model.Message;
import storage.IMessageStorage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileMessageStorage implements IMessageStorage {
    private static final FileMessageStorage messageStorage = new FileMessageStorage();

    Map<String, List<Message>> messageMap = new HashMap<>(); // почему бы в качестве ключа не использовать User

    private FileMessageStorage() {
        writeMessageMap(); // Записываем пустой файл
    }

    private void writeMessageMap() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("message.bin"))) {
            oos.writeObject(messageMap);
        } catch (IOException e) {
            e.printStackTrace(); //todo сделать обработку
        }
    }

    private void readMessageMap() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("message.bin"))) {
            messageMap = (Map<String, List<Message>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); //todo сделать обработку
        }
    }

    public static FileMessageStorage getInstance() {
        return messageStorage;
    }

    public void add(String to, Message message) {
        if (messageMap.containsKey(to)) {
            messageMap.get(to).add(message);
        } else {
            List<Message> list = new ArrayList<>();
            list.add(message);
            messageMap.put(to, list);
        }
        writeMessageMap();
    }

    public List<Message> getList(String userLogin) {
        readMessageMap();
        return messageMap.get(userLogin);
    }
}

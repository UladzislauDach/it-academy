package storage;

import model.Message;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageStorage implements IMessageStorage {
    private static final MessageStorage messageStorage = new MessageStorage();

    Map<String , List<Message>> messageMap = new HashMap<>(); // почему бы в качестве ключа не использовать User

    private MessageStorage() {
    }

    public static MessageStorage getInstance() {
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
    }

    public List<Message> getList(String userLogin) {
        return messageMap.get(userLogin);
    }

}

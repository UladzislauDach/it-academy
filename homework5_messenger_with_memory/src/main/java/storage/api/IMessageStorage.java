package storage.api;

import model.Message;

import java.util.List;

public interface IMessageStorage {

    void add(String to, Message message);

    List<Message> getList(String userLogin);
}

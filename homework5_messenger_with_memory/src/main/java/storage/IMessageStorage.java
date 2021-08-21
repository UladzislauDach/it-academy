package storage;

import model.Message;
import model.User;

import java.util.List;

public interface IMessageStorage {

    public void add(String to, Message message);

    public List<Message> getList(String userLogin);
}

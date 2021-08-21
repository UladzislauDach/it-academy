package view;

import model.Message;
import storage.FileMessageStorage;
import storage.IMessageStorage;
import storage.RamMessageStorage;

import java.util.List;

public class MessageService {
    private static final MessageService messageService = new MessageService();

    private final IMessageStorage messageStorage;

    private MessageService() {
        this.messageStorage = FileMessageStorage.getInstance();
    } //todo

    public static MessageService getInstance() {
        return messageService;
    }

    public List<Message> getMessageList(String user) {
        return messageStorage.getList(user);
    }

    public void add(String to, Message message) {
        messageStorage.add(to, message);
    }

}

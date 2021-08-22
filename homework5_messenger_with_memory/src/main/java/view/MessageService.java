package view;

import model.Message;
import storage.EStorageType;
import storage.file.FileMessageStorage;
import storage.IMessageStorage;

import java.util.List;

public class MessageService {
    private static final MessageService messageService = new MessageService();

    private final IMessageStorage messageStorage;

    private MessageService() {
        this.messageStorage = EStorageType.valueOfIgnoreCase("disk").getMessageStorageType();
    }

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

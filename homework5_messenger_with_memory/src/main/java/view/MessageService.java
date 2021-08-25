package view;

import model.Message;
import storage.AppParam;
import storage.EStorageType;
import storage.IMessageStorage;

import java.util.List;

public class MessageService {
    private static final MessageService messageService = new MessageService();

    private final IMessageStorage messageStorage;

    private MessageService() {
        AppParam appParam = AppParam.getInstance();
        EStorageType messageStorageType = appParam.getStorageType();
        this.messageStorage = messageStorageType.getMessageStorageType();
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

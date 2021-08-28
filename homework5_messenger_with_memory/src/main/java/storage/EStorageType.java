package storage;

import storage.api.IMessageStorage;
import storage.api.IUserStorage;
import storage.file.FileMessageStorage;
import storage.file.FileUserStorage;
import storage.ram.RamMessageStorage;
import storage.ram.RamUserStorage;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum EStorageType {
    DISK(FileMessageStorage.getInstance(), FileUserStorage.getInstance(), "жесткий диск"),
    RAM(RamMessageStorage.getInstance(), RamUserStorage.getInstance(), "оперативная память");

    IMessageStorage iMessageStorage;
    IUserStorage iUserStorage;
    String name;

    EStorageType(IMessageStorage iMessageStorage, IUserStorage iUserStorage, String name) {
        this.iMessageStorage = iMessageStorage;
        this.iUserStorage = iUserStorage;
        this.name = name;
    }

    public IMessageStorage getMessageStorageType() {
        return this.iMessageStorage;
    }

    public IUserStorage getUserStorageType() {
        return this.iUserStorage;
    }

    public String getName() {
        return name;
    }

    public static EStorageType
    valueOfIgnoreCase(String storageType) {
        return Arrays.stream(values()).filter(eStorageType -> eStorageType.name()
                .equalsIgnoreCase(storageType)).findFirst().orElseThrow(NoSuchElementException::new);
    }
}

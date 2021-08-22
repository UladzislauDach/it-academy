package storage;

import storage.file.FileMessageStorage;
import storage.file.FileUserStorage;
import storage.ram.RamMessageStorage;
import storage.ram.RamUserStorage;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum EStorageType {
    DISK(FileMessageStorage.getInstance(), FileUserStorage.getInstance()),
    RAM(RamMessageStorage.getInstance(), RamUserStorage.getInstance());

    IMessageStorage iMessageStorage;
    IUserStorage iUserStorage;

    EStorageType(IMessageStorage iMessageStorage, IUserStorage iUserStorage) {
        this.iMessageStorage = iMessageStorage;
        this.iUserStorage = iUserStorage;
    }

    public IMessageStorage getMessageStorageType() {
        return this.iMessageStorage;
    }

    public IUserStorage getUserStorageType() {
        return this.iUserStorage;
    }

    public static EStorageType valueOfIgnoreCase(String storageType) {
        return Arrays.stream(values()).filter(eStorageType -> eStorageType.name()
                .equalsIgnoreCase(storageType)).findFirst().orElseThrow(NoSuchElementException::new);
    }
}

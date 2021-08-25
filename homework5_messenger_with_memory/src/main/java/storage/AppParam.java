package storage;

import java.time.LocalDateTime;

public class AppParam {
    private static AppParam instance;

    private EStorageType storageType;
    private LocalDateTime startTime;

    private AppParam() {
    }

    public EStorageType getStorageType() {
        return storageType;
    }

    public void setStorageType(EStorageType storageType) {
        this.storageType = storageType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public static AppParam getInstance() {
        if (instance == null) {
            instance = new AppParam();
        }
        return instance;
    }
}

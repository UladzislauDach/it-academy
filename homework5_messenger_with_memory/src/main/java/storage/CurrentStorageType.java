package storage;

public class CurrentStorageType {
    private static CurrentStorageType instance;

    private String storageType;

    private CurrentStorageType() {
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public static CurrentStorageType getInstance(){
        if (instance==null){
            instance = new CurrentStorageType();
        }
        return instance;
    }
}

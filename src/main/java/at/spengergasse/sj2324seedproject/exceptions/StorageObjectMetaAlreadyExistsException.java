package at.spengergasse.sj2324seedproject.exceptions;

public class StorageObjectMetaAlreadyExistsException extends Exception{

    public StorageObjectMetaAlreadyExistsException(String message){
        super(message);
    }

    public StorageObjectMetaAlreadyExistsException(String message, Throwable cause){
        super(message, cause);
    }
}

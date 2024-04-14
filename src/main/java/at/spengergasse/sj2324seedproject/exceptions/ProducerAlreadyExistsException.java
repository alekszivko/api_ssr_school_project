package at.spengergasse.sj2324seedproject.exceptions;

public class ProducerAlreadyExistsException extends Throwable{
    public ProducerAlreadyExistsException(String message){
        super(message);
    }

    public ProducerAlreadyExistsException(String message,
                                          Throwable cause){
        super(message,
              cause);
    }
}

package at.spengergasse.sj2324seedproject.exceptions;


public class ExceptionProducer extends Exception{

    public ExceptionProducer(String message, Throwable cause){
        super(message, cause);
    }

    public ExceptionProducer(String message){
        super(message);
    }
}

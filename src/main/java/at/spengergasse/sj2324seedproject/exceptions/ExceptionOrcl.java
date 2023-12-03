package at.spengergasse.sj2324seedproject.exceptions;

public class ExceptionOrcl extends Exception{

    public ExceptionOrcl(String message, Throwable cause){
        super(message, cause);
    }

    public ExceptionOrcl(Throwable cause){
        super(cause);
    }
}

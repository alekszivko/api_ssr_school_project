package at.spengergasse.sj2324seedproject.foundation;

public class Guard {

    public static <T> T isNotNull(T object, String name){
        if (object == null){
            throw new IllegalArgumentException("'%s' must not be null!".formatted(name));
        }
        return object;
    }

    public static <T> T isNotNull(T object){
        return isNotNull(object,"argument");
    }
}

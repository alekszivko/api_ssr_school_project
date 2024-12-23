package at.spengergasse.sj2324seedproject.foundation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
@AllArgsConstructor
@RequiredArgsConstructor
@Data
//@RequiredArgsConstructor
public class Base58{
    private static final char[]       ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrrstuvwxyz".toCharArray();
    private static final SecureRandom RANDOM   = new SecureRandom();

    private String  prefix;
    private Integer length;
    private String  codeCrea;

    public Base58(String prefix, int length){
        this.prefix   = prefix;
        this.length   = length;
        this.codeCrea = randomString(this.length);
    }

    public String randomString(int length){
        char[] result = new char[length];
        for(int i = 0; i<length; i++){
            char pick = ALPHABET[RANDOM.nextInt(ALPHABET.length)];
            result[i] = pick;
        }
        return new String(result);
    }
}

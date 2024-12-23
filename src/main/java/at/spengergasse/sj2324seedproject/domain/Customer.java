package at.spengergasse.sj2324seedproject.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder


@Embeddable
public record Customer(String connectionNo) {

    @Override
    public String toString(){
        if(connectionNo != null){
            return connectionNo;
        }else{
            return "No number!";
        }
    }
}

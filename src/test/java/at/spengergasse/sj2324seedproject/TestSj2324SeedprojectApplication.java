package at.spengergasse.sj2324seedproject;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

public class TestSj2324SeedprojectApplication {

    public static void main(String[] args){
        SpringApplication.from(Sj2324SeedprojectApplication::main)
                .with(TestContainerConfiguration.class)
                .run(args);
    }
}

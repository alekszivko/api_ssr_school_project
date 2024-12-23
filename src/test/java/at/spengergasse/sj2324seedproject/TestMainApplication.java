package at.spengergasse.sj2324seedproject;


import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestMainApplication{


    public static void main(String[] args){
        SpringApplication
            .from(Sj2324SeedprojectApplication::main)
            .with(TestContainerConfiguration.class)
            .run(args);
    }



}
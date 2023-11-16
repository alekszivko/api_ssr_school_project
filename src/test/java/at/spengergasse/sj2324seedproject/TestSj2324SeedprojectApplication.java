package at.spengergasse.sj2324seedproject;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSj2324SeedprojectApplication{


    public static void main(String[] args){
        SpringApplication.from(Sj2324SeedprojectApplication :: main)
                .with(Sj2324SeedprojectApplication.class)
                .with(TestContainerConfiguration.class)
                .run(args);
    }

}

package at.spengergasse.sj2324seedproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sj2324SeedprojectApplication {

	public static void main(String[] args) {
		System.out.println(org.hibernate.Version.getVersionString());
		SpringApplication.run(Sj2324SeedprojectApplication.class, args);
	}

}

package at.spengergasse.sj2324seedproject;

<<<<<<< HEAD
=======

>>>>>>> groupOf4Classes
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.utility.DockerImageName;

@Configuration
public class TestSj2324SeedprojectApplication {

    @Bean
    @ServiceConnection
    OracleContainer oracleContainer() {
        return new OracleContainer(DockerImageName.parse("gvenzl/oracle-xe:21-slim-faststart"))
                       .withEnv("APP_USER", "oracle")
                       .withEnv("APP_USER_PASSWORD", "oracle")
                       .withUsername("oracle")
                       .withPassword("oracle")
                       .withExposedPorts(1521)
                       .withCreateContainerCmdModifier(cmd -> {
                           cmd.withName("samic-oracle");
                           cmd.withHostConfig(new HostConfig().withPortBindings(new PortBinding(Ports.Binding.bindPort(1521), new ExposedPort(1521))));
<<<<<<< HEAD
                       });
    }

=======
                       }).withReuse(true);
    }


>>>>>>> groupOf4Classes
    public static void main(String[] args){
        SpringApplication.from(Sj2324SeedprojectApplication::main)
                .with(TestSj2324SeedprojectApplication.class)
                .run(args);
    }
<<<<<<< HEAD
}
=======
}

>>>>>>> groupOf4Classes

package at.spengergasse.sj2324seedproject;


//import com.github.dockerjava.api.model.ExposedPort;
//import com.github.dockerjava.api.model.HostConfig;
//import com.github.dockerjava.api.model.PortBinding;
//import com.github.dockerjava.api.model.Ports;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@Configuration
public class TestMainApplication{


    //    @Bean
    //    @ServiceConnection
    //    OracleContainer oracleContainer(){
    //        return new OracleContainer(DockerImageName.parse("gvenzl/oracle-xe:21-slim-faststart")).withEnv("APP_USER", "oracle")
    //                                                                                               .withEnv("APP_USER_PASSWORD", "oracle")
    //                                                                                               .withUsername("oracle")
    //                                                                                               .withPassword("oracle")
    //                                                                                               .withExposedPorts(1521)
    //                                                                                               .withCreateContainerCmdModifier(cmd -> {
    //                                                                                                   cmd.withName("samic-oracle");
    //                                                                                                   cmd.withHostConfig(new HostConfig().withPortBindings(new PortBinding(Ports.Binding.bindPort(1521), new ExposedPort(1521))));
    //
    //                                                                                               })
    //                                                                                               .withReuse(true);
    //        }

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgreSQLContainer(){
        final int exposedPort = 5432;
        final int localPort   = 5431;
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16-alpine")).withExposedPorts(exposedPort)
                                                                                     .withUsername("geheim")
                                                                                     .withPassword("secret")
                                                                                     .withDatabaseName("Samic-db")
                                                                                     .withCreateContainerCmdModifier(cmd -> {
                                                                                         cmd.withName("Samic_postgres");
                                                                                         cmd.withHostConfig(new HostConfig().withPortBindings(new PortBinding(Ports.Binding.bindPort(localPort), new ExposedPort(5432))));
                                                                                     })
                                                                                     .withReuse(true);

    }

    public static void main(String[] args){
        SpringApplication.from(Sj2324SeedprojectApplication::main)
                         .with(TestMainApplication.class)
                         .run(args);
    }

}
package at.spengergasse.sj2324seedproject;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestContainerConfiguration{

    //    @Bean
    //    @ServiceConnection
    //    OracleContainer oracleContainer() {
    //        return new OracleContainer(DockerImageName.parse("gvenzl/oracle-xe:21-slim-faststart"));
    //    }

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgreSQLContainer(){
        final int exposedPort = 5432;
        final int localPort   = 3333;
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16-alpine")).withExposedPorts(exposedPort)
                                                                                     .withPassword("name")
                                                                                     .withUsername("pq")
                                                                                     .withDatabaseName("Samic-test-db")
                                                                                     .withCreateContainerCmdModifier(cmd -> {
                                                                                         cmd.withName("Samic_postgres_test_db");
                                                                                         cmd.withHostConfig(new HostConfig().withPortBindings(new PortBinding(Ports.Binding.bindPort(localPort), new ExposedPort(5432))));
                                                                                     });
    }

}

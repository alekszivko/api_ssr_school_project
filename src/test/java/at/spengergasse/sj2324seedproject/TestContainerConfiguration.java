package at.spengergasse.sj2324seedproject;

<<<<<<< HEAD
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.springframework.boot.devtools.restart.RestartScope;
=======
>>>>>>> groupOf4Classes
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestContainerConfiguration {

    @Bean
    @ServiceConnection
    OracleContainer oracleContainer() {
        return new OracleContainer(DockerImageName.parse("gvenzl/oracle-xe:21-slim-faststart"));
    }
<<<<<<< HEAD
}
=======




    //Docker-support und Testcontainers(Framework), dient dazu -> Infrastruktur Komponenten in Docker Containern für die Tests Hochfahren kann.
    //Es wird die unten configurierte postgres variante heruntergeladen (postgres:16-apline) und gleichzeitig ein container gestartet.
//    @Bean
//    @ServiceConnection
//    PostgreSQLContainer<?> postgresContainer(){
//        final int exposedPortForContainer = 5432;
//        final int localPortForContainer   = 33333;
//        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16-alpine")).withExposedPorts(exposedPortForContainer)
//                       .withCreateContainerCmdModifier(cmd -> cmd.withHostConfig(
//                               new HostConfig().withPortBindings(new PortBinding(Ports.Binding.bindPort(localPortForContainer),
//                                                                                 new ExposedPort(exposedPortForContainer)
//                               ))));
//    }


}
>>>>>>> groupOf4Classes

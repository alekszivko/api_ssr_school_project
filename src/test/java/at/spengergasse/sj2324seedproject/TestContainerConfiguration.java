package at.spengergasse.sj2324seedproject;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestContainerConfiguration{

  @Bean
  @ServiceConnection
  PostgreSQLContainer<?> postgresContainer(){
    return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest")).withDatabaseName("samic")
        .withUsername("user")
        .withPassword("password")
        .withCreateContainerCmdModifier(cmd -> {
          cmd.withName("samic");
          cmd.withHostConfig(new HostConfig().withPortBindings(new PortBinding(Ports.Binding.bindPort(5432),
              new ExposedPort(5432)
          )));
        });
  }
}

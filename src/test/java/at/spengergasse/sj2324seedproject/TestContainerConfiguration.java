package at.spengergasse.sj2324seedproject;

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

}

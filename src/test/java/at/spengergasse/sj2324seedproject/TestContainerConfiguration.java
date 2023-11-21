package at.spengergasse.sj2324seedproject;

import com.zaxxer.hikari.HikariDataSource;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.OracleContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestContainerConfiguration {

/*    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgreSQLContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16-alpine"))
                .withUsername("system")
                .withPassword("oracle")
                .withExposedPorts(5432);
    }*/


    @Bean
    @ServiceConnection
    OracleContainer oracleContainer() {
        return new OracleContainer(DockerImageName.parse("gvenzl/oracle-xe:21-slim-faststart"))
                .withUsername("oracle")
                .withPassword("oracle")
                .withExposedPorts(1521);
    }
}

package at.spengergasse.sj2324seedproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class WebConfig {


  @Bean
  public RestClient httpCustomerData(RestClient.Builder builder,
      @Value("${httpCustomerData.uri}") String customerDataUri) {
    return builder.baseUrl(customerDataUri)
        .requestFactory(new JdkClientHttpRequestFactory())
        .build();
  }
}

package at.spengergasse.sj2324seedproject.service.connector;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import at.spengergasse.sj2324seedproject.config.WebConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestClient;

@RestClientTest({CustomerDataClient.class, WebConfig.class})
class CustomerDataClientTest {

  @Autowired
  private CustomerDataClient customerDataClient;

  @Test
  void ensureRetrieveCustomerDataReturnsValue() {
    var retrievedData = customerDataClient.retrieveCustomerData("123");

    assertThat(retrievedData).isNotEmpty();
    assertThat(retrievedData.get().id()).isEqualTo("123");
  }

}
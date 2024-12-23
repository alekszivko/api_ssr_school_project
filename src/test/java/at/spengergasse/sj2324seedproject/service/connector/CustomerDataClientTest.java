package at.spengergasse.sj2324seedproject.service.connector;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
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
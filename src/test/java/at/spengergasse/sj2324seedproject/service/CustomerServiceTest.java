package at.spengergasse.sj2324seedproject.service;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.Mockito.when;

import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import at.spengergasse.sj2324seedproject.service.connector.CustomerDataClient;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

  private CustomerService customerService;

  private @Mock CustomerDataClient customerDataClient;

  @BeforeEach
  void setup() {
    assumeThat(customerDataClient).isNotNull();
    this.customerService = new CustomerService(customerDataClient);
  }

  @Test
  void ensureRetrieveCustomerDataWithExistingCustomerWorks() {
    //given
    var customer = FixtureFactory.customerFixture();
    when(customerDataClient.retrieveCustomerData(customer.connectionNo())).thenReturn(
        Optional.of(FixtureFactory.customerDTOFixture(customer.connectionNo())));

    //when
    customerDataClient.retrieveCustomerData(customer.connectionNo());

    //then
    assertThat(customerService.retrieveCustomerData(customer.connectionNo())).isNotEmpty();
    assertThat(customerService.retrieveCustomerData(customer.connectionNo()).get().id()).isEqualTo(
        customer.connectionNo());
  }

  @Test
  void ensureRetrieveCustomerDataWithNonExistingCustomerWorks() {
    //given
    var customer = FixtureFactory.customerFixture();
    when(customerDataClient.retrieveCustomerData(customer.connectionNo())).thenReturn(
        Optional.empty());

    //when
    customerDataClient.retrieveCustomerData(customer.connectionNo());

    //then
    assertThat(customerService.retrieveCustomerData(customer.connectionNo())).isEmpty();
  }

}
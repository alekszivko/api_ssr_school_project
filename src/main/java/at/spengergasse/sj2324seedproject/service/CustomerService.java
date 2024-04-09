package at.spengergasse.sj2324seedproject.service;


import at.spengergasse.sj2324seedproject.presentation.api.dtos.CustomerDTO;
import at.spengergasse.sj2324seedproject.service.connector.CustomerDataClient;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {

  private final CustomerDataClient customerDataClient;


  public Optional<CustomerDTO> retrieveCustomerData(String customerId) {
    return customerDataClient.retrieveCustomerData(customerId);
  }
}

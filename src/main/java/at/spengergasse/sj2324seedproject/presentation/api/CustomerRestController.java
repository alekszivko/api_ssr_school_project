package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.presentation.api.dtos.CustomerDTO;
import at.spengergasse.sj2324seedproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping(CustomerRestController.BASE_URL)
public class CustomerRestController {

  protected static final String BASE_URL = "/api/customers";

  private final CustomerService customerService;


  @GetMapping
  public ResponseEntity<CustomerDTO> fetchCustomerData(
      @RequestParam String connectionNo) {
    if (connectionNo == null) {
      return ResponseEntity.badRequest().build();
    } else {
      return customerService.retrieveCustomerData(connectionNo)
          .map(ResponseEntity::ok)
          .orElseGet(() -> ResponseEntity.notFound().build());
    }
  }
}

package at.spengergasse.sj2324seedproject.service.connector;

import at.spengergasse.sj2324seedproject.presentation.api.dtos.CustomerDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j

@Component
public class CustomerDataClient{

  private final RestClient httpCustomerData;


  //TODO remove get request body, is only for demo purposes (API returns what it gets in the
  // request body)
  //TODO connect to API that returns dynamic/"real" Customer data
  public Optional<CustomerDTO> retrieveCustomerData(String customerId) {
    log.debug("Retrieving customer data");

    Map<String, Object> customerResp = httpCustomerData.method(HttpMethod.GET)
        .uri("/anything/{id}", customerId)
        .contentType(MediaType.APPLICATION_JSON)
        .body(serializeCustomerDto(customerId))
        .retrieve().toEntity(
            new ParameterizedTypeReference<Map<String, Object>>() {
            }).getBody();
    try {
      return
          Optional.of(new ObjectMapper().readValue(customerResp.get("data").toString(),
              CustomerDTO.class));
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }


  //TODO remove when connected to real API
  private String serializeCustomerDto(String customerId) {
    var mapper =
        new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)
            .registerModule(new JavaTimeModule());

    try {
      return mapper.writeValueAsString(CustomerDTO.builder()
          .id(customerId)
          .firstName("John")
          .lastName("Doe")
          .dateOfBirth("01.01.1970")
          .address("Main Street 1")
          .country("USA")
          .city("New York")
          .zipCode("12345")
          .phoneNumber("123456789")
          .email("randomEmail@randomEmail.com")
          .build());
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Could not serialize CustomerDTO to JSON.", e);
    }
  }


}


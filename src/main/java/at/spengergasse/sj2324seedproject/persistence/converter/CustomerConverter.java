package at.spengergasse.sj2324seedproject.persistence.converter;

import at.spengergasse.sj2324seedproject.domain.Customer;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Optional;

@Converter(autoApply = true)
public class CustomerConverter implements AttributeConverter<Customer, String> {

  @Override
  public String convertToDatabaseColumn(Customer customer) {
    return Optional.ofNullable(customer).map(c -> c.connectionNo()).orElse(null);
  }

  @Override
  public Customer convertToEntityAttribute(String dbCustomer) {
    return Optional.of(dbCustomer).map(dbC -> Customer.builder().connectionNo(dbCustomer).build())
        .orElse(null);
  }
}

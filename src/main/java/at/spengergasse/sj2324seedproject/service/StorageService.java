package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.domain.Address;
import at.spengergasse.sj2324seedproject.domain.Storage;
import at.spengergasse.sj2324seedproject.persistence.StorageRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor

@Service
@Transactional
public class StorageService {

  private final StorageRepository repository;

  public List<Storage> fetchStorage(Optional<String> namePart) {
    return namePart.map(repository::findAllByNameContainingIgnoreCase)
        .orElseGet(repository::findAll);
  }

  @Transactional
  public void createStorage(String name, String street, Integer number,
      String addressAddition, Integer zipcode, String city) {
    repository.save(Storage.builder()
        .name(name)
        .address(Address.builder()
            .street(street)
            .number(number)
            .addressAddition(addressAddition)
            .zipcode(zipcode)
            .city(city).build())
        .build());

  }

  public Optional<Storage> getStorageById(Long id) {
    return repository.findById(id);
  }

  public void removeStorage(Long id) {
    repository.deleteById(id);
  }

  @Transactional
  public void updateStorage(Long id, String name, String adressadition, String street,
      Integer number,
      Integer zipcode,
      String city) {

    repository.findById(id).map(st -> {
      st.setName(name);
      st.setAddress(Address.builder()
          .city(city)
          .zipcode(zipcode)
          .addressAddition(adressadition)
          .street(street)
          .number(number)
          .build());
      return st;
    });


  }
}

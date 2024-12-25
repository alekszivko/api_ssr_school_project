package at.spengergasse.sj2324seedproject.persistence;


import static org.assertj.core.api.Assertions.assertThat;

import at.spengergasse.sj2324seedproject.domain.Address;
import at.spengergasse.sj2324seedproject.domain.Storage;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class StorageRepositoryTest {

  @Autowired
  private StorageRepository storageRepository;


  @Test
  void ensureSaveAndReReadWorks() {

    //Given
    Storage storageGiven = FixtureFactory.storageFixture();

    //When
    var saved = storageRepository.save(storageGiven);

    //Then
    assertThat(saved).isNotNull().isSameAs(storageGiven);
    assertThat(saved.getId()).isNotNull();
    assertThat(storageGiven.getAddress()).isEqualTo((saved.getAddress()));

  }


  @Test
  void ensureFindAllByNameContainingIgnoreCaseWorks() {

    //Given
    Storage storage1 = FixtureFactory.storageFixture();
    storage1.setName("test1");
    Storage storage2 = FixtureFactory.storageFixture();

    storageRepository.saveAll(List.of(storage1, storage2));

    //When
    List<Storage> found = storageRepository.findAllByNameContainingIgnoreCase(storage1.getName());

    //Then
    assertThat(found).containsExactly(storage1);


  }

}
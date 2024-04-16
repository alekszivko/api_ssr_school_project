package at.spengergasse.sj2324seedproject.fixture;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import at.spengergasse.sj2324seedproject.domain.Address;
import at.spengergasse.sj2324seedproject.domain.Customer;
import at.spengergasse.sj2324seedproject.domain.Producer;
import at.spengergasse.sj2324seedproject.domain.Profile;
import at.spengergasse.sj2324seedproject.domain.Reservation;
import at.spengergasse.sj2324seedproject.domain.Role;
import at.spengergasse.sj2324seedproject.domain.SfpType;
import at.spengergasse.sj2324seedproject.domain.Storage;
import at.spengergasse.sj2324seedproject.domain.StorageObject;
import at.spengergasse.sj2324seedproject.domain.StorageObjectMeta;
import at.spengergasse.sj2324seedproject.domain.Type;
import at.spengergasse.sj2324seedproject.domain.User;
import at.spengergasse.sj2324seedproject.foundation.ApiKeyGenerator;
import at.spengergasse.sj2324seedproject.presentation.api.dtos.CustomerDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FixtureFactory {

  private static final ApiKeyGenerator keyGen = new ApiKeyGenerator();

  ///////////////////////////////////// Producer


  public static Producer give_me_a_producer1() {
    return Producer.builder()
        .shortname("MS")
        .name("Micro Soft")
        .build();
  }

  public static Producer give_me_a_producer2() {
    return Producer.builder()
        .shortname("IBM")
        .name("Internationale Bekleidungs Maschinenhersteller")
        .build();
  }

  ///////////////////////////////////// StorageObjectMeta

  public static StorageObjectMeta give_me_a_storageObjectMeta1() {
    return StorageObjectMeta.builder()
        .producer(give_me_a_producer1())
        .name("meta name1")
        .type(Type.IP_PHONE)
        .osVersion("version1")
        .consumablesPerBox(2)
        .sfpType(SfpType.MM)
        .wavelength("1550nm")
        .interfacespeed("100-Mbps")
        .build();
  }

  public static StorageObjectMeta give_me_a_storageObjectMeta2() {
    return StorageObjectMeta.builder()
        .producer(give_me_a_producer2())
        .name("meta name2")
        .type(Type.IP_PHONE)
        .osVersion("version2")
        .consumablesPerBox(2)
        .sfpType(SfpType.MM)
        .wavelength("1310nm")
        .interfacespeed("1000-Mbps")
        .build();
  }

  public static StorageObjectMeta give_me_a_storageObjectMeta3() {
    return StorageObjectMeta.builder()
        .name("meta name2")
        //                                .type(Type.IP_PHONE)
        .osVersion("version2")
        //                                .consumablesPerBox(2)
        //                                .sfpType(SfpType.MM)
        //                                .wavelength("1310nm")
        //                                .interfacespeed("1000-Mbps")
        .build();
  }

  public static List<Producer> give_me_a_List_of_producer() {
    List<Producer> producersListe = new ArrayList<>();
    producersListe.add(give_me_a_producer1());
    producersListe.add(give_me_a_producer2());
    return producersListe;
  }

  ///////////////////////////////////// StorageObject

  public static StorageObject give_me_a_storageObject1() {
    return StorageObject.builder()
        .serialNumber("abcd1234")
        .macAddress(ConstantsDomain.DEFAULT_MAC)
        .remark("this is a remark1")
        .projectDevice(true)
        .storedAtCustomer(Customer.builder()
            .connectionNo("123456")
            .build())
        .build();
  }

  public static StorageObject give_me_a_storageObject2() {
    return StorageObject.builder()
        .serialNumber("abcd1234")
        .macAddress(ConstantsDomain.DEFAULT_MAC)
        .remark("this is a remark2")
        .projectDevice(true)
        .storedAtCustomer(Customer.builder()
            .connectionNo("sd123")
            .build())
        .build();
  }

  // User - Profile - Reservation - Customer fixtures

  // User - Profile - Reservation - Customer fixtures

  public static User userFixture() {
    return User.builder()
        .userId("U123456789")
        .email("alex@alex.de")
        .password("testpassword")
        .role(Role.ORDERFULLFILLMENT)
        .createdAt(LocalDateTime.now())
        .lastLogin(LocalDateTime.now())
        .isActivated(true)
        .profile(profileFixture())
        .build();
  }


  public static Profile profileFixture() {
    return Profile.builder()
        .username("Alex")
        .firstName("Alex")
        .lastName("Alex")
        .phone("+436991234567")
        .build();
  }

  public static Customer customerFixture() {
    return Customer.builder()
        .connectionNo("1231201310")
        .build();
  }

  public static Reservation reservationFixture(User user) {
    return Reservation.builder()
        .reservedBy(user)
        .reservationId(keyGen.getRandomKey(10))
        .reservationDescription("Testdescription")
        .lastModified(LocalDateTime.now())
        .reservedAt(LocalDateTime.now())
        .reservedFor(customerFixture())
        .completed(false)
        .build();
  }


  public static Storage storageFixture() {
    return Storage.builder()
        .name("Hauptlager DCE4")
        .address(addressFixture())
        .build();

  }

  public static Address addressFixture() {
    return Address.builder()
        .street("Kreuzgasse")
        .number(55)
        .addressAddition("EG")
        .zipcode(1180)
        .city("Wien")
        .build();
  }

  public static Reservation reservationFixture() {
    return Reservation.builder()
        .reservedBy(userFixture())
        .reservationId(keyGen.getRandomKey(10))
        .reservationDescription("Testdescription")
        .lastModified(LocalDateTime.now())
        .reservedAt(LocalDateTime.now())
        .reservedFor(customerFixture())
        .completed(true)
        .build();
  }

  public static CustomerDTO customerDTOFixture(String id) {
    return CustomerDTO.builder()
        .id(id)
        .firstName("John")
        .lastName("Doe")
        .dateOfBirth("01.01.1970")
        .address("Main Street 1")
        .country("USA")
        .city("New York")
        .zipCode("12345")
        .phoneNumber("123456789")
        .email("randomEmail@randomEmail.com")
        .build();
  }

//    public static StorageObjectMeta give_me_a_storageObject1(){
//
//      return  StorageObjectMeta.builder().producer(give_me_a_List_of_producer())
//                .type(Type.IP_PHONE)
//                .name("name des StorageObjects1")
//                .osVersion("beste1")
//                .consumablesPerBox(2)
//                .wavelength("ganzklein1")
//                .interfacespeed("schnellste1")
//                .build();
//    }
//    public static StorageObjectMeta give_me_a_storageObject2(){
//
//      return  StorageObjectMeta.builder().producer(give_me_a_List_of_producer())
//                .type(Type.ROUTER)
//                .name("name des StorageObjects2")
//                .osVersion("beste32")
//                .consumablesPerBox(2)
//                .wavelength("ganzklein2")
//                .interfacespeed("schnellste2")
//                .build();
//    }
//    public static StorageObjectMeta give_me_a_storageObject3(){
//
//      return  StorageObjectMeta.builder().producer(give_me_a_List_of_producer())
//                .type(Type.SFP)
//                .name("name des StorageObjects3")
//                .osVersion("beste3")
//                .consumablesPerBox(2)
//                .wavelength("ganzklein3")
//                .interfacespeed("schnellste3")
//                .build();
//    }
//
//    public static StorageObject give_me_a_storageObject4(){
//        return StorageObject.builder()
//
//                       .build();
//    }
//
//
//
//    public static Producer  give_me_a_producer1(){
//        return Producer.builder().shortname("kurzer Name1")
//                       .name("langer name1")
//                       .build();
//    }
//    public static Producer  give_me_a_producer2(){
//        return Producer.builder().shortname("kurzer Name2")
//                       .name("langer name2")
//                       .build();
//    }
//    public static Producer  give_me_a_producer3(){
//        return Producer.builder().shortname("kurzer Name3")
//                       .name("langer name3")
//                       .build();
//    }
//
//    public static List<Producer> give_me_a_List_of_producer(){
//        List<Producer> producersListe = new ArrayList<>();
//         producersListe.add(give_me_a_producer1());
//         producersListe.add(give_me_a_producer2());
//         producersListe.add(give_me_a_producer3());
//
//
//        return producersListe;
//    }
//
//    public static List<StorageObjectMeta> give_me_a_storageObjectMete_List(){
//        List<StorageObjectMeta> storageObjectMetaList = new ArrayList<>();
//        storageObjectMetaList.add(give_me_a_storageObject1());
//        storageObjectMetaList.add(give_me_a_storageObject2());
//        storageObjectMetaList.add(give_me_a_storageObject3());
//        return storageObjectMetaList;
//    }


}

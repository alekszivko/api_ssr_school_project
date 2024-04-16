package at.spengergasse.sj2324seedproject.presentation.www.storages;

public record CreateStorageForm(String name, String street, Integer number,
                                String addressAddition, Integer zipcode, String city) {

  public static CreateStorageForm create() {
    return new CreateStorageForm("", "", 0, "", 0, "");
  }
}

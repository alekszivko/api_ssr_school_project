package at.spengergasse.sj2324seedproject.domain;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Getter
////@NoArgsConstructor
//@AllArgsConstructor //Error wenn erzeugt  -> java: Konstruktor Type() ist bereits in Enumeration at.spengergasse.sj23247abcif.domain.Type definiert
//public enum Type{
//
//    IP_PHONE("IP Phone", "IPP"),
//    ROUTER("Router", "Rt"),
//    SWITCH("Switch", "Sw"),
//    SFP("Sfp", "Sfp"),
//    CONSUMABLES("Consumables", "Cs");
//
//
//
//    private String longVersion;
//    private String shortVersion;

public enum Type {

    IP_PHONE,
    ROUTER,
    SWITCH,
    SFP,
    CONSUMABLES

}

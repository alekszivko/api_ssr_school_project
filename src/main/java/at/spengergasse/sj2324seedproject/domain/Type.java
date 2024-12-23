package at.spengergasse.sj2324seedproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type{

    IP_PHONE("IP Phone", "IPP"),
    ROUTER("Router", "Rt"),
    SWITCH("Switch", "Sw"),
    SFP("Sfp", "Sfp"),
    CONSUMABLES("Consumables", "Cs");

    final private String longVersion;
    final private String shortVersion;
}

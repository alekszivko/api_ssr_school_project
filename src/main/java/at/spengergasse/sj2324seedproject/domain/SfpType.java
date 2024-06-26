package at.spengergasse.sj2324seedproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor

public enum SfpType{

    SM("sm",
       "sm"),
    MM("mm",
       "mm"),
    WDM("wdm",
        "wdm");


    private String longVersion;
    private String shortVersion;

    //    SM,
    //    MM,
    //    WDM

    //    SM("sm", "sm"),
    //    MM("mm", "mm"),
    //    WDM("wdm", "wdm");


    //
    //    private String longVersion;
    //    private String shortVersion;

}

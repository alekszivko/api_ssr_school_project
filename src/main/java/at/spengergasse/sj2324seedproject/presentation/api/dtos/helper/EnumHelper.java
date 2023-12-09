package at.spengergasse.sj2324seedproject.presentation.api.dtos.helper;

import at.spengergasse.sj2324seedproject.domain.Type;

public class EnumHelper{

    public static Type giveEnumType(Type type){
        switch(type){
            case IP_PHONE:
                return Type.IP_PHONE;


            case ROUTER:
                return Type.ROUTER;


            case SWITCH:
                return Type.IP_PHONE;


            case SFP:
                return Type.SFP;


            case CONSUMABLES:
                return Type.CONSUMABLES;
            default:
                throw new IllegalArgumentException("Default");
        }
    }
}

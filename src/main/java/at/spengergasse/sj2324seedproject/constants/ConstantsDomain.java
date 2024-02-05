package at.spengergasse.sj2324seedproject.constants;

public class ConstantsDomain{

    public static final int OBJECTNAME_LENGTH         = 64;
    public static final int DEFAULT_LENGTH            = 55;
    public static final int MAC_LENGTH_WITH_HYPHEN    = 17;
    public static final int MAC_LENGTH_WITHOUT_HYPHEN = 12;

    public static final String DEFAULT_VALUE              = "--default string--";
    public static final String DEFAULT_MAC                = "ff-ff-ff-ff-ff-ff";
    public static final String DEFAULT_MAC_GROUP          = "01-00-5e-11-22-33";
    public static final String URL_BASE_PRODUCER          = "/api/producer";
    public static final String URI_ID                     = "/{id}";
    public static final String URI_SHORTNAME              = "/{delShortname}";
    public static final String URI_BASE_STORAGEOBJECT     = "/api/storageObjects";
    public static final String URI_BASE_STORAGEOBJECT_MAC = "/{mac}";
    public static final String URL_BASE_STO_META          = "/api/storageObjectMeta";
}

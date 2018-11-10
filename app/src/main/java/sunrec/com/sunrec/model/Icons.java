package sunrec.com.sunrec.model;

/**
 * Created by Ricardo Silva on 10/11/2018.
 */
public enum Icons {

    TRASH("trash_icon", 1,  "LIXO ACUMULADO"), FLOODING("flooding_icon", 1, "ALAGAMENTO"),HOLE("hole_icon",1,"BURACO")
    ,SEWER("sewer_icon",1,"ESGOTO") ;

    private String iconName;
    private String description;
    private Integer level;

    Icons(String name, Integer level, String description){
        this.iconName = name;
        this.level = level;
        this.description = description;
    }

    public String getIconName() {
        return iconName + "_" + getLevel().toString() + ".png";
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }
}

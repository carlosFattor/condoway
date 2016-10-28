package models.general;

/**
 * Created by Carlos on 10/12/2016.
 */
public enum Roles {
    ADMIN("ADMIN"),
    CONDOMINIUM("CONDOMINIUM"),
    DOORKEEPER("DOORKEEPER"),
    PARTINER("PARTINER");


    private final String label;

    private Roles(String label){
        this.label = label;
    }

    public String toString() {
        return this.label;
    }
}

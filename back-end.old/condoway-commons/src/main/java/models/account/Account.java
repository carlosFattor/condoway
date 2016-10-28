package models.account;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import models.general.Profile;
import models.general.Roles;

import java.util.List;
import java.util.UUID;

/**
 * Created by Carlos on 10/12/2016.
 */
@DataObject(generateConverter = true)
public class Account {

    private String userID = UUID.randomUUID().toString();
    private List<Profile> profiles;
    private List<Roles> roles;

    public Account() {
    }

    public Account(Account account) {
        this.profiles = account.profiles;
        this.roles = account.roles;
    }

    public Account(JsonObject user) {
        AccountConverter.from(user, this);
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        AccountConverter.toJson(this, json);
        return json;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return this.toJson().encodePrettily();
    }
}

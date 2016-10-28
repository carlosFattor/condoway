package com.condoway.account;

import com.condoway.account.general.Address;
import com.condoway.account.general.Profile;
import com.condoway.account.general.Roles;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.List;

/**
 * Created by Carlos on 10/16/2016.
 */
@DataObject(generateConverter = true)
public class Account {

    private String id;

    List<Profile> profiles;
    Address address;
    List<Roles> roles;

    public Account() {
    }

    public Account(JsonObject json) {
        AccountConverter.fromJson(json, this);
    }

    public JsonObject toJson(){
        JsonObject json = new JsonObject();
        AccountConverter.toJson(this, json);
        return json;
    }

    public String getId() {
        return id;
    }

    public Account setId(String id) {
        this.id = id;
        return this;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public Account setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Account setAddress(Address address) {
        this.address = address;
        return this;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public Account setRoles(List<Roles> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public String toString() {
        return toJson().encodePrettily();
    }
}

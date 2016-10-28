package com.condoway.account.general;

/**
 * Created by Carlos on 10/12/2016.
 */
public abstract class LoginInfo {
    private String providerID;
    private String providerKey;

    public LoginInfo(String providerID, String providerKey) {
        this.providerID = providerID;
        this.providerKey = providerKey;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getProviderKey() {
        return providerKey;
    }

    public void setProviderKey(String providerKey) {
        this.providerKey = providerKey;
    }
}

package models.general;

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

    public String getProviderKey() {
        return providerKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginInfo loginInfo = (LoginInfo) o;

        if (providerID != null ? !providerID.equals(loginInfo.providerID) : loginInfo.providerID != null) return false;
        return !(providerKey != null ? !providerKey.equals(loginInfo.providerKey) : loginInfo.providerKey != null);

    }

    @Override
    public int hashCode() {
        int result = providerID != null ? providerID.hashCode() : 0;
        result = 31 * result + (providerKey != null ? providerKey.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "providerID='" + providerID + '\'' +
                ", providerKey='" + providerKey + '\'' +
                '}';
    }
}

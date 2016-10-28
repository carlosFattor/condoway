package models.general;

/**
 * Created by Carlos on 10/12/2016.
 */
public class Profile {
    private LoginInfo loginInfo;
    private String email;
    private String firstName;
    private String lastName;
    private String fullName;
    private String avatarUrl;
    private Long created;
    private String gender;
    private Long birthday;


    public Profile() {
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        if (loginInfo != null ? !loginInfo.equals(profile.loginInfo) : profile.loginInfo != null) return false;
        if (email != null ? !email.equals(profile.email) : profile.email != null) return false;
        if (firstName != null ? !firstName.equals(profile.firstName) : profile.firstName != null) return false;
        if (lastName != null ? !lastName.equals(profile.lastName) : profile.lastName != null) return false;
        if (fullName != null ? !fullName.equals(profile.fullName) : profile.fullName != null) return false;
        if (avatarUrl != null ? !avatarUrl.equals(profile.avatarUrl) : profile.avatarUrl != null) return false;
        if (created != null ? !created.equals(profile.created) : profile.created != null) return false;
        if (gender != null ? !gender.equals(profile.gender) : profile.gender != null) return false;
        return !(birthday != null ? !birthday.equals(profile.birthday) : profile.birthday != null);

    }

    @Override
    public int hashCode() {
        int result = loginInfo != null ? loginInfo.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (avatarUrl != null ? avatarUrl.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "loginInfo=" + loginInfo +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", created=" + created +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}

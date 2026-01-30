package model;

public class UserData {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String zipcode;
    private boolean active;

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getZipcode() { return zipcode; }
    public boolean isActive() { return active; }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }
    public void setActive(boolean active) { this.active = active; }
}

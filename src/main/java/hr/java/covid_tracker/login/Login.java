package hr.java.covid_tracker.login;

import java.util.Objects;

public class Login {

    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private Type role;

    public Login(Long id, String firstname, String lastname, String username, String password, Type role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Type getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;
        Login login = (Login) o;
        return id.equals(login.id) && firstname.equals(login.firstname) && lastname.equals(login.lastname) && username.equals(login.username) && password.equals(login.password) && role.equals(login.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, username, password, role);
    }
}

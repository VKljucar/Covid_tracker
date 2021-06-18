package hr.java.covid_tracker.login;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class LoginDTO {

    private int id;
    private String ime;
    private String prezime;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private Set<String> authorities;

    public LoginDTO() {
    }

    public LoginDTO(String korisnickoIme, String lozinka) {
        this.username = korisnickoIme;
        this.password = lozinka;
    }

    public LoginDTO(Login login){
        this.username = login.getKorisnickoIme();
        this.password = login.getLozinka();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString(){
        return "LoginDTO{"+
                "username='" + username + '\'' +
                ", password=" + password + '\'' +
                '}';
    }

}

package hr.java.covid_tracker.login;

import java.util.Objects;

public class Login {

    private Long id;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private Type uloga;

    public Login(Long id, String ime, String prezime, String korisnickoIme, String lozinka, Type uloga) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.uloga = uloga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public Type getUloga() {
        return uloga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;
        Login login = (Login) o;
        return id.equals(login.id) && ime.equals(login.ime) && prezime.equals(login.prezime) && korisnickoIme.equals(login.korisnickoIme) && lozinka.equals(login.lozinka) && uloga.equals(login.uloga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime, korisnickoIme, lozinka, uloga);
    }
}

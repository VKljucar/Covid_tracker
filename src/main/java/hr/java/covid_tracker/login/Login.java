package hr.java.covid_tracker.login;
import hr.java.covid_tracker.novozarazeni.Novozarazeni;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "KORISNICI")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String ime;
    private String prezime;

    @Column(name = "KORISNICKO_IME")
    private String korisnickoIme;

    private String lozinka;

    @Enumerated(EnumType.STRING)
    private Type uloga;

    @OneToMany(mappedBy = "login")
    private List<Novozarazeni> novozarazeni;

    public Login() {
    }

    public Login(int id, String ime, String prezime, String korisnickoIme, String lozinka, Type uloga) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.uloga = uloga;
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
        return korisnickoIme.equals(login.korisnickoIme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(korisnickoIme);
    }
}

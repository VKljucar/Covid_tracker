package hr.java.covid_tracker.cijepljeni;

import hr.java.covid_tracker.login.Login;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Cijepljeni {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int cijepljeniID;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int osobaID;

    private String ime;
    private String prezime;
    private String datRodenja;
    private String adresa;
    private String telefon;
    private String email;
    private Date datumCijepljenja;
    private int cijepivoID;


    @ManyToMany(targetEntity = Cijepljeni.class)
    @JoinTable(
            name = "cijepljeni",
            joinColumns = {@JoinColumn(name = "osoba_id")},
            inverseJoinColumns = {@JoinColumn(name = "osobaID")}
    )

    private List<Cijepljeni> cijepljeni;

    public Cijepljeni() {
    }

    public Cijepljeni(int cijepljeniID, int osobaID, String ime, String prezime, String datRodenja, String adresa, String telefon, String email, Date datumCijepljenja, int cijepivoID) {
        this.cijepljeniID = cijepljeniID;
        this.osobaID = osobaID;
        this.ime = ime;
        this.prezime = prezime;
        this.datRodenja = datRodenja;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
        this.datumCijepljenja = datumCijepljenja;
        this.cijepivoID = cijepivoID;
    }

    public Cijepljeni(CijepljeniCommand cijepljeniCommand){
        this.ime = cijepljeniCommand.getIme();
        this.prezime = cijepljeniCommand.getPrezime();
        this.datRodenja = cijepljeniCommand.getDatRodenja();
        this.adresa = cijepljeniCommand.getAdresa();
        this.telefon = cijepljeniCommand.getTelefon();
        this.email = cijepljeniCommand.getEmail();
        this.datumCijepljenja = cijepljeniCommand.getDatumCijepljenja();
        this.cijepivoID = cijepljeniCommand.getCijepivoID();
    }

    public int getCijepljeniID() {
        return cijepljeniID;
    }

    public int getOsobaID() {
        return osobaID;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getDatRodenja() {
        return datRodenja;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setCijepljeniID(int cijepljeniID) {
        this.cijepljeniID = cijepljeniID;
    }

    public void setOsobaID(int osobaID) {
        this.osobaID = osobaID;
    }

    public String getEmail() {
        return email;
    }

    public Date getDatumCijepljenja() {
        return datumCijepljenja;
    }

    public int getCijepivoID() {
        return cijepivoID;
    }

    public List<Cijepljeni> getCijepljeni() {
        return cijepljeni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cijepljeni)) return false;
        Cijepljeni that = (Cijepljeni) o;
        return getCijepljeniID() == that.getCijepljeniID() && getOsobaID() == that.getOsobaID() && getCijepivoID() == that.getCijepivoID() && Objects.equals(getIme(), that.getIme()) && Objects.equals(getPrezime(), that.getPrezime()) && Objects.equals(getDatRodenja(), that.getDatRodenja()) && Objects.equals(getAdresa(), that.getAdresa()) && Objects.equals(getTelefon(), that.getTelefon()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getDatumCijepljenja(), that.getDatumCijepljenja()) && Objects.equals(getCijepljeni(), that.getCijepljeni());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cijepljeniID, osobaID, ime, prezime, datRodenja, adresa, telefon, email, datumCijepljenja, cijepivoID);
    }
}

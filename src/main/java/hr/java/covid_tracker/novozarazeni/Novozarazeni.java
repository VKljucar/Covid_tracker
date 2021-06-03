package hr.java.covid_tracker.novozarazeni;

import hr.java.covid_tracker.login.Login;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "OBOLJELI")
public class Novozarazeni {

    @Id
    @Column(name = "OBOLJELI_ID")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int oboljeliId;

    @Column(name = "OSOBA_ID")
    private int osobaId;

    private String ime;
    private String prezime;

    @Column(name = "DAT_RODENJA")
    private String datRodenja;

    private String adresa;
    private String telefon;
    private String email;
    private String hospitaliziran;
    private int lokacija;


    @ManyToMany(targetEntity = Login.class)
    @JoinTable(
            name = "korisnici",
            joinColumns = {@JoinColumn(name = "osoba_id")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
    private List<Login> login;

    public Novozarazeni() {
    }

    public Novozarazeni(int oboljeliId, int osobaId, String ime, String prezime, String datRodenja, String adresa, String telefon, String email, String hospitaliziran, int lokacija) {
        this.oboljeliId = oboljeliId;
        this.osobaId = osobaId;
        this.ime = ime;
        this.prezime = prezime;
        this.datRodenja = datRodenja;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
        this.hospitaliziran = hospitaliziran;
        this.lokacija = lokacija;
    }

    public Novozarazeni(NovozarazeniCommand novozarazeniCommand){
        this.osobaId = novozarazeniCommand.getOsobaId();
        this.ime = novozarazeniCommand.getIme();
        this.prezime = novozarazeniCommand.getPrezime();
        this.datRodenja = novozarazeniCommand.getDatRodenja();
        this.adresa = novozarazeniCommand.getAdresa();
        this.telefon = novozarazeniCommand.getTelefon();
        this.email = novozarazeniCommand.getEmail();
        this.hospitaliziran = novozarazeniCommand.getHospitaliziran();
        this.lokacija = novozarazeniCommand.getLokacija();
    }

    public int getOboljeliId() {
        return oboljeliId;
    }

    public void setOboljeliId(int oboljeliId) {
        this.oboljeliId = oboljeliId;
    }

    public int getOsobaId() {
        return osobaId;
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

    public String getEmail() {
        return email;
    }

    public String getHospitaliziran() {
        return hospitaliziran;
    }

    public int getLokacija() {
        return lokacija;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Novozarazeni)) return false;
        Novozarazeni that = (Novozarazeni) o;
        return ime.equals(that.ime) && prezime.equals(that.prezime) && datRodenja.equals(that.datRodenja) && adresa.equals(that.adresa) && telefon.equals(that.telefon) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oboljeliId, osobaId, ime, prezime, datRodenja, adresa, telefon, email);
    }

}

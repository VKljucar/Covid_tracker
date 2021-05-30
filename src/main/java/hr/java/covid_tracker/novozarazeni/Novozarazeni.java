package hr.java.covid_tracker.novozarazeni;

import hr.java.covid_tracker.login.Login;

import java.util.Objects;

public class Novozarazeni {

    private Long oboljeliId;
    private Long osobaId;
    private String ime;
    private String prezime;
    private String datRodenja;
    private String adresa;
    private String telefon;
    private String email;
    private String hospitaliziran;
    private Long lokacija;

    private Login login;

    public Novozarazeni(Long oboljeliId, Long osobaId, String ime, String prezime, String datRodenja, String adresa, String telefon, String email, String hospitaliziran, Long lokacija) {
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
        this.hospitaliziran = novozarazeniCommand.getHospitalizirani();
        this.lokacija = novozarazeniCommand.getLokacija();
    }

    public Long getOboljeliId() {
        return oboljeliId;
    }

    public void setOboljeliId(Long oboljeliId) {
        this.oboljeliId = oboljeliId;
    }

    public Long getOsobaId() {
        return osobaId;
    }

    public void setOsobaId(Long osobaId) {
        this.osobaId = osobaId;
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

    public String getDatRodenja() {
        return datRodenja;
    }

    public void setDatRodenja(String datRodenja) {
        this.datRodenja = datRodenja;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHospitaliziran() {
        return hospitaliziran;
    }

    public void setHospitaliziran(String hospitaliziran) {
        this.hospitaliziran = hospitaliziran;
    }

    public Long getLokacija() {
        return lokacija;
    }

    public void setLokacija(Long lokacija) {
        this.lokacija = lokacija;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Novozarazeni)) return false;
        Novozarazeni that = (Novozarazeni) o;
        return oboljeliId.equals(that.oboljeliId) && osobaId.equals(that.osobaId) && ime.equals(that.ime) && prezime.equals(that.prezime) && datRodenja.equals(that.datRodenja) && adresa.equals(that.adresa) && telefon.equals(that.telefon) && email.equals(that.email) && hospitaliziran.equals(that.hospitaliziran) && lokacija.equals(that.lokacija);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oboljeliId, osobaId, ime, prezime, datRodenja, adresa, telefon, email, hospitaliziran, lokacija);
    }
}

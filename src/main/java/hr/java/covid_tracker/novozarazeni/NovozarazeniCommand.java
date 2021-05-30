package hr.java.covid_tracker.novozarazeni;

import javax.validation.constraints.*;

public class NovozarazeniCommand {

    @NotNull(message = "Ime ne smije biti prazno")
    private String ime;

    @NotNull(message = "Ime ne smije biti prazno")
    private String prezime;

    @NotNull(message = "Ime ne smije biti prazno")
    private String datRodenja;

    @NotNull(message = "Ime ne smije biti prazno")
    private String adresa;

    @NotNull(message = "Ime ne smije biti prazno")
    private String telefon;

    @NotNull(message = "Ime ne smije biti prazno")
    private String email;

    private String hospitalizirani;
    private Long lokacija;
    private Long osobaId;

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

    public String getHospitalizirani() {
        return hospitalizirani;
    }

    public Long getLokacija() {
        return lokacija;
    }

    public Long getOsobaId() {
        return osobaId;
    }
}

package hr.java.covid_tracker.novozarazeni;

import javax.validation.constraints.*;

public class NovozarazeniCommand {

    @NotBlank(message = "Ime ne smije biti prazno")
    private String ime;

    @NotBlank(message = "Prezime ne smije biti prazno")
    private String prezime;

    @NotNull(message = "Datum rodenja ne smije biti prazno")
    private String datRodenja;

    @NotBlank(message = "Adresa ne smije biti prazno")
    private String adresa;

    @NotNull(message = "Telefon ne smije biti prazno")
    private String telefon;

    @NotBlank(message = "Email ne smije biti prazno")
    private String email;

    private String hospitaliziran;

    private int lokacija;

    @NotNull(message = "Osoba ne smije biti prazno")
    private int osobaId;

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

    public int getOsobaId() {
        return osobaId;
    }
}

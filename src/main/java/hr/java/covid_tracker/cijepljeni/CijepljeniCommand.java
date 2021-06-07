package hr.java.covid_tracker.cijepljeni;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CijepljeniCommand {

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

    @NotBlank(message = "DatumCijepljenja ne smije biti prazno")
    private Date datumCijepljenja;

    @NotBlank(message = "CijepivoID ne smije biti prazno")
    private int cijepivoID;

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

    public Date getDatumCijepljenja() {
        return datumCijepljenja;
    }

    public int getCijepivoID() {
        return cijepivoID;
    }
}
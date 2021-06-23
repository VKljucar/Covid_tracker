package hr.java.covid_tracker.novozarazeni;

public class NovozarazeniDTO {

    private int oboljeliId;
    private String ime;
    private String prezime;
    private String datRodenja;
    private String adresa;
    private String telefon;
    private String email;
    private String hospitaliziran;
    private int lokacija;
    private String datUpisa;

    public NovozarazeniDTO(Novozarazeni novozarazeni) {
        this.oboljeliId = novozarazeni.getOboljeliId();
        this.ime = novozarazeni.getIme();
        this.prezime = novozarazeni.getPrezime();
        this.datRodenja = novozarazeni.getDatRodenja();
        this.adresa = novozarazeni.getAdresa();
        this.telefon = novozarazeni.getTelefon();
        this.email = novozarazeni.getEmail();
        this.hospitaliziran = novozarazeni.getHospitaliziran();
        this.lokacija = novozarazeni.getLokacija();
        this.datUpisa = novozarazeni.getDatUpisa();
    }

    public int getOboljeliId() {
        return oboljeliId;
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
    public String toString(){
        return "NovozarazeniDTO{" +
                "oboljeliId='" + oboljeliId + '\'' +
                "ime='" + ime + '\'' +
                ", prezime=" + prezime + '\'' +
                ", datRodenja=" + datRodenja + '\'' +
                ", adresa=" + adresa + '\'' +
                ", telefon=" + telefon + '\'' +
                ", email=" + email + '\'' +
                ", hospitaliziran=" + hospitaliziran + '\'' +
                ", lokacija=" + lokacija + '\'' +
                ", datUpisa=" + datUpisa +
                '}';
    }

}

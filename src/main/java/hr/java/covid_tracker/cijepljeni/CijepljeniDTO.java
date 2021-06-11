package hr.java.covid_tracker.cijepljeni;


public class CijepljeniDTO {

        private String ime;
        private String prezime;
        private String datRodenja;
        private String adresa;
        private String telefon;
        private String email;
        private String datumCijepljenja;
        private int cijepivoID;

        public CijepljeniDTO(Cijepljeni cijepljeni) {
            this.ime = cijepljeni.getIme();
            this.prezime = cijepljeni.getPrezime();
            this.datRodenja = cijepljeni.getDatRodenja();
            this.adresa = cijepljeni.getAdresa();
            this.telefon = cijepljeni.getTelefon();
            this.email = cijepljeni.getEmail();
            this.datumCijepljenja = cijepljeni.getDatumCijepljenja();
            this.cijepivoID = cijepljeni.getCijepivoID();

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

    public String getDatumCijepljenja() {
        return datumCijepljenja;
    }

    public int getCijepivoID() {
        return cijepivoID;
    }

    @Override
    public String toString(){
        return "CijepljeniDTO{" +
                "ime='" + ime + '\'' +
                ", prezime=" + prezime + '\'' +
                ", datRodenja=" + datRodenja + '\'' +
                ", adresa=" + adresa + '\'' +
                ", telefon=" + telefon + '\'' +
                ", email=" + email + '\'' +
                ", datumCijepljenja=" + datumCijepljenja + '\'' +
                ", cijepivoID=" + cijepivoID +
                '}';
    }
}
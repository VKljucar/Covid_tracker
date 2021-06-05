package hr.java.covid_tracker.cijepljeni;

import java.util.Date;

public class CijepljeniDTO {

        private String ime;
        private String prezime;
        private String datRodenja;
        private String adresa;
        private String telefon;
        private String email;
        private Date datumCijepljenja;
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

    }
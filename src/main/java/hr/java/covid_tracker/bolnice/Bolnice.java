package hr.java.covid_tracker.bolnice;

import javax.persistence.*;

@Entity
@Table(name = "BOLNICE")
public class Bolnice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String naziv;

    public Bolnice() {
    }

    public Bolnice(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
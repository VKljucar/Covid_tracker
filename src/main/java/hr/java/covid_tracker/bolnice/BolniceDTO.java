package hr.java.covid_tracker.bolnice;

public class BolniceDTO {

    private int id;
    private String naziv;

    public BolniceDTO(Bolnice bolnice) {
        this.id = bolnice.getId();
        this.naziv = bolnice.getNaziv();
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

    @Override
    public String toString(){
        return "BolniceDTO{" +
                "id='" + id + '\'' +
                ", naziv=" + naziv +
                '}';
    }

}

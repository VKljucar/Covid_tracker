package hr.java.covid_tracker.model;

public class LoginDTO {

    private final String korisnickoIme;
    private final String lozinka;
    private final Type uloga;

    public LoginDTO(String korisnickoIme, String lozinka, Type uloga) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.uloga = uloga;
    }

    public LoginDTO(Login login){
        this.korisnickoIme = login.getKorisnickoIme();
        this.lozinka = login.getLozinka();
        this.uloga = login.getUloga();
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public Type getUloga() {
        return uloga;
    }

    @Override
    public String toString(){
        return "LoginDTO{"+
                "korisnickoIme='" + korisnickoIme + '\'' +
                ", uloga=" + uloga +
                '}';
    }

}

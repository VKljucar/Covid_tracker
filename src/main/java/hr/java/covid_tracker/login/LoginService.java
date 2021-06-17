package hr.java.covid_tracker.login;

import java.util.List;
import java.util.Optional;

public interface LoginService {

    List<LoginDTO> findAll();

    Optional<LoginDTO> findUser(String korisnickoIme, String lozinka);

    Optional<LoginDTO> findByKorisnickoIme(String korisnickoIme);

}

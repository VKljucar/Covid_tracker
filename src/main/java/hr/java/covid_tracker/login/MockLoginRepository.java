package hr.java.covid_tracker.login;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Profile("login-dev")
@Repository
public class MockLoginRepository implements LoginRepository {

    private final Set<Login> MOCKED_LOGIN = new HashSet<>(
            Arrays.asList(
                    new Login(1,"KorisnikIme", "KorisnikPrezime", "usr_korisnik", "lozinka123"),
                    new Login(2,"KorisnikIme2", "KorisnikPrezime2", "usr_korisnik2", "lozinka123")
            )
    );

    @Override
    public Set<Login> findAll() {
        return MOCKED_LOGIN;
    }

    @Override
    public Optional<Login> findByUsername(String username) {
        return MOCKED_LOGIN.stream().filter(it -> Objects.equals(it.getKorisnickoIme(), username)).findAny();
    }


}

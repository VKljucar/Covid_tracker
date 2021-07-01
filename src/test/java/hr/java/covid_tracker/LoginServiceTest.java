package hr.java.covid_tracker;

import hr.java.covid_tracker.login.Login;
import hr.java.covid_tracker.login.LoginDTO;
import hr.java.covid_tracker.login.LoginJpaRepository;
import hr.java.covid_tracker.login.LoginService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LoginServiceTest {

    @Autowired
    private LoginService service;

    @MockBean
    private LoginJpaRepository repository;

    @Test
    public void findAll() {

        when(repository.findAll()).thenReturn(
                Stream.of(new Login(1, "korisnik", "prezime", "TEST", "pass"),
                        new Login(1, "korisnik2", "prezime2", "test2", "pass2")).collect(Collectors.toList()));

        assertEquals(2, service.findAll().size());
    }

    @Test
    public void findByKorisnickoImeAndLozinka() {
        final String username = "user";
        final String pass = "test";

        when(repository.findByKorisnickoImeAndLozinka(username, pass)).thenReturn(
                Optional.of((new Login(1, "korisnik", "prezime", username, pass))));

        Optional<LoginDTO> user = service.findUser(username, pass);

        assertEquals(username, user.get().getUsername());
    }

    @Test
    public void findByKorisnickoIme() {
        final String username = "user";

        when(repository.findByKorisnickoIme(username)).thenReturn(
                Optional.of(new Login(1, "korisnik", "prezime", username, "pass")));

        Optional<LoginDTO> byKorisnickoIme = service.findByKorisnickoIme(username);

        assertEquals(username, byKorisnickoIme.get().getUsername());
    }

}

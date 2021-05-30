package hr.java.covid_tracker.login;

import hr.java.covid_tracker.login.Login;

import java.util.Optional;
import java.util.Set;

public interface LoginRepository {

    Set<Login> findAll();

    Optional<Login> findByUsername(String username);

}

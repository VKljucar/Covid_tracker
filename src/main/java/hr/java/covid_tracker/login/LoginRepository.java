package hr.java.covid_tracker.login;

import java.util.Optional;
import java.util.Set;

public interface LoginRepository {

    Set<Login> findAll();

    Optional<Login> findByUsername(String username);

}
